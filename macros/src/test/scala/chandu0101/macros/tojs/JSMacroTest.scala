package chandu0101.macros.tojs

import japgolly.scalajs.react.{Callback, CallbackTo}
import org.scalatest.FunSuite
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSON

case class Address(country: String) {
  val toJS: js.Object = JSMacro[Address](this)
}

case class Person(name: String, address: js.UndefOr[Address] = js.undefined)

class SeedType(val value: String) extends AnyVal

object SeedType {

  val RICE = new SeedType("rice")

}

case class AnyValTest(st: SeedType = SeedType.RICE)

case class Plain(name: String,
                 category: String,
                 peracre: js.UndefOr[Int] = js.undefined,
                 address: Address = null)

case class SeqTest(s: Seq[String] = Seq("dude"), as: Seq[Address] = Seq(Address("India"), null))

case class SeqUndefTest(s: js.UndefOr[Seq[String]] = Seq("dude"),
                        as: js.UndefOr[Seq[Address]] = Seq(Address("India"), null))

case class SetTest(s: Set[String] = Set("dude"),
                   as: js.UndefOr[Set[Address]] = Set(Address("India"), null))

case class ArrayTest(s: Array[String] = Array("dude"),
                     as: js.UndefOr[Array[Address]] = Array(Address("India"), null))

case class MapTest(m: Map[String, String] = Map("key" -> "0"),
                   ma: js.UndefOr[Map[String, Address]] =
                     Map("address" -> Address("India"), "address2" -> null))

case class JSDictTest(m: js.Dictionary[String] = js.Dictionary("key" -> "0"),
                      ma: js.UndefOr[js.Dictionary[Address]] =
                        js.Dictionary("address" -> Address("India"), "address2" -> null))

case class FunctionTest(fn0: () => Int = () => 5,
                        fn1: js.UndefOr[Double => String] = (d: Double) => s"$d x")

class SeedType2 private (val value: String) extends AnyVal

object SeedType2 {
  val RICE = new SeedType2("rice")
}

trait SelectOption {
  val toJS: js.Object
}

case class SampleOption(value: String = "gel", label: String = "kel") extends SelectOption {
  override val toJS: js.Object = json(value = value, label = label)
}

case class TPTest[T <: SelectOption](o: js.UndefOr[js.Array[T]])

case class AnyValTest2(st: SeedType2 = SeedType2.RICE)

import js.UndefOr.{any2undefOrA => u}
case class CallbackTest( //<ocd>
    f0: CallbackTo[Int] = CallbackTo(0),
    fu: () => CallbackTo[Int] = () => CallbackTo(0),
    f1: Int => CallbackTo[Int] = i1 => CallbackTo(i1),
    f2: (Int, Int) => CallbackTo[Int] = (i1, i2) => CallbackTo(i1 + i2),
    f3: (Int, Int, Int) => CallbackTo[Int] = (i1, i2, i3) => CallbackTo(i1 + i2 + i3),
    f0c: Callback = Callback(()),
    fuc: () => Callback = () => Callback(()),
    f1c: Int => Callback = i1 => Callback(()),
    f2c: (Int, Int) => Callback = (i1, i2) => Callback(()),
    f3c: (Int, Int, Int) => Callback = (i1, i2, i3) => Callback(()),
    f0u: js.UndefOr[CallbackTo[Int]] = u(CallbackTo(0)),
    fuu: js.UndefOr[() => CallbackTo[Int]] = u(() => CallbackTo(0)),
    f1u: js.UndefOr[Int => CallbackTo[Int]] = u(i1 => CallbackTo(i1)),
    f2u: js.UndefOr[(Int, Int) => CallbackTo[Int]] = u((i1, i2) => CallbackTo(i1 + i2)),
    f3u: js.UndefOr[(Int, Int, Int) => CallbackTo[Int]] = u(
      (i1, i2, i3) => CallbackTo(i1 + i2 + i3)))

class JSMacroTest[T <: SelectOption] extends FunSuite {

  def printResult(result: js.Any) = {
    println(s"Result is : ${JSON.stringify(result)}")
  }

  test("simple fields test") {
    val plain = JSMacro[Plain](Plain("bpt", "rice")).asInstanceOf[js.Dynamic]
    assert(plain.name.toString == "bpt")
    assert(plain.category.toString == "rice")
    assert(!plain.asInstanceOf[js.Object].hasOwnProperty("peracre"))
  }

