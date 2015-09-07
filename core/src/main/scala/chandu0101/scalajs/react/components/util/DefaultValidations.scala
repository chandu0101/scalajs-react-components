package chandu0101.scalajs.react.components.util

import scala.util.Try


object DefaultValidations {

  private  def isValidEmail(email : String): Boolean = if("""^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$""".r.findFirstIn(email) == None)false else true

  val notEmpty = (value : Any) => if(value.toString.isEmpty) "value must not be empty" else ""

  val number = (value : Any) => if(Try(value.toString.toDouble).isFailure) "must be a number" else ""

  val email = (value : Any) => if(!isValidEmail(value.toString)) "value must be an email" else ""

}
