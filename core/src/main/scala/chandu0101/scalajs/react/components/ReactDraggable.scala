package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.HtmlTopNode
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import org.scalajs.dom._

import scala.scalajs.js
import scalacss.ScalaCssReact._

case class RPoint(x: Double, y: Double)
case class RGrid(width: Double, height: Double)
case class RElementPosition(element: Element, top: Double = 0, left: Double = 0, right: Double = 0, bottom: Double = 0)
case class ClientRect(top: Double,left: Double)

object ReactDraggable {

  val cssSettings = scalacss.devOrProdDefaults
  import cssSettings._

  object Style extends StyleSheet.Inline {
    import dsl._
    val draggable       = style(position.relative)
    val draggableActive = style(userSelect := "none")
  }

  import RCustomStyles._
  type CssClassType = Map[String, Boolean]

  object DomUtil {

    def offset(element: HtmlTopNode) = {
      val rect = element.getBoundingClientRect()
      var scrollTop = 0.0
      var scrollLeft = 0.0
      if(dom.document.body.scrollTop > 0) {
        scrollTop = dom.document.body.scrollTop.toInt
        scrollLeft = dom.document.body.scrollLeft.toInt
      } else if(dom.document.documentElement.scrollTop >0) { // for firefox
        scrollTop = dom.document.documentElement.scrollTop
        scrollLeft = dom.document.documentElement.scrollLeft
      }
      ClientRect(rect.top + scrollTop, rect.left + scrollLeft )
    }

    /**
      *  https://developer.mozilla.org/en-US/docs/Web/API/Element.matches#Browser_compatibility
      * @param element dom element
      * @param selector css selector
      */
    def matchesSelector(element: js.Dynamic)(selector: String): Boolean = {
      val funcName =  Stream("matches",
        "webkitMatchesSelector",
        "mozMatchesSelector",
        "msMatchesSelector",
        "oMatchesSelector").filter(name => !js.isUndefined(element.selectDynamic(name))).head
      element.selectDynamic(funcName).call(element,selector).asInstanceOf[Boolean]
    }

    /**
      *  onTouchStart - / works on most browsers
      *  onmsgesturechange - works on ie10 on ms surface
      * @return whether device is touch enabled or not
      */
    def isTouchDevice = dom.window.hasOwnProperty("ontouchstart") || dom.window.hasOwnProperty("onmsgesturechange")

    def dragEventFor(e:Event, name: String) = name match {
      case "start" => if (e.`type`.contains("touch")) "touchstart" else "mousedown"
      case "move"  => if (e.`type`.contains("touch")) "touchmove"  else "mousemove"
      case "end"   => if (e.`type`.contains("touch")) "touchend"   else "mouseup"
    }

    def getControlPosition(e: Event): RPoint =
      if (e.`type`.contains("touch")) {
        val position = e.asInstanceOf[TouchEvent].touches(0)
        RPoint(position.clientX, position.clientY)
      } else {
        val position = e.asInstanceOf[MouseEvent]
        RPoint(position.clientX, position.clientY)
      }

    def isLeftClick(e: Event) =
      e.`type` == "touchstart" || e.asInstanceOf[MouseEvent].button == 0

  }

  case class Props(cancel: js.UndefOr[String],
                   onDrag: js.UndefOr[(Event, RElementPosition) => Callback],
                   useCSSTransforms: Boolean,
                   clsNames: CssClassType,
                   moveOnStartChange: Boolean,
                   grid: js.UndefOr[RGrid],
                   zIndex: Int,
                   axis: String,
                   onStop: js.UndefOr[(Event, RElementPosition) => Callback],
                   start: RPoint,
                   onStart: js.UndefOr[(Event, RElementPosition) => Callback],
                   onMouseDown: js.UndefOr[Event => Callback],
                   handle: js.UndefOr[String],
                   minConstraints: js.UndefOr[RGrid],
                   maxConstraints: js.UndefOr[RGrid])

  /**
   * @param dragging whether or not currently dragging
   * @param startX Start left of t.getDOmNode()
   * @param startY Start top of t.getDOmNode()
   * @param offsetX Offset between start left and mouse left
   * @param offsetY Offset between start top and mouse top
   * @param clientX Current left of this.getDOMNode
   * @param clientY Current top of this.getDOMNode
   */
  case class State(
    dragging: Boolean,
    startX: Int,
    startY: Int,
    offsetX: Int,
    offsetY: Int,
    clientX: Int,
    clientY: Int,
    stopListening: js.UndefOr[Callback]
  )

