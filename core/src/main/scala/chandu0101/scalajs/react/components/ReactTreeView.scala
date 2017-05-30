package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

case class TreeItem(item: Any, children: TreeItem*) {
  def apply(item: Any): TreeItem = this(item, Nil)
}

object ReactTreeView {
  trait Style {

    def reactTreeView = TagMod()

    def treeGroup = TagMod(^.margin := 0.px, ^.padding := "0 0 0 14px")

    def treeItem = TagMod(^.listStyleType := "none")

    def selectedTreeItemContent = TagMod(
      ^.backgroundColor := "#1B8EB0",
      ^.color := "white",
      ^.fontWeight := 400.px,
      ^.padding := "0 7px"
    )

    def treeItemBefore = TagMod(
      ^.display := "inline-block",
      ^.fontSize := 11.px,
      ^.color := "grey",
      ^.margin := "3px 7px 0 0",
      ^.textAlign := "center",
      ^.width := 11.px
    )

    def treeItemHasChildrenClosed = TagMod(^.contentStyle := "▶")

    def treeItemHasChildrenOpened = TagMod(^.contentStyle := "▼")

  }

  type NodeC =
    japgolly.scalajs.react.component.Scala.MountedPure[NodeProps, NodeState, NodeBackend]

  //  type NodeC = DuringCallbackU[NodeProps, NodeState, NodeBackend]

  case class State(
      filterText: String,
      filterMode: Boolean,
      selectedNode: js.UndefOr[NodeC]
  )

  class Backend($ : BackendScope[Props, State]) {

    def onNodeSelect(props: Props)(selected: NodeC): Callback = {
      val removeSelection: Callback =
        $.state.flatMap(
          _.selectedNode
          //            .filter(a => a.isMounted)
            .filterNot(_ == selected)
            .fold(Callback.empty)(_.modState(_.copy(selected = false)))
        )

      val updateThis: Callback =
        $.modState(_.copy(selectedNode = selected, filterMode = false))

      val setSelection: Callback =
        selected.modState(_.copy(selected = true))

      val tell: CallbackTo[Unit] = {
        selected.props.flatMap(nodeProps => {
          props.onItemSelect.fold(Callback.empty)(fn => {
            fn(
              nodeProps.root.item.toString,
              nodeProps.parent,
              nodeProps.depth
            )
          })
        })
      }

      removeSelection >> updateThis >> setSelection >> tell
    }

    def onTextChange(text: String): Callback =
      $.modState(_.copy(filterText = text, filterMode = true))

    def render(P: Props, S: State) =
      <.div(P.style.reactTreeView)(
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

    def onItemSelect(P: NodeProps)(e: ReactEventFromHtml): Callback =
      P.onNodeSelect($.asInstanceOf[NodeC]) >> e.preventDefaultCB >> e.stopPropagationCB

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
        ^.cursor := "pointer",
        <.span(
          P.style.selectedTreeItemContent.when(S.selected),
          ^.onClick ==> onItemSelect(P),
          P.root.item.toString
        ),
        <.ul(P.style.treeGroup)(
          S.children
            .map(
              child =>
                TreeNode
                  .withKey(s"$parent$depth${child.item}")(
                    P.copy(
                      root = child,
                      open = !P.filterText.trim.isEmpty,
                      depth = depth,
                      parent = parent,
                      filterText = P.filterText
                    ))
                  .when(isFilterTextExist(P.filterText, child)))
            .toTagMod
        )
      )
    }
  }

  case class NodeState(children: Seq[TreeItem] = Nil, selected: Boolean = false)

  case class NodeProps(
      root: TreeItem,
      open: Boolean,
      depth: Int = 0,
      parent: String = "",
      onNodeSelect: (NodeC) => Callback,
      filterText: String,
      style: Style,
      filterMode: Boolean
  )

  lazy val TreeNode = ScalaComponent
    .builder[NodeProps]("ReactTreeNode")
    .initialStateFromProps(P => if (P.open) NodeState(P.root.children) else NodeState())
    .renderBackend[NodeBackend]
    .componentWillReceiveProps {
      case componentWillReceiveProps =>
        componentWillReceiveProps
          .modState(
            _.copy(
              children =
                if (componentWillReceiveProps.nextProps.open)
                  componentWillReceiveProps.nextProps.root.children
                else Nil))
          .when(componentWillReceiveProps.nextProps.filterMode)
          .void
    }
    .build

  val component = ScalaComponent
    .builder[Props]("ReactTreeView")
    .initialState(State("", false, js.undefined))
    .renderBackend[Backend]
    .build

  case class Props(
      root: TreeItem,
      open: Boolean,
      onItemSelect: js.UndefOr[(String, String, Int) => Callback],
      showSearchBox: Boolean,
      style: Style
  )

  def apply(
      root: TreeItem,
      openByDefault: Boolean = false,
      onItemSelect: js.UndefOr[(String, String, Int) => Callback] = js.undefined,
      showSearchBox: Boolean = false,
      ref: js.UndefOr[String] = js.undefined,
      key: js.UndefOr[js.Any] = js.undefined,
      style: Style = new Style {}
  ) =
    component /*.set(key, ref)*/ (Props(root, openByDefault, onItemSelect, showSearchBox, style))

}
