package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import Implicits._

case class TreeItem(item: Any, children: TreeItem*) {
  def apply(item: Any): TreeItem = this(item, Nil)
}

object ReactTreeView {

  trait Style {

    def reactTreeView = Seq[TagMod]()

    def treeGroup = Seq(^.margin := "0", ^.padding := "0 0 0 14px")

    def treeItem = Seq(^.listStyleType := "none")

    def selectedTreeItemContent =
      Seq(^.backgroundColor := "#1B8EB0",
          ^.color := "white",
          ^.fontWeight := "400",
          ^.padding := "0 7px")

    def treeItemBefore = Seq(
      ^.display := "inline-block",
      ^.fontSize := "11px",
      ^.color := "grey",
      ^.margin := "3px 7px 0 0",
      ^.textAlign := "center",
      ^.width := "11px"
    )

    def treeItemHasChildrenClosed = Seq(^.contentStyle := "▶")

    def treeItemHasChildrenOpened = Seq(^.contentStyle := "▼")

  }

  type NodeC = ScalaComponent.MountedPure[NodeProps, NodeState, NodeBackend] //, _ <: CtorType[_, _]]

  case class State(filterText: String, filterMode: Boolean, selectedNode: js.UndefOr[NodeC])

  class Backend($ : BackendScope[Props, State]) {

    def onNodeSelect(P: Props)(selected: NodeC): Callback = {
      val removeSelection: Callback =
        $.state.flatMap(
          _.selectedNode
            .filterNot(_ == selected)
            .fold(Callback.empty)(_.modState(_.copy(selected = false)))
        )

      val updateThis: Callback =
        $.modState(_.copy(selectedNode = selected, filterMode = false))

      val setSelection: Callback = selected.modState(_.copy(selected = true))

      val tell: Callback =
        selected.props.flatMap(p => P.onItemSelect.asCbo(p.root.item.toString, p.parent, p.depth))

      removeSelection >> updateThis >> setSelection >> tell
    }

    def onTextChange(text: String): Callback =
      $.modState(_.copy(filterText = text, filterMode = true))

    def render(P: Props, S: State) =
      <.div(P.style.reactTreeView.toTagMod)(
        ReactSearchBox(onTextChange = onTextChange).when(P.showSearchBox),
        TreeNode.withKey("root")(
          NodeProps(
            root = P.root,
            open = if (S.filterText.nonEmpty) true else P.open,
            onNodeSelect = onNodeSelect(P),
            filterText = S.filterText,
            style = P.style,
            filterMode = S.filterMode
          ))
      )
  }

  case class NodeBackend($ : BackendScope[NodeProps, NodeState]) {

    def onItemSelect(P: NodeProps)(e: ReactEventFromHtml): Callback = {
      P.onNodeSelect($.asInstanceOf[NodeC]) >> e.preventDefaultCB >> e.stopPropagationCB
    }

    def childrenFromProps(P: NodeProps): CallbackTo[Option[Unit]] =
      $.modState(S => S.copy(children = if (S.children.isEmpty) P.root.children else Nil))
        .when(P.root.children.nonEmpty)

    def onTreeMenuToggle(P: NodeProps)(e: ReactEventFromHtml): Callback =
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

    def render(P: NodeProps, S: NodeState): VdomTag = {
      val depth = P.depth + 1
      val parent =
        if (P.parent.isEmpty) P.root.item.toString
        else s"${P.parent}<-${P.root.item.toString}"

      val treeMenuToggle: TagMod =
        if (S.children.nonEmpty)
          <.span(
            ^.onClick ==> onTreeMenuToggle(P),
            ^.key := "arrow",
            P.style.treeItemBefore.toTagMod,
            "▼"
          )
        else if (P.root.children.nonEmpty && S.children.isEmpty)
          <.span(
            ^.onClick ==> onTreeMenuToggle(P),
            ^.key := "arrow",
            P.style.treeItemBefore.toTagMod,
            "▶"
          )
        else ""

      <.li(
        P.style.treeItem.toTagMod,
        treeMenuToggle,
        ^.key := "toggle",
        ^.cursor := "pointer",
        <.span(
          P.style.selectedTreeItemContent.toTagMod.when(S.selected),
          ^.onClick ==> onItemSelect(P),
          P.root.item.toString
        ),
        <.ul(P.style.treeGroup.toTagMod)(
          S.children
            .map(
              child =>
                TreeNode
                  .withKey(s"$parent$depth${child.item}")
                  .apply(
                    P.copy(
                      root = child,
                      open = !P.filterText.trim.isEmpty,
                      depth = depth,
                      parent = parent,
                      filterText = P.filterText
                    ))
                  .when(isFilterTextExist(P.filterText, child)))
            .toTagMod)
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

  lazy val TreeNode = ScalaComponent
    .builder[NodeProps]("ReactTreeNode")
    .initialStateFromProps(P => if (P.open) NodeState(P.root.children) else NodeState())
    .renderBackend[NodeBackend]
    .componentWillReceiveProps { c =>
      c.modState(_.copy(children = if (c.nextProps.open) c.nextProps.root.children else Nil))
        .when(c.nextProps.filterMode)
        .void
    }
    .build

  val component = ScalaComponent
    .builder[Props]("ReactTreeView")
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
            style: Style = new Style {}) =
    component(Props(root, openByDefault, onItemSelect, showSearchBox, style))

}