  implicit val r0 = Reusability.byRef[Props]
  implicit val r1 = Reusability.byRef[State]

  class Backend(t: BackendScope[Props, State]) {
    
    def pos(S: State): CallbackTo[RElementPosition] =
      t.getDOMNode.map(e => RElementPosition(t.getDOMNode.runNow(), top = S.clientY, left = S.clientX))

    def handleDragStart(P: Props)(e: Event): Callback = {
      val moveEventType = DomUtil.dragEventFor(e, "move")
      val endEventType  = DomUtil.dragEventFor(e, "end")
      val dragPoint     = DomUtil.getControlPosition(e)

      val mouseDown: Callback =
        P.onMouseDown.asCbo(e)

      val onStart: Callback =
        t.state.flatMap(pos).flatMap(p => P.onStart.asCbo(e, p))

      val startDrag = t.modState { S =>
        val u1 = Events.register(dom.window, moveEventType, handleDrag(P))
        val u2 = Events.register(dom.window, endEventType, handleDragEnd(P))

        S.copy(
          dragging      = true,
          offsetX       = dragPoint.x.toInt - S.clientX,
          offsetY       = dragPoint.y.toInt - S.clientY,
          stopListening = u1 >> u2
        )
      }

      val matches: Boolean = {
        val matchesTarget = DomUtil.matchesSelector(e.target.asInstanceOf[js.Dynamic]) _
        P.handle.fold(true)(matchesTarget) && P.cancel.fold(true)(matchesTarget)
      }

      mouseDown << (onStart >> startDrag).when(DomUtil.isLeftClick(e) && matches).void
    }

    def handleDrag(P: Props)(e: Event): Callback = {
      val dragPoint = DomUtil.getControlPosition(e)

      val c1 = t.modState{ S =>

        // calculate top and left
        var clientX   = S.startX + (dragPoint.x - S.offsetX)
        var clientY   = S.startY + (dragPoint.y - S.offsetY)

        // Snap to grid if prop has been provided
        P.grid.foreach{ (grid: RGrid) =>
          val directionX = if (clientX < S.clientX) -1 else 1
          val directionY = if (clientY < S.clientY) -1 else 1

          clientX =
            if (math.abs(clientX - S.clientX) >= grid.width)
              S.clientX + (grid.width * directionX)
            else S.clientX
          clientY =
            if (math.abs(clientY - S.clientY) >= grid.height)
              S.clientY + (grid.height * directionY)
            else S.clientY
        }

        //min/max contraints
        P.minConstraints.foreach{ (min: RGrid) =>
          clientX = math.max(min.width, clientX)
          clientY = math.max(min.height, clientY)
        }

        P.maxConstraints.foreach{ (max: RGrid) =>
          clientX = math.min(max.width, clientX)
          clientY = math.min(max.height, clientY)
        }

        // Update top and left
        S.copy(clientX = clientX.toInt, clientY = clientY.toInt)
      }

      //call event handler
      val c2 = t.state.flatMap(pos).flatMap(p => P.onDrag.asCbo(e, p))

      c1 >> c2
    }

    def handleDragEnd(P: Props)(e: Event): Callback = {
      val unregister: Callback =
        t.state.flatMap(_.stopListening.asCbo)
      val onStop: Callback =
        t.state.flatMap(pos).flatMap(p => P.onStop.asCbo(e, p))
      val stopDragging: Callback =
        t.modState(_.copy(dragging = false, stopListening = js.undefined))

      unregister >> onStop >> stopDragging
    }

    def canDragY(P: Props): Boolean =
      P.axis == "both" || P.axis == "y"

    def canDragX(P: Props): Boolean =
      P.axis == "both" || P.axis == "x"

    private val transforms = Seq(^.transform, mozTransform, WebkitTransform, msTransform)

    def positionToCSSTransform(left: Int, top: Int): TagMod =
      transforms.map(_ := s"translate(${left}px, ${top}px)").toTagMod

