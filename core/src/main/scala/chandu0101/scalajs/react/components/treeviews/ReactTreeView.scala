package chandu0101.scalajs.react.components
package treeviews

import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.collection.mutable
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

  val nodeRefs: mutable.Map[String, RefComp[NodeProps, NodeState, NodeBackend, TopNode]] = mutable.Map.empty

  case class State(filterText: String = "", filterMode: Boolean = false, selectedNode: BackendScope[NodeProps, NodeState] = null)

  class Backend(t: BackendScope[Props, State]) {

    def onNodeSelect(node: BackendScope[NodeProps, NodeState]) = {
      if (t.state.selectedNode != node) {
        if (t.state.selectedNode != null && t.state.selectedNode.isMounted()) {
          t.state.selectedNode.modState(_.copy(selected = false))
        }
        t.modState(_.copy(selectedNode = node, filterMode = false))
        node.modState(_.copy(selected = true))
      }
      val p = node.props
      if (t.props.onItemSelect != null) t.props.onItemSelect(p.root.item.toString, p.parent, p.depth)
    }

    def onTextChange(text: String) = {
      t.modState(_.copy(filterText = text, filterMode = true))

    }

  }

  class NodeBackend(t: BackendScope[NodeProps, NodeState]) {

    def onItemSelect(e: ReactEventH) = {
      t.props.onNodeSelect(t)
      e.preventDefault()
      e.stopPropagation()
    }

    def onTreeMenuToggle(e: ReactEventH) = {
      if (t.props.root.children.nonEmpty) {
        if (t.state.children.isEmpty) t.modState(_.copy(children = t.props.root.children))
        else t.modState(_.copy(children = Nil))
      }
      e.preventDefault()
      e.stopPropagation()
    }

    def isFilterTextExist(filterText: String, data: TreeItem): Boolean = {
      def loop(data: Seq[TreeItem]): Boolean = {
        data.view.exists(item => if (item.children.isEmpty) item.item.toString.toLowerCase.contains(filterText.toLowerCase) else loop(item.children))
      }
      data.item.toString.toLowerCase.contains(filterText.toLowerCase) || loop(data.children)
    }

  }

  case class NodeState(children: Seq[TreeItem] = Nil, selected: Boolean = false)

  case class NodeProps(root: TreeItem, open: Boolean, depth: Int = 0, parent: String = "", onNodeSelect: (BackendScope[NodeProps, NodeState]) => Any, filterText: String, style: Style, filterMode: Boolean)

  lazy val TreeNode: ReactComponentC.ReqProps[NodeProps, NodeState, NodeBackend, TopNode] = ReactComponentB[NodeProps]("ReactTreeNode")
    .initialStateP(p => if (p.open) NodeState(p.root.children) else NodeState())
    .backend(new NodeBackend(_))
    .render((P, S, B) => {
    val children = S.children
    val depth = P.depth + 1
    val parent = if (P.parent.isEmpty) P.root.item.toString else s"${P.parent}<-${P.root.item.toString}"
    val treeMenuToggle: TagMod = if (children.nonEmpty) <.span(^.onClick ==> B.onTreeMenuToggle, ^.key := "arrow", P.style.treeItemBefore)("▼")
    else if (P.root.children.nonEmpty && children.isEmpty) <.span(^.onClick ==> B.onTreeMenuToggle, ^.key := "arrow", P.style.treeItemBefore)("▶")
    else ""
    <.li(P.style.treeItem, treeMenuToggle, ^.key := "toggle", P.style.treeItemContent)(<.span(S.selected ?= P.style.selectedTreeItemContent, ^.onClick ==> B.onItemSelect, P.root.item.toString))(
      <.ul(P.style.treeGroup)(
        children.map(child => {
          val key: js.Any = s"$parent$depth${child.item}"
          val open = if (!P.filterText.trim.isEmpty) true else false
          B.isFilterTextExist(P.filterText, child) ?= TreeNode.withKey(key)(P.copy(root = child, depth = depth, parent = parent, open = open, filterText = P.filterText))
        }))
    )
  })
    .componentWillReceiveProps((scope, nextProps) => {
    if (nextProps.filterMode) {
      if (nextProps.open) scope.modState(_.copy(children = nextProps.root.children))
      else scope.modState(_.copy(children = Nil))
    }
  })
    .build

  val component = ReactComponentB[Props]("ReactTreeView")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(P.style.reactTreeView)(
      P.showSearchBox ?= ReactSearchBox(onTextChange = B.onTextChange),
      TreeNode.withKey("root")(NodeProps(root = P.root, open = if (S.filterText.nonEmpty) true else P.open, onNodeSelect = B.onNodeSelect, filterText = S.filterText, style = P.style, filterMode = S.filterMode))
    )
  })
    .build

  case class Props(root: TreeItem, open: Boolean, onItemSelect: StringStringIntAny, showSearchBox: Boolean, style: Style)

  def apply(root: TreeItem, openByDefault: Boolean = false, onItemSelect: StringStringIntAny = null, showSearchBox: Boolean = false, ref: js.UndefOr[String] = "", key: js.Any = "dude", style: Style = new Style {}) = component.set(key, ref)(Props(root, openByDefault, onItemSelect, showSearchBox, style))

}
