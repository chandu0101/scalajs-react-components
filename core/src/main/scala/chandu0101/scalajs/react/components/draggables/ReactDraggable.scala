package chandu0101.scalajs.react.components.draggables


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.models.{RElementPosition, RGrid, RPoint}
import chandu0101.scalajs.react.components.util.DomUtil._
import chandu0101.scalajs.react.components.util.Events
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}


/**
 * Created by chandrasekharkode .
 */
object ReactDraggable {


  /**
   *
   * @param dragging whether or not currently dragging
   * @param startX Start left of t.getDOmNode()
   * @param startY Start top of t.getDOmNode()
   * @param offsetX Offset between start left and mouse left
   * @param offsetY Offset between start top and mouse top
   * @param clientX Current left of this.getDOMNode()
   * @param clientY Current top of this.getDOMNode()
   */
  case class State(dragging : Boolean = false,startX : Int = 0,startY : Int = 0, offsetX : Int = 0,offsetY : Int = 0,clientX : Int = 0,clientY : Int = 0)

  class Backend(t: BackendScope[Props, State]) {

    def createUIEvent = RElementPosition(t.getDOMNode(),top = t.state.clientY , left  = t.state.clientX)

    lazy val handleDrag_ref : js.Function1[Event,_] = handleDrag _

    lazy val handleDragStart_ref : js.Function1[Event,_] = handleDragStart _

    lazy val handleDragEnd_ref : js.Function1[Event,_] = handleDragEnd _


    def handleDragStart(e : Event) = {
//      println(s"started dragging e : $e left : ${isLeftClick(e)}")
      // Make it possible to attach event handlers on top of this one
      if(t.props.onMouseDown != null) t.props.onMouseDown(e)
      if(isLeftClick(e)) {//only catch left clicks
        if(!((!t.props.handle.isEmpty && !matchesSelector(e.target.asInstanceOf[js.Dynamic],t.props.handle)) ||
          (!t.props.cancel.isEmpty && matchesSelector(e.target.asInstanceOf[js.Dynamic].target,t.props.cancel))
          )) { // Short circuit if handle or cancel prop was provided and selector doesn't match
          val dragPoint = getControlPosition(e)
          //Initiate Dragging
          t.modState(_.copy(dragging = true,offsetX = dragPoint.x.toInt , offsetY = dragPoint.y.toInt))
          // Add a class to the body to disable user-select. This prevents text from
          // being selected all over the page.
          dom.document.body.className += " react-draggable-active"
          if(t.props.onStart != null) t.props.onStart(e,createUIEvent)
          Events.on(dom.window,dragEventFor("move"),handleDrag_ref)
          Events.on(dom.window,dragEventFor("end"),handleDragEnd_ref)
        }
      }
    }

    def handleDrag(e: Event)  = {
       val dragPoint = getControlPosition(e)
        // calculate top and left
       var clientX = t.state.startX + (dragPoint.x - t.state.offsetX)
       var clientY = t.state.startY + (dragPoint.y - t.state.offsetY)

        // Snap to grid if prop has been provided
       if(t.props.grid != null) {
         val directionX = if(clientX < t.state.clientX) -1 else 1
         val directionY = if(clientY < t.state.clientY) -1 else 1
         val grid = t.props.grid
         clientX = if(Math.abs(clientX - t.state.clientX) >= grid.width)
                t.state.clientX + (grid.width * directionX)
               else t.state.clientX
         clientY = if(Math.abs(clientY - t.state.clientY) >= grid.height)
                t.state.clientY + (grid.height * directionY)
               else t.state.clientY
       }

       //min/max contraints
       if(t.props.minConstraints != null) {
         clientX = Math.max(t.props.minConstraints.width,clientX)
         clientY = Math.max(t.props.minConstraints.height,clientY)
       }

       if(t.props.maxConstraints != null) {
         clientX = Math.max(t.props.maxConstraints.width,clientX)
         clientY = Math.max(t.props.maxConstraints.height,clientY)
       }
         // Update top and left
      t.modState(_.copy(clientX = clientX.toInt, clientY = clientY.toInt))
      //call event handler
      if(t.props.onDrag != null) t.props.onDrag(e,createUIEvent)
    }

    def handleDragEnd(e:Event)  = {
      e.target
       if(t.state.dragging) {
         t.modState(_.copy(dragging = false))
          // Remove the body class used to disable user-select.
          g.document.body.className = g.document.body.className.replace(" react-draggable-active", "")
         if(t.props.onStop != null) t.props.onStop(e,createUIEvent)
          Events.off(dom.window,dragEventFor("move"),handleDrag_ref)
          Events.off(dom.window,dragEventFor("end"),handleDragEnd_ref)
       }
    }

