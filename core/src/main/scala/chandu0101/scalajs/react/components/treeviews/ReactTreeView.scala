package chandu0101.scalajs.react.components
package treeviews

import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import japgolly.scalajs.react.CompScope._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

case class TreeItem(item: Any, children: TreeItem*) {
  def apply(item: Any): TreeItem = this(item, Nil)
}

object ReactTreeView {

  trait Style {

    def reactTreeView = Seq[TagMod]()

    def treeGroup = Seq(^.margin := 0, ^.padding := "0 0 0 14px")

    def treeItem = Seq(^.listStyleType := "none")

    def treeItemContent = Seq(cursorPointer)

    def selectedTreeItemContent = Seq(^.backgroundColor := "#1B8EB0",
      ^.color := "white", ^.fontWeight := 400,
      ^.padding := "0 7px")

    def treeItemBefore = Seq(
      displayInlineBlock,
      ^.fontSize := "11px",
      ^.color := "grey",
      ^.margin := "3px 7px 0 0",
      textAlignCenter,
      ^.width := "11px"
    )

    def treeItemHasChildrenClosed = Seq(^.contentStyle := "▶")

    def treeItemHasChildrenOpened = Seq(^.contentStyle := "▼")

  }

  type NodeC = DuringCallbackU[NodeProps, NodeState, NodeBackend]

  case class State(filterText: String,
                   filterMode: Boolean,
                   selectedNode: js.UndefOr[NodeC])

  class Backend($: BackendScope[Props, State]) {

    def onNodeSelect(selected: NodeC): Callback = {
      val removeSelection: Callback =
        $.state.flatMap(
          _.selectedNode
            .filterNot(_ == selected)
            .filter(_.isMounted())
            .fold(Callback.empty)(_.modState(_.copy(selected = false)))
        )

      val updateThis: Callback =
        $.modState(_.copy(selectedNode = selected, filterMode = false))

      val setSelection: Callback =
        selected.modState(_.copy(selected = true))
      
      val tell: Callback =
        $.props.map(_.onItemSelect.fold(Callback.empty)(
          _.apply(
            selected.props.root.item.toString,
            selected.props.parent,
            selected.props.depth
          )
        ))

      removeSelection >> updateThis >> setSelection >> tell
    }

    def onTextChange(text: String): Callback =
      $.modState(_.copy(filterText = text, filterMode = true))

    def render(P: Props, S: State) =
      <.div(P.style.reactTreeView)(
        P.showSearchBox ?= ReactSearchBox(onTextChange = onTextChange),
        TreeNode.withKey("root")(NodeProps(
          root = P.root,
          open = if (S.filterText.nonEmpty) true else P.open,
          onNodeSelect = onNodeSelect,
          filterText = S.filterText,
          style = P.style,
          filterMode = S.filterMode
        ))
      )
  }

  case class NodeBackend($: BackendScope[NodeProps, NodeState]) {

    def onItemSelect(P: NodeProps)(e: ReactEventH): Callback =
      P.onNodeSelect($.asInstanceOf[NodeC]) >> e.preventDefaultCB >> e.stopPropagationCB

    def childrenFromProps(P: NodeProps): CallbackTo[Option[Unit]] =
      $.modState(S => S.copy(children = if (S.children.isEmpty) P.root.children else Nil))
        .conditionally(P.root.children.nonEmpty)

    def onTreeMenuToggle(P: NodeProps)(e: ReactEventH): Callback =
      childrenFromProps(P) >> e.preventDefaultCB >> e.stopPropagationCB

    def isFilterTextExist(filterText: String, data: TreeItem): Boolean = {
      def matches(item: TreeItem): Boolean =
        item.item.toString.toLowerCase.contains(filterText.toLowerCase)

      def loop(data: Seq[TreeItem]): Boolean =
        data.view.exists(
          item => if (item.children.isEmpty) matches(item) else loop(item.children)
        )

      matches(data) || loop(data.children)
    }

    def render(P: NodeProps, S: NodeState): ReactTag = {
      val depth    = P.depth + 1
      val parent   = if   (P.parent.isEmpty) P.root.item.toString
                     else s"${P.parent}<-${P.root.item.toString}"

      val treeMenuToggle: TagMod =
        if (S.children.nonEmpty)
          <.span(
            ^.onClick ==> onTreeMenuToggle(P),
            ^.key := "arrow",
            P.style.treeItemBefore,
            "▼"
          )
        else if (P.root.children.nonEmpty && S.children.isEmpty)
          <.span(
            ^.onClick ==> onTreeMenuToggle(P),
            ^.key := "arrow",
            P.style.treeItemBefore,
            "▶"
          )
        else ""

      <.li(
        P.style.treeItem,
        treeMenuToggle,
        ^.key := "toggle",
        P.style.treeItemContent,
        <.span(
          S.selected ?= P.style.selectedTreeItemContent,
          ^.onClick ==> onItemSelect(P),
          P.root.item.toString
        ),
        <.ul(P.style.treeGroup)(
          S.children.map(child =>
            isFilterTextExist(P.filterText, child) ?=
              TreeNode.withKey(s"$parent$depth${child.item}")(P.copy(
                root = child,
                open = !P.filterText.trim.isEmpty,
                depth = depth,
                parent = parent,
                filterText = P.filterText
              ))
          ))
      )
    }
  }

  case class NodeState(children: Seq[TreeItem] = Nil, selected: Boolean = false)

  case class NodeProps(root: TreeItem,
                       open: Boolean,
                       depth: Int = 0,
                       parent: String = "",
                       onNodeSelect: (NodeC) => Callback,
                       filterText: String,
                       style: Style,
                       filterMode: Boolean)

  lazy val TreeNode = ReactComponentB[NodeProps]("ReactTreeNode")
    .initialState_P(P => if (P.open) NodeState(P.root.children) else NodeState())
    .renderBackend[NodeBackend]
    .componentWillReceiveProps {
      case ComponentWillReceiveProps(_$, newProps) =>
        _$.modState(_.copy(children = if (newProps.open) newProps.root.children else Nil))
          .conditionally(newProps.filterMode)
          .void
    }
    .build

  val component = ReactComponentB[Props]("ReactTreeView")
    .initialState(State("", false, js.undefined))
    .renderBackend[Backend]
    .build

  case class Props(root: TreeItem,
                   open: Boolean,
                   onItemSelect: js.UndefOr[(String, String, Int) => Callback],
                   showSearchBox: Boolean,
                   style: Style)

  def apply(root: TreeItem,
            openByDefault: Boolean = false,
            onItemSelect: js.UndefOr[(String, String, Int) => Callback] = js.undefined,
            showSearchBox: Boolean = false,
            ref: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[js.Any] = js.undefined,
            style: Style = new Style {}) =
    component.set(key, ref)(Props(root, openByDefault, onItemSelect, showSearchBox, style))

}
