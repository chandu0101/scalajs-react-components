package chandu0101.scalajs.react.components
package draggables

import chandu0101.scalajs.react.components.models.{RElementPosition, RGrid, RPoint}
import chandu0101.scalajs.react.components.util.{DomUtil, Events}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.Event
import scala.scalajs.js

object ReactDraggable {
  /**
   * @param dragging whether or not currently dragging
   * @param startX Start left of t.getDOmNode()
   * @param startY Start top of t.getDOmNode()
   * @param offsetX Offset between start left and mouse left
   * @param offsetY Offset between start top and mouse top
   * @param clientX Current left of this.getDOMNode()
   * @param clientY Current top of this.getDOMNode()
   */
  case class State(
    dragging: Boolean, 
    startX: Int = 0, 
    startY: Int = 0, 
    offsetX: Int = 0, 
    offsetY: Int = 0, 
    clientX: Int = 0, 
    clientY: Int = 0,
    stopListening: U[Callback]
  )
  implicit val r0 = Reusability.byRef[Props]
  implicit val r1 = Reusability.byRef[State]

  // Add a class to the body to disable user-select. This prevents text from
  // being selected all over the page.
  object hack {
    val draggableActive = "react-draggable-active"
    
    val disableUserSelect: Callback =
      Callback(DomUtil.addClass(dom.document.body, draggableActive))
    
    val enableUserSelect: Callback =
      Callback(DomUtil.removeClass(dom.document.body, draggableActive))
  }

  class Backend(t: BackendScope[Props, State]) {
    
    def createUIEvent(S: State) =
      RElementPosition(t.getDOMNode(), top = S.clientY, left = S.clientX)

