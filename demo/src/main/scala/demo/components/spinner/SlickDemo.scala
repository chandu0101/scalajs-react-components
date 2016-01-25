package demo.components.spinner

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.reactslick._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object SlickDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  val cats = Seq(
    "https://www.petfinder.com/wp-content/uploads/2012/11/140272627-grooming-needs-senior-cat-632x475.jpg",
    "http://www.cats.org.uk/uploads/images/pages/photo_latest14.jpg",
    "https://www.petfinder.com/wp-content/uploads/2012/11/99233806-bringing-home-new-cat-632x475.jpg",
    "http://catsrusrescue.org/wp-content/uploads/2013/03/cat2.jpg"
  )
  
  val component = ReactComponentB[Unit]("SlickDemo")
    .render(P =>
      <.div(
        CodeExample(code, "Demo")(
          <.div(
            ReactSlick(
              arrows = true,
              dots = true,
              slidesToShow = 1,
              slidesToScroll = 1,
              afterChange = (num: Int) => Callback.info(s"afterChange: $num"),
              beforeChange = (from: Int, to: Int) => Callback.info(s"beforeChange: $from -> $to"),
              responsive =
                js.Array(
                  ResponsiveSetting(400,  SlidesToShow(1)),
                  ResponsiveSetting(600,  SlidesToShow(2)),
                  ResponsiveSetting(800,  SlidesToShow(3)),
                  ResponsiveSetting(1000, SlidesToShow(4)),
                  ResponsiveSetting(1200, Unslick)
                )
            )(
              cats map {
                c => <.img(
                  ^.src := c,
                  ^.height := "200px",
                  ^.width := "200px"
                ): ReactElement
              }:_*
            )
          )
        )
      )
    ).buildU

  // EXAMPLE:END

  def apply() = component()

}
