package chandu0101.macros.tojs

import scala.collection.{GenMap, GenTraversableOnce}
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

  implicit def apply[T]: T => js.Object = macro applyImpl[T]

  def applyImpl[T: c.WeakTypeTag](c: blackbox.Context): c.Tree = {
    import c.universe._

    def isOptional(tpe: Type): Boolean =
      tpe <:< typeOf[Option[_]] || tpe <:< typeOf[js.UndefOr[_]]

    def isNotPrimitiveAnyVal(tpe: Type) =
      !tpe.typeSymbol.fullName.startsWith("scala.")

    val tpe = c.weakTypeOf[T]

    val fieldsAll: List[Symbol] = tpe.decls.collectFirst {
      case m: MethodSymbol if m.isPrimaryConstructor => m
    }.get.paramLists.head

    val (fieldUndefs, fieldsNormal) = fieldsAll.partition(f => isOptional(f.typeSignature))

    def getJSValueTree(target: Tree, rt: Type) = {

      if (rt <:< typeOf[TOJS])
        q"""if ($target != null) $target.toJS else null"""
      else if (rt <:< typeOf[Enumeration#Value])
        q"""$target.toString()"""
      else if (rt <:< typeOf[AnyVal] && isNotPrimitiveAnyVal(rt))
        q"""$target.value"""
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
      else if (rt <:< typeOf[js.Dictionary[_]] && rt.typeArgs.head <:< typeOf[TOJS])
        q"""$target.map{case(k, o) => (k, if(o == null) null else o.toJS)}.toJSDictionary"""
      else if (rt <:< typeOf[js.Array[_]] && rt.typeArgs.head <:< typeOf[TOJS])
        q"""$target.map(o => if(o == null) null else o.toJS)"""
      else
        q"""$target"""
    }

    val target = TermName("t")

    val undefs: List[Tree] = fieldUndefs.map { f =>
      val name      = f.asTerm.name
      val decoded   = name.decodedName.toString
      val valueTree = getJSValueTree(q"v", f.typeSignature.typeArgs.head)
      q"""$target.$name.foreach(v => p.updateDynamic($decoded)($valueTree))"""
    }

    val params: List[Tree] = fieldsNormal.map { f =>
      val name       = f.asTerm.name
      val decoded    = name.decodedName.toString
      val valueTree  = getJSValueTree(q"$target.$name", f.typeSignature)
      q"""$decoded -> $valueTree"""
    }

    q""" ($target: $tpe) => {
      import scala.language.reflectiveCalls
      import scalajs.js.JSConverters._
      val p = scala.scalajs.js.Dynamic.literal(..$params)
        ..$undefs
       p
    }"""
  }
}
