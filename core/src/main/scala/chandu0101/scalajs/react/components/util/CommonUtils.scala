package chandu0101.scalajs.react.components.util


import chandu0101.scalajs.react.components.all._


/**
 * Created by chandrasekharkode .
 */
object CommonUtils {

  def cssMapM(map: CssClassType, ps: (String, Boolean)*) = map.++(ps)

  def cssMap1M(clsNames: String, map: CssClassType, ps: (String, Boolean)*) = {
    if (clsNames.isEmpty) map.++(ps)
    else
      clsNames.split(" ").map(c => (c.trim, true)).toMap.++(map.++(ps))
  }

  def cssMap(clsNames: String, ps: (String, Boolean)*): Map[String, Boolean] = {
    if (clsNames.isEmpty) ps.toMap
    else
      clsNames.split(" ").map(c => (c.trim, true)).toMap.++(ps)
  }

  def parameterizeUrl(url: String, parameters: Map[String, Any]): String = {
    require(url != null, "Missing argument 'url'.")
    require(parameters != null, "Missing argument 'parameters'.")

    parameters.foldLeft(url)((base, kv) =>
      base ++ {
        if (base.contains("?")) "&" else "?"
      } ++ kv._1 ++ "=" + kv._2)
  }

}