    def canDragY = t.props.axis == "both" || t.props.axis == "y"

    def canDragX = t.props.axis == "both" || t.props.axis == "x"

    def positionToCSSTransform(left : Int, top : Int) = {
      val trans = s"translate(${left}px , ${top}px)"
      Seq( ^.transform := trans,mozTransform := trans , webkitTransform := trans , msTransform := trans)
    }
  }

  val component = ReactComponentB[Props]("ReactDraggable")
    .initialStateP(p => State(clientX = p.start.x.toInt ,clientY = p.start.y.toInt))
    .backend(new Backend(_))
    .render((P,C,S, B) => {
      val topValue = if(B.canDragY) S.clientY else S.startY
      val leftValue = if(B.canDragX) S.clientX else S.startX
      var stl : TagMod = Seq( ^.top := topValue ,^.left := leftValue)
      if(P.useCSSTransforms) stl = B.positionToCSSTransform(leftValue,topValue)
     <.div(^.classSet1("react-draggable","react-draggable-dragging" -> S.dragging) ,stl)(
       ^.onMouseDown ==> B.handleDragStart,
       ^.onMouseUp ==> B.handleDragEnd
      )(
        C
      )
    })
    .componentWillReceiveProps((scope,nextProps) => {
       if(nextProps.moveOnStartChange) scope.modState(_.copy(clientX = nextProps.start.x.toInt,clientY = nextProps.start.y.toInt))
    })
    .shouldComponentUpdate((scope,nextP,nextS) => {
      !(scope.props == nextP) || !(scope.state == nextS)
     })
    .componentWillUnmount(scope => {
      Events.off(dom.window,dragEventFor("move"),scope.backend.handleDrag_ref)
      Events.off(dom.window,dragEventFor("end"),scope.backend.handleDragEnd_ref)
    })
    .build


  case class Props(cancel: String, onDrag: EventRElementPositionAny, useCSSTransforms: Boolean, clsNames: CssClassType, ref: js.UndefOr[String], moveOnStartChange: Boolean, grid: RGrid, key: js.Any, zIndex: Int, axis: String, onStop: EventRElementPositionAny, start: RPoint, onStart: EventRElementPositionAny, onMouseDown: EventUnit, handle: String,minConstraints : RGrid,maxConstraints : RGrid)

  /**
   *
   * @param cancel specifies a selector to be used to prevent drag initialization.
   * @param onDrag  Called while dragging
   * @param useCSSTransforms if true will place the element using translate(x, y)
   * rather than CSS top/left.
   * This generally gives better performance, and is useful in combination with
   * other layout systems that use translate(), such as react-grid-layout.
   * @param clsNames css class names map
   * @param ref ref for this component
   * @param moveOnStartChange tells the Draggable element to reset its position
   * if the `start` parameters are changed. By default, if the `start`
   * parameters change, the Draggable element still remains where it started
   * or was dragged to.
   * @param grid specifies the x and y that dragging should snap to.
   * @param key key for this react component
   * @param zIndex specifies the zIndex to use while dragging.
   * @param axis determines which axis the draggable can move.(both,x,y)
   * @param onStop Called when dragging stops
   * @param start specifies the x and y that the dragged item should start at
   * @param onStart Called when dragging starts.
   * @param onMouseDown  * A workaround option which can be passed if onMouseDown needs to be accessed,
   * since it'll always be blocked (due to that there's internal use of onMouseDown)
   * @param handle specifies a selector to be used as the handle that initiates drag.
   * @param children
   * @return
   */
  def apply(cancel: String = "", onDrag: EventRElementPositionAny = null, useCSSTransforms: Boolean = false, clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", moveOnStartChange: Boolean = false, grid: RGrid = null, key: js.Any = {}, zIndex: Int = 0, axis: String = "both", onStop: EventRElementPositionAny = null, start: RPoint = RPoint(0,0), onStart: EventRElementPositionAny = null, onMouseDown: EventUnit = null, handle: String = "",minConstraints : RGrid = null, maxConstraints : RGrid = null)(children: ReactNode) =
    component.set(key, ref)(Props(cancel, onDrag, useCSSTransforms, clsNames, ref, moveOnStartChange, grid, key, zIndex, axis, onStop, start, onStart, onMouseDown, handle,minConstraints,maxConstraints), children)

}