    def handleDragStart(P: Props)(e: Event): Callback = {
      val mouseDown: Callback =
        P.onMouseDown.asCbo(e)

      val onStart: Callback =
        t.state.flatMap(S => P.onStart.asCbo(e, createUIEvent(S)))
      
      val startDrag = t.modState { S =>
        val u1 = Events.register(dom.window, DomUtil.dragEventFor(e, "move"), handleDrag(P))
        val u2 = Events.register(dom.window, DomUtil.dragEventFor(e, "end"),  handleDragEnd(P))

        val dragPoint = DomUtil.getControlPosition(e)

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

      mouseDown << (onStart >> hack.disableUserSelect >> startDrag).conditionally(DomUtil.isLeftClick(e) && matches).void
    }

    def handleDrag(P: Props)(e: Event): Callback = {

      val c1 = t.modState{ S =>

        // calculate top and left
        val dragPoint = DomUtil.getControlPosition(e)
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
      val c2 = t.state.flatMap(S => P.onDrag.asCbo(e, createUIEvent(S)))

      c1 >> c2
    }

    def handleDragEnd(P: Props)(e: Event): Callback = {
      val unregister: Callback =
        t.state.flatMap(_.stopListening.asCbo)
      val onStop: Callback =
        t.state.flatMap(S => P.onStop.asCbo(e, createUIEvent(S)))
      val stopDragging: Callback =
        t.modState(_.copy(dragging = false, stopListening = uNone))

      unregister >> onStop >> stopDragging >> hack.enableUserSelect
    }

    def canDragY(P: Props): Boolean =
      P.axis == "both" || P.axis == "y"

    def canDragX(P: Props): Boolean =
      P.axis == "both" || P.axis == "x"

    private val transforms = Seq(^.transform, mozTransform, webkitTransform, msTransform)

    def positionToCSSTransform(left: Int, top: Int): TagMod =
      transforms map (_ := s"translate(${left}px, ${top}px)")

    def render(P: Props, S: State, C: PropsChildren) = {
      val topValue: Int =
        if (canDragY(P)) S.clientY else S.startY
      val leftValue: Int =
        if (canDragX(P)) S.clientX else S.startX
      val stl: TagMod =
        if (P.useCSSTransforms) positionToCSSTransform(leftValue, topValue)
        else                    Seq(^.top := topValue, ^.left := leftValue)

      <.div(
        ^.classSet1("react-draggable", "react-draggable-dragging" -> S.dragging),
        stl,
        ^.onMouseDown  ==> handleDragStart(P),
        ^.onTouchStart ==> handleDragStart(P),
        ^.onMouseUp    ==> handleDragEnd(P),
        ^.onTouchEnd   ==> handleDragEnd(P)
      )(C)
    }
  }
  
  def newStateFrom(P: Props): State =
    State(
      dragging = false,
      clientX = P.start.x.toInt,
      clientY = P.start.y.toInt,
      offsetX = 0,
      offsetY = 0,
      stopListening = uNone
    )
  
  val component = ReactComponentB[Props]("ReactDraggable")
    .initialState_P(newStateFrom)
    .renderBackend[Backend]
    .componentWillReceiveProps{
      case ComponentWillReceiveProps(_$, nextProps) ⇒
        _$.setState(newStateFrom(nextProps)).conditionally(nextProps.moveOnStartChange).void
    }
    .configure(Reusability.shouldComponentUpdate)
    .componentWillUnmount($ => $.state.stopListening.getOrElse(Callback.empty))
    .build

  case class Props(cancel: U[String],
                   onDrag: U[(Event, RElementPosition) => Callback],
                   useCSSTransforms: Boolean,
                   clsNames: CssClassType,
                   ref: U[String],
                   moveOnStartChange: Boolean,
                   grid: U[RGrid],
                   key: js.Any,
                   zIndex: Int,
                   axis: String,
                   onStop: U[(Event, RElementPosition) => Callback],
                   start: RPoint,
                   onStart: U[(Event, RElementPosition) => Callback],
                   onMouseDown: U[Event => Callback],
                   handle: U[String],
                   minConstraints: U[RGrid],
                   maxConstraints: U[RGrid])

  /**
   *
   * @param cancel specifies a selector to be used to prevent drag initialization.
   * @param onDrag  Called while dragging
   * @param useCSSTransforms if true will place the element using translate(x, y)
   *                         rather than CSS top/left.
   *                         This generally gives better performance, and is useful in combination with
   *                         other layout systems that use translate(), such as react-grid-layout.
   * @param clsNames css class names map
   * @param ref ref for this component
   * @param moveOnStartChange tells the Draggable element to reset its position
   *                          if the `start` parameters are changed. By default, if the `start`
   *                          parameters change, the Draggable element still remains where it started
   *                          or was dragged to.
   * @param grid specifies the x and y that dragging should snap to.
   * @param key key for this react component
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
  def apply(cancel: U[String] = uNone,
            onDrag: U[(Event, RElementPosition) => Callback] = uNone,
            useCSSTransforms: Boolean = false,
            clsNames: CssClassType = Map(),
            ref: U[String] = uNone,
            moveOnStartChange: Boolean = false,
            grid: U[RGrid] = uNone,
            key: js.Any = {},
            zIndex: Int = 0,
            axis: String = "both",
            onStop: U[(Event, RElementPosition) => Callback] = uNone,
            start: RPoint = RPoint(0, 0),
            onStart: U[(Event, RElementPosition) => Callback] = uNone,
            onMouseDown: U[Event => Callback] = uNone,
            handle: U[String] = uNone,
            minConstraints: U[RGrid] = uNone,
            maxConstraints: U[RGrid] = uNone)
           (children: ReactNode) =
    component.set(key, ref)(
      Props(
        cancel = cancel,
        onDrag = onDrag,
        useCSSTransforms = useCSSTransforms,
        clsNames = clsNames,
        ref = ref,
        moveOnStartChange = moveOnStartChange,
        grid = grid,
        key = key,
        zIndex = zIndex,
        axis = axis,
        onStop = onStop,
        start = start,
        onStart = onStart,
        onMouseDown = onMouseDown,
        handle = handle,
        minConstraints = minConstraints,
        maxConstraints = maxConstraints
      ),
      children
    )

}
