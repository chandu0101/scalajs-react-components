package demo.components

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.reactslick._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object ReactSlickDemo {

  val code = GhPagesMacros.exampleSource

  val cats = Seq(
    "https://www.petfinder.com/wp-content/uploads/2012/11/140272627-grooming-needs-senior-cat-632x475.jpg",
    "http://www.cats.org.uk/uploads/images/pages/photo_latest14.jpg",
    "https://www.petfinder.com/wp-content/uploads/2012/11/99233806-bringing-home-new-cat-632x475.jpg",
    "http://catsrusrescue.org/wp-content/uploads/2013/03/cat2.jpg",
    "http://www.aaj.tv/wp-content/uploads/2015/08/bullet_cat1.jpg",
    "https://www.catboxkingdom.com/wp-content/uploads/2014/06/Cute-Cats-cats-33440930-1280-800.jpg"
  )

  // EXAMPLE:START
  val component = ReactComponentB[Unit]("SlickDemo")
    .render(
      P =>
        <.div(
          CodeExample(code, "Demo")(
            <.div(
              ReactSlick(
                responsive = js.Array(
                  ResponsiveSetting(600, Unslick),
                  ResponsiveSetting(800, SlidesToShow(2)),
                  ResponsiveSetting(1000, SlidesToShow(3)),
                  ResponsiveSetting(9999, SlidesToShow(4))
                ),
                arrows = true,
                dots = true,
                afterChange = (num: Int) => Callback.info(s"afterChange: $num"),
                beforeChange = (from: Int, to: Int) => Callback.info(s"beforeChange: $from -> $to"),
                infinite = false,
                draggable = true
              )(
                cats map { c =>
                  <.img(^.src := c, ^.height := "200px", ^.width := "200px")
                }: _*
              )
            )
          )
      ))
    .build

  // EXAMPLE:END

  def apply() = component()

}