  test("callbacks") {
    val c   = CallbackTest()
    val out = JSMacro[CallbackTest](c).asInstanceOf[js.Dynamic]

    assert(0 == out.f0.apply().asInstanceOf[Int])
    assert(0 == out.fu.apply(()).asInstanceOf[Int])
    assert(1 == out.f1.apply(1).asInstanceOf[Int])
    assert(2 == out.f2.apply(1, 1).asInstanceOf[Int])
    assert(3 == out.f3.apply(1, 1, 1).asInstanceOf[Int])
    assert(0 == out.f0u.apply().asInstanceOf[Int])
    assert(0 == out.fuu.apply(()).asInstanceOf[Int])
    assert(1 == out.f1u.apply(1).asInstanceOf[Int])
    assert(2 == out.f2u.apply(1, 1).asInstanceOf[Int])
    assert(3 == out.f3u.apply(1, 1, 1).asInstanceOf[Int])
    assert(out.f0c.apply().isInstanceOf[Unit])
    assert(out.fuc.apply(()).isInstanceOf[Unit])
    assert(out.f1c.apply(1).isInstanceOf[Unit])
    assert(out.f2c.apply(1, 1).isInstanceOf[Unit])
    assert(out.f3c.apply(1, 1, 1).isInstanceOf[Unit])
  }

  test("should handle seq") {
    val result = JSMacro[SeqTest](SeqTest()).asInstanceOf[js.Dynamic]
    println(s"result array ${JSON.stringify(result)}")
    assert(result.s.asInstanceOf[js.Array[String]].head == "dude")
    assert(
      result.as
        .asInstanceOf[js.Array[js.Dictionary[String]]]
        .head("country") == "India")

    val result2 = JSMacro[SeqUndefTest](SeqUndefTest()).asInstanceOf[js.Dynamic]
    println(s"result2 array ${JSON.stringify(result2)}")
    assert(result2.s.asInstanceOf[js.Array[String]].head == "dude")
    assert(
      result2.as
        .asInstanceOf[js.Array[js.Dictionary[String]]]
        .head("country") == "India")
  }

  test("should handle sets") {
    val result = JSMacro[SetTest](SetTest()).asInstanceOf[js.Dynamic]
    assert(result.s.asInstanceOf[js.Array[String]].head == "dude")
    assert(
      result.as
        .asInstanceOf[js.Array[js.Dictionary[String]]]
        .head("country") == "India")
  }

  test("should handle arrays") {
    val result = JSMacro[ArrayTest](ArrayTest()).asInstanceOf[js.Dynamic]
    assert(result.s.asInstanceOf[js.Array[String]].head == "dude")
    assert(
      result.as
        .asInstanceOf[js.Array[js.Dictionary[String]]]
        .head("country") == "India")
  }

  test("should handle maps") {
    val result = JSMacro[MapTest](MapTest()).asInstanceOf[js.Dynamic]
    assert(result.m.asInstanceOf[js.Dictionary[String]].get("key").get == "0")
    assert(
      result.ma
        .asInstanceOf[js.Dictionary[js.Dynamic]]
        .get("address")
        .get
        .country
        .toString == "India")
  }

  test("should handle js.Dictionary") {
    val result = JSMacro[JSDictTest](JSDictTest()).asInstanceOf[js.Dynamic]
    assert(result.m.asInstanceOf[js.Dictionary[String]].get("key").get == "0")
    assert(
      result.ma
        .asInstanceOf[js.Dictionary[js.Dynamic]]
        .get("address")
        .get
        .country
        .toString == "India")
  }

  test("should handle functions") {
    val result = JSMacro[FunctionTest](FunctionTest()).asInstanceOf[js.Dynamic]
    assert(result.fn0.asInstanceOf[js.Function0[Int]]() == 5)
    assert(result.fn1.asInstanceOf[js.Function1[Double, String]](1.2) == "1.2 x")
  }

  test("should handle any vals") {
    val result = JSMacro[AnyValTest2](AnyValTest2()).asInstanceOf[js.Dynamic]
    assert(result.st.toString == "rice")
  }

  test("should work with custom traits") {
    val result = JSMacro[TPTest[SampleOption]](TPTest(js.Array(SampleOption())))
    printResult(result)
  }
}