    def render(P: Props, S: State, C: PropsChildren) = {
      val topValue: Int =
        if (canDragY(P)) S.clientY else S.startY
      val leftValue: Int =
        if (canDragX(P)) S.clientX else S.startX
      val stl: TagMod =
        if (P.useCSSTransforms) positionToCSSTransform(leftValue, topValue)
        else                    Seq(^.top := topValue.toString, ^.left := leftValue.toString).toTagMod

      def onDragStart(e: ReactUIEvent) = CallbackTo(e.nativeEvent).flatMap(handleDragStart(P))
      def onDragEnd(e: ReactUIEvent) = CallbackTo(e.nativeEvent).flatMap(handleDragEnd(P))

      <.div(
        Style.draggable,
        Style.draggableActive.when(S.dragging),
        stl,
        ^.onMouseDown  ==> onDragStart,
        ^.onTouchStart ==> onDragStart,
        ^.onMouseUp    ==> onDragEnd,
        ^.onTouchEnd   ==> onDragEnd
      )(C)
    }
  }
  
  def newStateFrom(P: Props): State =
    State(
      dragging = false,
      startX  = 0,
      startY  = 0,
      clientX = P.start.x.toInt,
      clientY = P.start.y.toInt,
      offsetX = 0,
      offsetY = 0,
      stopListening = js.undefined
    )
  
  val component = ScalaComponent.builder[Props]("ReactDraggable")
    .initialStateFromProps(newStateFrom)
    .renderBackendWithChildren[Backend]
    .componentWillReceiveProps {
      c => c.setState(newStateFrom(c.nextProps)).when(c.nextProps.moveOnStartChange).void
    }
    .configure(Reusability.shouldComponentUpdate)
    .componentWillUnmount($ => $.state.stopListening.getOrElse(Callback.empty))
    .build

  /**
   *
   * @param cancel specifies a selector to be used to prevent drag initialization.
   * @param onDrag  Called while dragging
   * @param useCSSTransforms if true will place the element using translate(x, y)
   *                         rather than CSS top/left.
   *                         This generally gives better performance, and is useful in combination with
   *                         other layout systems that use translate(), such as react-grid-layout.
   * @param clsNames css class names map
   * @param moveOnStartChange tells the Draggable element to reset its position
   *                          if the `start` parameters are changed. By default, if the `start`
   *                          parameters change, the Draggable element still remains where it started
   *                          or was dragged to.
   * @param grid specifies the x and y that dragging should snap to.
   * @param zIndex specifies the zIndex to use while dragging.
   * @param axis determines which axis the draggable can move.(both,x,y)
   * @param onStop Called when dragging stops
   * @param start specifies the x and y that the dragged item should start at
   * @param onStart Called when dragging starts.
   * @param onMouseDown  * A workaround option which can be passed if onMouseDown needs to be accessed,
   *                     since it'll always be blocked (due to that there's internal use of onMouseDown)
   * @param handle specifies a selector to be used as the handle that initiates drag.
   * @param children
   * @return
   */
  def apply(cancel: js.UndefOr[String] = js.undefined,
            onDrag: js.UndefOr[(Event, RElementPosition) => Callback] = js.undefined,
            useCSSTransforms: Boolean = false,
            clsNames: CssClassType = Map(),
            moveOnStartChange: Boolean = false,
            grid: js.UndefOr[RGrid] = js.undefined,
            zIndex: Int = 0,
            axis: String = "both",
            onStop: js.UndefOr[(Event, RElementPosition) => Callback] = js.undefined,
            start: RPoint = RPoint(0, 0),
            onStart: js.UndefOr[(Event, RElementPosition) => Callback] = js.undefined,
            onMouseDown: js.UndefOr[Event => Callback] = js.undefined,
            handle: js.UndefOr[String] = js.undefined,
            minConstraints: js.UndefOr[RGrid] = js.undefined,
            maxConstraints: js.UndefOr[RGrid] = js.undefined)
           (children: VdomNode) =
    component(
      Props(
        cancel = cancel,
        onDrag = onDrag,
        useCSSTransforms = useCSSTransforms,
        clsNames = clsNames,
        moveOnStartChange = moveOnStartChange,
        grid = grid,
        zIndex = zIndex,
        axis = axis,
        onStop = onStop,
        start = start,
        onStart = onStart,
        onMouseDown = onMouseDown,
        handle = handle,
        minConstraints = minConstraints,
        maxConstraints = maxConstraints
      )
    )(children)
}
