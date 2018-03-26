package chandu0101.macros.tojs

import japgolly.scalajs.react.vdom.{TagOf, VdomElement, VdomNode}
import japgolly.scalajs.react.{CallbackTo, raw}

import scala.collection.{GenMap, GenTraversableOnce}
import scala.language.existentials
import scala.language.experimental.macros
import scala.reflect.macros.blackbox
import scala.scalajs.js

/**
  * modified version of https://github.com/wav/scala-macros/blob/master/src/main/scala/wav/common/scalajs/macros/Macros.scala
  * via https://github.com/chandu0101/macros/blob/master/src/main/scala/chandu0101/macros/tojs/JSMacro.scala
  */
object JSMacro {
  type TOJS = {
    val toJS: js.Object
  }

  def apply[T]: T => js.Object = macro applyImpl[T]


  def applyImpl[T: c.WeakTypeTag](c: blackbox.Context): c.Tree = {
    import c.universe._

    def isOptional(tpe: Type): Boolean =
      tpe <:< typeOf[Option[_]] || tpe <:< typeOf[js.UndefOr[_]]

    def isNotPrimitiveAnyVal(tpe: Type) =
      !tpe.typeSymbol.fullName.startsWith("scala.")

    def flattenUnion(tpe: Type, breaker: Set[Type]): List[Type] =
      if (tpe <:< typeOf[js.|[_, _]] && !(tpe <:< typeOf[Null])) {
        val first     = tpe.dealias.typeArgs(0)
        val second    = tpe.dealias.typeArgs(1)

        val one = if (breaker(first)) Nil else flattenUnion(first, breaker + first)
        val two = if (breaker(second)) Nil else flattenUnion(second, breaker + second)
        one ++ two

      } else List(tpe)

    def getJSValueTree(target: Tree, rt: Type): Tree = {
      if (rt <:< typeOf[TOJS])
        q"""if ($target != null) $target.toJS else null"""

      /* scala collections */
      else if (rt <:< typeOf[GenMap[String, _]])
        if (rt.typeArgs(1) <:< typeOf[TOJS])
          q"""$target.map{ case (k, o) => k -> (if(o == null) null else o.toJS)}.toJSDictionary"""
        else
          q"""$target.toJSDictionary"""
      else if (rt <:< typeOf[GenTraversableOnce[_]] || (rt <:< typeOf[Array[_]]))
        if (rt.typeArgs.head <:< typeOf[TOJS])
          q"""$target.map(o => if(o == null) null else o.toJS).toJSArray"""
        else
          q"""$target.toJSArray"""

      /* javascript collections. Only need to rewrite if type parameter is <:< TOJS */
      else if (rt <:< typeOf[js.Dictionary[_]] && rt.typeArgs.head <:< typeOf[TOJS])
        q"""$target.map{case(k, o) => (k, if(o == null) null else o.toJS)}.toJSDictionary"""
      else if (rt <:< typeOf[js.Array[_]] && rt.typeArgs.head <:< typeOf[TOJS])
        q"""$target.map(o => if(o == null) null else o.toJS)"""

      /* rewrite functions returning a Callback so that javascript land can call them */
      else if (rt <:< typeOf[CallbackTo[_]])
        q"""$target.toJsFn"""
      else if (rt <:< typeOf[Function0[CallbackTo[_]]])
        q"""$target().toJsFn"""
      else if (rt <:< typeOf[Function1[_, CallbackTo[_]]])
        q"""js.Any.fromFunction1(((t0: ${rt.typeArgs(0)}) => $target(t0).runNow()))"""
      else if (rt <:< typeOf[Function2[_, _, CallbackTo[_]]])
        q"""js.Any.fromFunction2(((t0: ${rt.typeArgs(0)}, t1: ${rt.typeArgs(1)}) => $target(t0, t1).runNow()))"""
      else if (rt <:< typeOf[Function3[_, _, _, CallbackTo[_]]])
        q"""js.Any.fromFunction3(((t0: ${rt.typeArgs(0)}, t1: ${rt.typeArgs(1)}, t2: ${rt.typeArgs(2)}) => $target(t0, t1, t2).runNow()))"""
      else if (rt <:< typeOf[Function0[_]])
        q"""js.Any.fromFunction0($target)"""
      else if (rt <:< typeOf[Function1[_, _]])
        q"""js.Any.fromFunction1($target)"""
      else if (rt <:< typeOf[Function2[_, _, _]])
        q"""js.Any.fromFunction2($target)"""
      else if (rt <:< typeOf[Function3[_, _, _, _]])
        q"""js.Any.fromFunction3($target)"""

      /* other scalajs-react things we need to rewrite */
      else if (rt <:< typeOf[VdomElement])
        q"""$target.rawElement.asInstanceOf[js.Any]"""
      else if (rt <:< typeOf[VdomNode])
        q"""$target.rawNode.asInstanceOf[js.Any]"""
      else if (rt <:< typeOf[TagOf[_]])
        q"""$target.render.rawElement.asInstanceOf[js.Any]"""

      //this is to make raw.React.Node work
      else if (rt <:< typeOf[raw.recursiveTypeAliases.ChildrenArray[_]])
        q"""$target.asInstanceOf[js.Any]"""

      /* Other values. Keep AnyVal below at least CallbackTo */
      else if (rt <:< typeOf[AnyVal] && isNotPrimitiveAnyVal(rt))
        q"""$target.value.asInstanceOf[js.Any]"""
      else if (rt <:< typeOf[AnyVal] || rt <:< typeOf[String] || rt <:< typeOf[js.Any])
        q"""$target.asInstanceOf[js.Any]"""
      else if (rt <:< typeOf[Enumeration#Value])
        q"""$target.toString.asInstanceOf[js.Any]"""
      else if (rt <:< typeOf[js.|[_, _]]) {

        val (jsTypes, scalaTypes) = flattenUnion(rt, Set(rt)).distinct.partition(_ <:< typeOf[js.Any])

        val scalaCases = scalaTypes.map(
          tpe => cq"""x: $tpe => ${getJSValueTree(q"x", tpe)}"""
        )

        if (jsTypes.size > 1) {
          c.warning(target.pos, s"Cannot differentiate ${jsTypes.mkString(", ")}")
        }

        val jsCase = jsTypes.take(1).map(tpe => cq"""x => x.asInstanceOf[js.Any]""")

        q"""($target: scala.Any) match {
          case ..$scalaCases
          case ..$jsCase
        }"""
      }
      else {
        val conversion = c.inferImplicitView(target, rt, typeOf[js.Any], silent = true)
        if (conversion == EmptyTree) {
          throw new RuntimeException(s"Don't know how to convert $rt to js.Any")
        }
        q"""$conversion($target)"""
      }
    }

    val tpe    = c.weakTypeOf[T]
    val target = c.freshName[TermName](TermName("t"))
    val props  = c.freshName[TermName](TermName("p"))

    val fieldSymbols: List[Symbol] = tpe.decls
      .collectFirst {
        case m: MethodSymbol if m.isPrimaryConstructor => m
      }
      .get
      .paramLists
      .head

    val fieldUpdates = fieldSymbols.map { f =>
      val name    = f.asTerm.name
      val decoded = name.decodedName.toString

      val res = if (isOptional(f.typeSignature)) {
        val valueTree = getJSValueTree(q"v", f.typeSignature.typeArgs.head)
        q"""$target.$name.foreach(v => $props.updateDynamic($decoded)($valueTree))"""
      } else {
        val valueTree = getJSValueTree(q"$target.$name", f.typeSignature)
        q"""$props.updateDynamic($decoded)($valueTree)"""
      }
      res
    }

    q""" ($target: $tpe) => {
      val $props = scala.scalajs.js.Dynamic.literal()
      ..$fieldUpdates
      $props
    }"""
  }
}
