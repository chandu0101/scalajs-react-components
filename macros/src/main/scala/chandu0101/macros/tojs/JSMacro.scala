package chandu0101.macros.tojs

import scala.collection.{GenMap, GenTraversableOnce}
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context
import scala.scalajs.js

/**
 * modified version of https://github.com/wav/scala-macros/blob/master/src/main/scala/wav/common/scalajs/macros/Macros.scala
 * via https://github.com/chandu0101/macros/blob/master/src/main/scala/chandu0101/macros/tojs/JSMacro.scala
 */
object JSMacro {
  val REGULAR = "regular"

  val UNDEFS = "undefs"

  type TOJS = {
    val toJS: js.Object
  }

  implicit def apply[T]: T => js.Object = macro tojs_macro_impl[T]

  def tojs_macro_impl[T: c.WeakTypeTag](c: Context): c.Tree = {
    import c.universe._
    val tpe = c.weakTypeOf[T]
    val fields = tpe.decls.collectFirst {
      case m: MethodSymbol if m.isPrimaryConstructor => m
    }.get.paramLists.head

    def isNotPrimitiveAnyVal(tpe: Type) = {
      !tpe.typeSymbol.fullName.startsWith("scala.")
    }
    val rawParams = fields.map { field =>
      val name = field.asTerm.name
      val decoded = name.decodedName.toString
      val symToJs = typeOf[TOJS].typeSymbol
      val returnType = field.typeSignature
      def getJSValueTree(returnType: Type, undef: Boolean = false) = {
        if (returnType <:< typeOf[TOJS])
          if (undef) q"""v.toJS""" else q"""if(t.$name == null) null else  t.$name.toJS"""
        else if (returnType <:< typeOf[Enumeration#Value])
          if (undef) q"""v.toString()""" else q"""t.$name.toString()"""
        else if (returnType <:< typeOf[AnyVal] && isNotPrimitiveAnyVal(returnType))
          if (undef) q"""v.value""" else q"""t.$name.value"""
        else if (returnType <:< typeOf[GenMap[String, _]] &&
          returnType.typeArgs(1) <:< typeOf[TOJS])
          if (undef) q"""v.map{ case (k, o) => k -> (if(o == null) null else o.toJS)}.toJSDictionary""" else q"""t.$name.map{ case (k, o) => k -> (if(o == null) null else o.toJS) }.toJSDictionary"""
        else if (returnType <:< typeOf[GenMap[String, _]])
          if (undef) q"""v.toJSDictionary""" else q"""t.$name.toJSDictionary"""
        else if ((returnType <:< typeOf[GenTraversableOnce[_]] ||
          returnType <:< typeOf[Array[_]]) &&
          returnType.typeArgs(0) <:< typeOf[TOJS])
          if (undef) q"""v.map((o: $symToJs) => if(o == null) null else o.toJS).toJSArray""" else q"""t.$name.map((o: $symToJs) => if(o == null) null else o.toJS).toJSArray"""
        else if ((returnType <:< typeOf[GenTraversableOnce[_]] ||
          returnType <:< typeOf[Array[_]]))
          if (undef) q"""v.toJSArray""" else q"""t.$name.toJSArray"""
        else if (returnType <:< typeOf[js.Dictionary[_]] &&
          returnType.typeArgs(0) <:< typeOf[TOJS])
          if (undef) q"""v.map{ case(k, o) => (k, if(o == null) null else o.toJS)}.toJSDictionary""" else q"""t.$name.map{ case (k: String, o: $symToJs) => (k, if(o == null) null else o.toJS)}.toJSDictionary"""
        else if (returnType <:< typeOf[js.Array[_]] &&
          returnType.typeArgs(0) <:< typeOf[TOJS])
          if (undef) q"""v.map((o: $symToJs) => if(o == null) null else o.toJS)""" else q"""t.$name.map((o: $symToJs) => if(o == null) null else o.toJS)"""
        else
        if (undef) q"""v""" else q"""t.$name"""
      }

      if (returnType <:< typeOf[Option[_]] ||
        returnType <:< typeOf[js.UndefOr[_]]) {
        val arg0 = returnType.typeArgs(0)
        val valueTree = getJSValueTree(arg0, true)
        (UNDEFS, q"""t.$name.foreach(v => p.updateDynamic($decoded)($valueTree))""")
      }
      else {
        val jsValueTree = getJSValueTree(returnType)
        (REGULAR, q"""$decoded -> $jsValueTree """)
      }

    }


    def getTrees(key: String) = rawParams.filter(_._1 == key).map(_._2)

    val params = getTrees(REGULAR)
    val undefs = getTrees(UNDEFS)

    q""" (t: $tpe) => {
          import scala.language.reflectiveCalls
          import scalajs.js.JSConverters._
          val p = scala.scalajs.js.Dynamic.literal(..$params)
            ..$undefs
           p
        }
       """
  }

}
