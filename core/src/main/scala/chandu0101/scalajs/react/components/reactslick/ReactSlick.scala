package chandu0101.scalajs.react.components.reactslick

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._

import scala.scalajs.js

case class ReactSlick(
                      /* Additional class name for the inner slider div */
                      className: js.UndefOr[Int] = js.undefined,
                      /* Adjust the slide's height automatically */
                      adaptiveHeight: js.UndefOr[Boolean] = js.undefined,
                      /* Should we show Left and right nav arrows */
                      arrows: js.UndefOr[Boolean] = js.undefined,
                      /* Should the scroller auto scroll? */
                      autoplay: js.UndefOr[Boolean] = js.undefined,
                      /* delay between each auto scoll. in ms */
                      autoplaySpeed: js.UndefOr[Int] = js.undefined,
                      /* Should we centre to a single item? */
                      centerMode: js.UndefOr[Boolean] = js.undefined,
                      /* Should we show the dots at the bottom of the gallery */
                      dots: js.UndefOr[Boolean] = js.undefined,
                      /* Class applied to the dots if they are enabled */
                      dotsClass: js.UndefOr[Int] = js.undefined,
                      /* Is the gallery scrollable via dragging on desktop? */
                      draggable: js.UndefOr[Boolean] = js.undefined,
                      /* Slides use fade for transition */
                      fade: js.UndefOr[Boolean] = js.undefined,
                      /* should the gallery wrap around it's contents */
                      infinite: js.UndefOr[Boolean] = js.undefined,
                      /* which item should be the first to be displayed */
                      initialSlide: js.UndefOr[Int] = js.undefined,
                      /* Loads images or renders components on demands */
                      lazyLoad: js.UndefOr[Boolean] = js.undefined,
                      /* Array of objects in the form of { breakpoint: int, settings: { ... } } The breakpoint int is the maxWidth so the settings will be applied when resolution is below this value. Breakpoints in the array should be ordered from smalles to greatest. Use 'unslick' in place of the settings object to disable rendering the carousel at that breakpoint. Example: [ { breakpoint: 768, settings: { slidesToShow: 3 } }, { breakpoint: 1024, settings: { slidesToShow: 5 } }, { breakpoint: 100000, settings: 'unslick' } ] */
                      responsive: js.UndefOr[js.Array[ResponsiveSetting]] = js.undefined,
                      /* Reverses the slide order */
                      rtl: js.UndefOr[Boolean] = js.undefined,
                      /* Number of slides to be visible at a time */
                      slidesToShow: js.UndefOr[Int] = js.undefined,
                      /* Number of slides to scroll for each navigation item */
                      slidesToScroll: js.UndefOr[Int] = js.undefined,
                      /* Enable/Disable CSS Transitions */
                      useCSS: js.UndefOr[Boolean] = js.undefined,
                      /* callback function called after the current index changes */
                      afterChange: js.UndefOr[Int => Callback] = js.undefined,
                      /* callback function called before the current index changes */
                      beforeChange: js.UndefOr[(Int, Int) => Callback] = js.undefined,
                      /* go to the specified slide number */
                      slickGoTo: js.UndefOr[Int] = js.undefined) {

  def apply(children: ReactElement*) = {
    val f =
      React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.ReactSlick)
    val props = JSMacro[ReactSlick](this)

    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]

  }
}
