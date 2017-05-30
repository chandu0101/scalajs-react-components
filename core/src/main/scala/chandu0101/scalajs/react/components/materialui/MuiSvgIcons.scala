package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react.{Callback, Children, JsComponent, ReactMouseEventFromHtml}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
trait MuiSvgIconProps extends js.Object {
  def key: js.UndefOr[String]
  def ref: js.UndefOr[String]
  def color: js.UndefOr[String]
  def hoverColor: js.UndefOr[String]
  def onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback]
  def onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback]
  def style: js.UndefOr[CssProperties]
  def viewBox: js.UndefOr[String]
}

object MuiSvgIcon {
  implicit class SvgIconApply(icon: MuiSvgIcon) {
    def apply(
        key: js.UndefOr[String] = js.undefined,
        ref: js.UndefOr[String] = js.undefined,
        color: js.UndefOr[String] = js.undefined,
        hoverColor: js.UndefOr[MuiColor] = js.undefined,
        onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
        onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
        style: js.UndefOr[CssProperties] = js.undefined,
        viewBox: js.UndefOr[String] = js.undefined
    )(children: VdomNode*): UnmountedWithRawType[MuiSvgIconProps, Null, RawMounted] = {

      val props = js.Dynamic.literal()
      key.foreach(v => props.updateDynamic("key")(v))
      ref.foreach(v => props.updateDynamic("ref")(v))
      color.foreach(v => props.updateDynamic("color")(v))
      hoverColor.foreach(v => props.updateDynamic("hoverColor")(v))
      onMouseEnter.foreach(v => props.updateDynamic("onMouseEnter")(v andThen (_.runNow())))
      onMouseLeave.foreach(v => props.updateDynamic("onMouseLeave")(v andThen (_.runNow())))
      style.foreach(v => props.updateDynamic("style")(v))
      viewBox.foreach(v => props.updateDynamic("viewBox")(v))

      val svgProps: MuiSvgIconProps =
        props.asInstanceOf[MuiSvgIconProps]

      val Component = JsComponent[MuiSvgIconProps, Children.Varargs, Null](icon)
      Component(svgProps)(children: _*)
    }
  }
}

@js.native
trait MuiSvgIcon extends js.Any

object MuiSvgIcons {
  @js.native @JSImport("material-ui/svg-icons/action/accessibility", JSImport.Default)
  object ActionAccessibility extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/accessible", JSImport.Default)
  object ActionAccessible extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/account-balance-wallet", JSImport.Default)
  object ActionAccountBalanceWallet extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/account-balance", JSImport.Default)
  object ActionAccountBalance extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/account-box", JSImport.Default)
  object ActionAccountBox extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/account-circle", JSImport.Default)
  object ActionAccountCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/add-shopping-cart", JSImport.Default)
  object ActionAddShoppingCart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/alarm-add", JSImport.Default)
  object ActionAlarmAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/alarm-off", JSImport.Default)
  object ActionAlarmOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/alarm-on", JSImport.Default)
  object ActionAlarmOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/alarm", JSImport.Default)
  object ActionAlarm extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/all-out", JSImport.Default)
  object ActionAllOut extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/android", JSImport.Default)
  object ActionAndroid extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/announcement", JSImport.Default)
  object ActionAnnouncement extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/aspect-ratio", JSImport.Default)
  object ActionAspectRatio extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/assessment", JSImport.Default)
  object ActionAssessment extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/assignment-ind", JSImport.Default)
  object ActionAssignmentInd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/assignment-late", JSImport.Default)
  object ActionAssignmentLate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/assignment-return", JSImport.Default)
  object ActionAssignmentReturn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/assignment-returned", JSImport.Default)
  object ActionAssignmentReturned extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/assignment-turned-in", JSImport.Default)
  object ActionAssignmentTurnedIn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/assignment", JSImport.Default)
  object ActionAssignment extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/autorenew", JSImport.Default)
  object ActionAutorenew extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/backup", JSImport.Default)
  object ActionBackup extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/book", JSImport.Default)
  object ActionBook extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/bookmark-border", JSImport.Default)
  object ActionBookmarkBorder extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/bookmark", JSImport.Default)
  object ActionBookmark extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/bug-report", JSImport.Default)
  object ActionBugReport extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/build", JSImport.Default)
  object ActionBuild extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/cached", JSImport.Default)
  object ActionCached extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/camera-enhance", JSImport.Default)
  object ActionCameraEnhance extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/card-giftcard", JSImport.Default)
  object ActionCardGiftcard extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/card-membership", JSImport.Default)
  object ActionCardMembership extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/card-travel", JSImport.Default)
  object ActionCardTravel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/change-history", JSImport.Default)
  object ActionChangeHistory extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/check-circle", JSImport.Default)
  object ActionCheckCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/chrome-reader-mode", JSImport.Default)
  object ActionChromeReaderMode extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/class", JSImport.Default)
  object ActionClass extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/code", JSImport.Default)
  object ActionCode extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/compare-arrows", JSImport.Default)
  object ActionCompareArrows extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/copyright", JSImport.Default)
  object ActionCopyright extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/credit-card", JSImport.Default)
  object ActionCreditCard extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/dashboard", JSImport.Default)
  object ActionDashboard extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/date-range", JSImport.Default)
  object ActionDateRange extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/delete-forever", JSImport.Default)
  object ActionDeleteForever extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/delete", JSImport.Default)
  object ActionDelete extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/description", JSImport.Default)
  object ActionDescription extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/dns", JSImport.Default)
  object ActionDns extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/done-all", JSImport.Default)
  object ActionDoneAll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/done", JSImport.Default)
  object ActionDone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/donut-large", JSImport.Default)
  object ActionDonutLarge extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/donut-small", JSImport.Default)
  object ActionDonutSmall extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/eject", JSImport.Default)
  object ActionEject extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/euro-symbol", JSImport.Default)
  object ActionEuroSymbol extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/event-seat", JSImport.Default)
  object ActionEventSeat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/event", JSImport.Default)
  object ActionEvent extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/exit-to-app", JSImport.Default)
  object ActionExitToApp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/explore", JSImport.Default)
  object ActionExplore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/extension", JSImport.Default)
  object ActionExtension extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/face", JSImport.Default)
  object ActionFace extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/favorite-border", JSImport.Default)
  object ActionFavoriteBorder extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/favorite", JSImport.Default)
  object ActionFavorite extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/feedback", JSImport.Default)
  object ActionFeedback extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/find-in-page", JSImport.Default)
  object ActionFindInPage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/find-replace", JSImport.Default)
  object ActionFindReplace extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/fingerprint", JSImport.Default)
  object ActionFingerprint extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/flight-land", JSImport.Default)
  object ActionFlightLand extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/flight-takeoff", JSImport.Default)
  object ActionFlightTakeoff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/flip-to-back", JSImport.Default)
  object ActionFlipToBack extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/flip-to-front", JSImport.Default)
  object ActionFlipToFront extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/g-translate", JSImport.Default)
  object ActionGTranslate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/gavel", JSImport.Default)
  object ActionGavel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/get-app", JSImport.Default)
  object ActionGetApp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/gif", JSImport.Default)
  object ActionGif extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/grade", JSImport.Default)
  object ActionGrade extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/group-work", JSImport.Default)
  object ActionGroupWork extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/help-outline", JSImport.Default)
  object ActionHelpOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/help", JSImport.Default)
  object ActionHelp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/highlight-off", JSImport.Default)
  object ActionHighlightOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/history", JSImport.Default)
  object ActionHistory extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/home", JSImport.Default)
  object ActionHome extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/hourglass-empty", JSImport.Default)
  object ActionHourglassEmpty extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/hourglass-full", JSImport.Default)
  object ActionHourglassFull extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/http", JSImport.Default)
  object ActionHttp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/https", JSImport.Default)
  object ActionHttps extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/important-devices", JSImport.Default)
  object ActionImportantDevices extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/info-outline", JSImport.Default)
  object ActionInfoOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/info", JSImport.Default)
  object ActionInfo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/input", JSImport.Default)
  object ActionInput extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/invert-colors", JSImport.Default)
  object ActionInvertColors extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/label-outline", JSImport.Default)
  object ActionLabelOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/label", JSImport.Default)
  object ActionLabel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/language", JSImport.Default)
  object ActionLanguage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/launch", JSImport.Default)
  object ActionLaunch extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/lightbulb-outline", JSImport.Default)
  object ActionLightbulbOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/line-style", JSImport.Default)
  object ActionLineStyle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/line-weight", JSImport.Default)
  object ActionLineWeight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/list", JSImport.Default)
  object ActionList extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/lock-open", JSImport.Default)
  object ActionLockOpen extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/lock-outline", JSImport.Default)
  object ActionLockOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/lock", JSImport.Default)
  object ActionLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/loyalty", JSImport.Default)
  object ActionLoyalty extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/markunread-mailbox", JSImport.Default)
  object ActionMarkunreadMailbox extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/motorcycle", JSImport.Default)
  object ActionMotorcycle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/note-add", JSImport.Default)
  object ActionNoteAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/offline-pin", JSImport.Default)
  object ActionOfflinePin extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/opacity", JSImport.Default)
  object ActionOpacity extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/open-in-browser", JSImport.Default)
  object ActionOpenInBrowser extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/open-in-new", JSImport.Default)
  object ActionOpenInNew extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/open-with", JSImport.Default)
  object ActionOpenWith extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/pageview", JSImport.Default)
  object ActionPageview extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/pan-tool", JSImport.Default)
  object ActionPanTool extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/payment", JSImport.Default)
  object ActionPayment extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-camera-mic", JSImport.Default)
  object ActionPermCameraMic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-contact-calendar", JSImport.Default)
  object ActionPermContactCalendar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-data-setting", JSImport.Default)
  object ActionPermDataSetting extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-device-information", JSImport.Default)
  object ActionPermDeviceInformation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-identity", JSImport.Default)
  object ActionPermIdentity extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-media", JSImport.Default)
  object ActionPermMedia extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-phone-msg", JSImport.Default)
  object ActionPermPhoneMsg extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/perm-scan-wifi", JSImport.Default)
  object ActionPermScanWifi extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/pets", JSImport.Default)
  object ActionPets extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/picture-in-picture-alt", JSImport.Default)
  object ActionPictureInPictureAlt extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/picture-in-picture", JSImport.Default)
  object ActionPictureInPicture extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/play-for-work", JSImport.Default)
  object ActionPlayForWork extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/polymer", JSImport.Default)
  object ActionPolymer extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/power-settings-new", JSImport.Default)
  object ActionPowerSettingsNew extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/pregnant-woman", JSImport.Default)
  object ActionPregnantWoman extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/print", JSImport.Default)
  object ActionPrint extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/query-builder", JSImport.Default)
  object ActionQueryBuilder extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/question-answer", JSImport.Default)
  object ActionQuestionAnswer extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/receipt", JSImport.Default)
  object ActionReceipt extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/record-voice-over", JSImport.Default)
  object ActionRecordVoiceOver extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/redeem", JSImport.Default)
  object ActionRedeem extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/remove-shopping-cart", JSImport.Default)
  object ActionRemoveShoppingCart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/reorder", JSImport.Default)
  object ActionReorder extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/report-problem", JSImport.Default)
  object ActionReportProblem extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/restore-page", JSImport.Default)
  object ActionRestorePage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/restore", JSImport.Default)
  object ActionRestore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/room", JSImport.Default)
  object ActionRoom extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/rounded-corner", JSImport.Default)
  object ActionRoundedCorner extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/rowing", JSImport.Default)
  object ActionRowing extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/schedule", JSImport.Default)
  object ActionSchedule extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/search", JSImport.Default)
  object ActionSearch extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-applications", JSImport.Default)
  object ActionSettingsApplications extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-backup-restore", JSImport.Default)
  object ActionSettingsBackupRestore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-bluetooth", JSImport.Default)
  object ActionSettingsBluetooth extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-brightness", JSImport.Default)
  object ActionSettingsBrightness extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-cell", JSImport.Default)
  object ActionSettingsCell extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-ethernet", JSImport.Default)
  object ActionSettingsEthernet extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-input-antenna", JSImport.Default)
  object ActionSettingsInputAntenna extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-input-component", JSImport.Default)
  object ActionSettingsInputComponent extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-input-composite", JSImport.Default)
  object ActionSettingsInputComposite extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-input-hdmi", JSImport.Default)
  object ActionSettingsInputHdmi extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-input-svideo", JSImport.Default)
  object ActionSettingsInputSvideo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-overscan", JSImport.Default)
  object ActionSettingsOverscan extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-phone", JSImport.Default)
  object ActionSettingsPhone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-power", JSImport.Default)
  object ActionSettingsPower extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-remote", JSImport.Default)
  object ActionSettingsRemote extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings-voice", JSImport.Default)
  object ActionSettingsVoice extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/settings", JSImport.Default)
  object ActionSettings extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/shop-two", JSImport.Default)
  object ActionShopTwo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/shop", JSImport.Default)
  object ActionShop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/shopping-basket", JSImport.Default)
  object ActionShoppingBasket extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/shopping-cart", JSImport.Default)
  object ActionShoppingCart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/speaker-notes-off", JSImport.Default)
  object ActionSpeakerNotesOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/speaker-notes", JSImport.Default)
  object ActionSpeakerNotes extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/spellcheck", JSImport.Default)
  object ActionSpellcheck extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/stars", JSImport.Default)
  object ActionStars extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/store", JSImport.Default)
  object ActionStore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/subject", JSImport.Default)
  object ActionSubject extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/supervisor-account", JSImport.Default)
  object ActionSupervisorAccount extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/swap-horiz", JSImport.Default)
  object ActionSwapHoriz extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/swap-vert", JSImport.Default)
  object ActionSwapVert extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/swap-vertical-circle", JSImport.Default)
  object ActionSwapVerticalCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/system-update-alt", JSImport.Default)
  object ActionSystemUpdateAlt extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/tab-unselected", JSImport.Default)
  object ActionTabUnselected extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/tab", JSImport.Default)
  object ActionTab extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/theaters", JSImport.Default)
  object ActionTheaters extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/three-d-rotation", JSImport.Default)
  object ActionThreeDRotation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/thumb-down", JSImport.Default)
  object ActionThumbDown extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/thumb-up", JSImport.Default)
  object ActionThumbUp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/thumbs-up-down", JSImport.Default)
  object ActionThumbsUpDown extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/timeline", JSImport.Default)
  object ActionTimeline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/toc", JSImport.Default)
  object ActionToc extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/today", JSImport.Default)
  object ActionToday extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/toll", JSImport.Default)
  object ActionToll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/touch-app", JSImport.Default)
  object ActionTouchApp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/track-changes", JSImport.Default)
  object ActionTrackChanges extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/translate", JSImport.Default)
  object ActionTranslate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/trending-down", JSImport.Default)
  object ActionTrendingDown extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/trending-flat", JSImport.Default)
  object ActionTrendingFlat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/trending-up", JSImport.Default)
  object ActionTrendingUp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/turned-in-not", JSImport.Default)
  object ActionTurnedInNot extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/turned-in", JSImport.Default)
  object ActionTurnedIn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/update", JSImport.Default)
  object ActionUpdate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/verified-user", JSImport.Default)
  object ActionVerifiedUser extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-agenda", JSImport.Default)
  object ActionViewAgenda extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-array", JSImport.Default)
  object ActionViewArray extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-carousel", JSImport.Default)
  object ActionViewCarousel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-column", JSImport.Default)
  object ActionViewColumn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-day", JSImport.Default)
  object ActionViewDay extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-headline", JSImport.Default)
  object ActionViewHeadline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-list", JSImport.Default)
  object ActionViewList extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-module", JSImport.Default)
  object ActionViewModule extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-quilt", JSImport.Default)
  object ActionViewQuilt extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-stream", JSImport.Default)
  object ActionViewStream extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/view-week", JSImport.Default)
  object ActionViewWeek extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/visibility-off", JSImport.Default)
  object ActionVisibilityOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/visibility", JSImport.Default)
  object ActionVisibility extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/watch-later", JSImport.Default)
  object ActionWatchLater extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/work", JSImport.Default)
  object ActionWork extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/youtube-searched-for", JSImport.Default)
  object ActionYoutubeSearchedFor extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/zoom-in", JSImport.Default)
  object ActionZoomIn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/action/zoom-out", JSImport.Default)
  object ActionZoomOut extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/alert/add-alert", JSImport.Default)
  object AlertAddAlert extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/alert/error-outline", JSImport.Default)
  object AlertErrorOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/alert/error", JSImport.Default)
  object AlertError extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/alert/warning", JSImport.Default)
  object AlertWarning extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/add-to-queue", JSImport.Default)
  object AvAddToQueue extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/airplay", JSImport.Default)
  object AvAirplay extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/album", JSImport.Default)
  object AvAlbum extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/art-track", JSImport.Default)
  object AvArtTrack extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/av-timer", JSImport.Default)
  object AvAvTimer extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/branding-watermark", JSImport.Default)
  object AvBrandingWatermark extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/call-to-action", JSImport.Default)
  object AvCallToAction extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/closed-caption", JSImport.Default)
  object AvClosedCaption extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/equalizer", JSImport.Default)
  object AvEqualizer extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/explicit", JSImport.Default)
  object AvExplicit extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/fast-forward", JSImport.Default)
  object AvFastForward extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/fast-rewind", JSImport.Default)
  object AvFastRewind extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/featured-play-list", JSImport.Default)
  object AvFeaturedPlayList extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/featured-video", JSImport.Default)
  object AvFeaturedVideo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/fiber-dvr", JSImport.Default)
  object AvFiberDvr extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/fiber-manual-record", JSImport.Default)
  object AvFiberManualRecord extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/fiber-new", JSImport.Default)
  object AvFiberNew extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/fiber-pin", JSImport.Default)
  object AvFiberPin extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/fiber-smart-record", JSImport.Default)
  object AvFiberSmartRecord extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/forward-10", JSImport.Default)
  object AvForward10 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/forward-30", JSImport.Default)
  object AvForward30 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/forward-5", JSImport.Default)
  object AvForward5 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/games", JSImport.Default)
  object AvGames extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/hd", JSImport.Default)
  object AvHd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/hearing", JSImport.Default)
  object AvHearing extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/high-quality", JSImport.Default)
  object AvHighQuality extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/library-add", JSImport.Default)
  object AvLibraryAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/library-books", JSImport.Default)
  object AvLibraryBooks extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/library-music", JSImport.Default)
  object AvLibraryMusic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/loop", JSImport.Default)
  object AvLoop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/mic-none", JSImport.Default)
  object AvMicNone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/mic-off", JSImport.Default)
  object AvMicOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/mic", JSImport.Default)
  object AvMic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/movie", JSImport.Default)
  object AvMovie extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/music-video", JSImport.Default)
  object AvMusicVideo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/new-releases", JSImport.Default)
  object AvNewReleases extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/not-interested", JSImport.Default)
  object AvNotInterested extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/note", JSImport.Default)
  object AvNote extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/pause-circle-filled", JSImport.Default)
  object AvPauseCircleFilled extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/pause-circle-outline", JSImport.Default)
  object AvPauseCircleOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/pause", JSImport.Default)
  object AvPause extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/play-arrow", JSImport.Default)
  object AvPlayArrow extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/play-circle-filled", JSImport.Default)
  object AvPlayCircleFilled extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/play-circle-outline", JSImport.Default)
  object AvPlayCircleOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/playlist-add-check", JSImport.Default)
  object AvPlaylistAddCheck extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/playlist-add", JSImport.Default)
  object AvPlaylistAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/playlist-play", JSImport.Default)
  object AvPlaylistPlay extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/queue-music", JSImport.Default)
  object AvQueueMusic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/queue-play-next", JSImport.Default)
  object AvQueuePlayNext extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/queue", JSImport.Default)
  object AvQueue extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/radio", JSImport.Default)
  object AvRadio extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/recent-actors", JSImport.Default)
  object AvRecentActors extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/remove-from-queue", JSImport.Default)
  object AvRemoveFromQueue extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/repeat-one", JSImport.Default)
  object AvRepeatOne extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/repeat", JSImport.Default)
  object AvRepeat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/replay-10", JSImport.Default)
  object AvReplay10 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/replay-30", JSImport.Default)
  object AvReplay30 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/replay-5", JSImport.Default)
  object AvReplay5 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/replay", JSImport.Default)
  object AvReplay extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/shuffle", JSImport.Default)
  object AvShuffle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/skip-next", JSImport.Default)
  object AvSkipNext extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/skip-previous", JSImport.Default)
  object AvSkipPrevious extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/slow-motion-video", JSImport.Default)
  object AvSlowMotionVideo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/snooze", JSImport.Default)
  object AvSnooze extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/sort-by-alpha", JSImport.Default)
  object AvSortByAlpha extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/stop", JSImport.Default)
  object AvStop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/subscriptions", JSImport.Default)
  object AvSubscriptions extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/subtitles", JSImport.Default)
  object AvSubtitles extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/surround-sound", JSImport.Default)
  object AvSurroundSound extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/video-call", JSImport.Default)
  object AvVideoCall extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/video-label", JSImport.Default)
  object AvVideoLabel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/video-library", JSImport.Default)
  object AvVideoLibrary extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/videocam-off", JSImport.Default)
  object AvVideocamOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/videocam", JSImport.Default)
  object AvVideocam extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/volume-down", JSImport.Default)
  object AvVolumeDown extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/volume-mute", JSImport.Default)
  object AvVolumeMute extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/volume-off", JSImport.Default)
  object AvVolumeOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/volume-up", JSImport.Default)
  object AvVolumeUp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/web-asset", JSImport.Default)
  object AvWebAsset extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/av/web", JSImport.Default)
  object AvWeb extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/business", JSImport.Default)
  object CommunicationBusiness extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call-end", JSImport.Default)
  object CommunicationCallEnd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call-made", JSImport.Default)
  object CommunicationCallMade extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call-merge", JSImport.Default)
  object CommunicationCallMerge extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call-missed-outgoing",
                       JSImport.Default)
  object CommunicationCallMissedOutgoing extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call-missed", JSImport.Default)
  object CommunicationCallMissed extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call-received", JSImport.Default)
  object CommunicationCallReceived extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call-split", JSImport.Default)
  object CommunicationCallSplit extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/call", JSImport.Default)
  object CommunicationCall extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/chat-bubble-outline", JSImport.Default)
  object CommunicationChatBubbleOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/chat-bubble", JSImport.Default)
  object CommunicationChatBubble extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/chat", JSImport.Default)
  object CommunicationChat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/clear-all", JSImport.Default)
  object CommunicationClearAll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/comment", JSImport.Default)
  object CommunicationComment extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/contact-mail", JSImport.Default)
  object CommunicationContactMail extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/contact-phone", JSImport.Default)
  object CommunicationContactPhone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/contacts", JSImport.Default)
  object CommunicationContacts extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/dialer-sip", JSImport.Default)
  object CommunicationDialerSip extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/dialpad", JSImport.Default)
  object CommunicationDialpad extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/email", JSImport.Default)
  object CommunicationEmail extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/forum", JSImport.Default)
  object CommunicationForum extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/import-contacts", JSImport.Default)
  object CommunicationImportContacts extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/import-export", JSImport.Default)
  object CommunicationImportExport extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/invert-colors-off", JSImport.Default)
  object CommunicationInvertColorsOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/live-help", JSImport.Default)
  object CommunicationLiveHelp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/location-off", JSImport.Default)
  object CommunicationLocationOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/location-on", JSImport.Default)
  object CommunicationLocationOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/mail-outline", JSImport.Default)
  object CommunicationMailOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/message", JSImport.Default)
  object CommunicationMessage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/no-sim", JSImport.Default)
  object CommunicationNoSim extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/phone", JSImport.Default)
  object CommunicationPhone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/phonelink-erase", JSImport.Default)
  object CommunicationPhonelinkErase extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/phonelink-lock", JSImport.Default)
  object CommunicationPhonelinkLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/phonelink-ring", JSImport.Default)
  object CommunicationPhonelinkRing extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/phonelink-setup", JSImport.Default)
  object CommunicationPhonelinkSetup extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/portable-wifi-off", JSImport.Default)
  object CommunicationPortableWifiOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/present-to-all", JSImport.Default)
  object CommunicationPresentToAll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/ring-volume", JSImport.Default)
  object CommunicationRingVolume extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/rss-feed", JSImport.Default)
  object CommunicationRssFeed extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/screen-share", JSImport.Default)
  object CommunicationScreenShare extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/speaker-phone", JSImport.Default)
  object CommunicationSpeakerPhone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/stay-current-landscape",
                       JSImport.Default)
  object CommunicationStayCurrentLandscape extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/stay-current-portrait",
                       JSImport.Default)
  object CommunicationStayCurrentPortrait extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/stay-primary-landscape",
                       JSImport.Default)
  object CommunicationStayPrimaryLandscape extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/stay-primary-portrait",
                       JSImport.Default)
  object CommunicationStayPrimaryPortrait extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/stop-screen-share", JSImport.Default)
  object CommunicationStopScreenShare extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/swap-calls", JSImport.Default)
  object CommunicationSwapCalls extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/textsms", JSImport.Default)
  object CommunicationTextsms extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/voicemail", JSImport.Default)
  object CommunicationVoicemail extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/communication/vpn-key", JSImport.Default)
  object CommunicationVpnKey extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/add-box", JSImport.Default)
  object ContentAddBox extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/add-circle-outline", JSImport.Default)
  object ContentAddCircleOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/add-circle", JSImport.Default)
  object ContentAddCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/add", JSImport.Default)
  object ContentAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/archive", JSImport.Default)
  object ContentArchive extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/backspace", JSImport.Default)
  object ContentBackspace extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/block", JSImport.Default)
  object ContentBlock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/clear", JSImport.Default)
  object ContentClear extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/content-copy", JSImport.Default)
  object ContentContentCopy extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/content-cut", JSImport.Default)
  object ContentContentCut extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/content-paste", JSImport.Default)
  object ContentContentPaste extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/create", JSImport.Default)
  object ContentCreate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/delete-sweep", JSImport.Default)
  object ContentDeleteSweep extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/drafts", JSImport.Default)
  object ContentDrafts extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/filter-list", JSImport.Default)
  object ContentFilterList extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/flag", JSImport.Default)
  object ContentFlag extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/font-download", JSImport.Default)
  object ContentFontDownload extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/forward", JSImport.Default)
  object ContentForward extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/gesture", JSImport.Default)
  object ContentGesture extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/inbox", JSImport.Default)
  object ContentInbox extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/link", JSImport.Default)
  object ContentLink extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/low-priority", JSImport.Default)
  object ContentLowPriority extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/mail", JSImport.Default)
  object ContentMail extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/markunread", JSImport.Default)
  object ContentMarkunread extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/move-to-inbox", JSImport.Default)
  object ContentMoveToInbox extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/next-week", JSImport.Default)
  object ContentNextWeek extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/redo", JSImport.Default)
  object ContentRedo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/remove-circle-outline", JSImport.Default)
  object ContentRemoveCircleOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/remove-circle", JSImport.Default)
  object ContentRemoveCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/remove", JSImport.Default)
  object ContentRemove extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/reply-all", JSImport.Default)
  object ContentReplyAll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/reply", JSImport.Default)
  object ContentReply extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/report", JSImport.Default)
  object ContentReport extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/save", JSImport.Default)
  object ContentSave extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/select-all", JSImport.Default)
  object ContentSelectAll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/send", JSImport.Default)
  object ContentSend extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/sort", JSImport.Default)
  object ContentSort extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/text-format", JSImport.Default)
  object ContentTextFormat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/unarchive", JSImport.Default)
  object ContentUnarchive extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/undo", JSImport.Default)
  object ContentUndo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/content/weekend", JSImport.Default)
  object ContentWeekend extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/access-alarm", JSImport.Default)
  object DeviceAccessAlarm extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/access-alarms", JSImport.Default)
  object DeviceAccessAlarms extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/access-time", JSImport.Default)
  object DeviceAccessTime extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/add-alarm", JSImport.Default)
  object DeviceAddAlarm extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/airplanemode-active", JSImport.Default)
  object DeviceAirplanemodeActive extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/airplanemode-inactive", JSImport.Default)
  object DeviceAirplanemodeInactive extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-20", JSImport.Default)
  object DeviceBattery20 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-30", JSImport.Default)
  object DeviceBattery30 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-50", JSImport.Default)
  object DeviceBattery50 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-60", JSImport.Default)
  object DeviceBattery60 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-80", JSImport.Default)
  object DeviceBattery80 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-90", JSImport.Default)
  object DeviceBattery90 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-alert", JSImport.Default)
  object DeviceBatteryAlert extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-charging-20", JSImport.Default)
  object DeviceBatteryCharging20 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-charging-30", JSImport.Default)
  object DeviceBatteryCharging30 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-charging-50", JSImport.Default)
  object DeviceBatteryCharging50 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-charging-60", JSImport.Default)
  object DeviceBatteryCharging60 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-charging-80", JSImport.Default)
  object DeviceBatteryCharging80 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-charging-90", JSImport.Default)
  object DeviceBatteryCharging90 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-charging-full", JSImport.Default)
  object DeviceBatteryChargingFull extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-full", JSImport.Default)
  object DeviceBatteryFull extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-std", JSImport.Default)
  object DeviceBatteryStd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/battery-unknown", JSImport.Default)
  object DeviceBatteryUnknown extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/bluetooth-connected", JSImport.Default)
  object DeviceBluetoothConnected extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/bluetooth-disabled", JSImport.Default)
  object DeviceBluetoothDisabled extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/bluetooth-searching", JSImport.Default)
  object DeviceBluetoothSearching extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/bluetooth", JSImport.Default)
  object DeviceBluetooth extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/brightness-auto", JSImport.Default)
  object DeviceBrightnessAuto extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/brightness-high", JSImport.Default)
  object DeviceBrightnessHigh extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/brightness-low", JSImport.Default)
  object DeviceBrightnessLow extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/brightness-medium", JSImport.Default)
  object DeviceBrightnessMedium extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/data-usage", JSImport.Default)
  object DeviceDataUsage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/developer-mode", JSImport.Default)
  object DeviceDeveloperMode extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/devices", JSImport.Default)
  object DeviceDevices extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/dvr", JSImport.Default)
  object DeviceDvr extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/gps-fixed", JSImport.Default)
  object DeviceGpsFixed extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/gps-not-fixed", JSImport.Default)
  object DeviceGpsNotFixed extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/gps-off", JSImport.Default)
  object DeviceGpsOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/graphic-eq", JSImport.Default)
  object DeviceGraphicEq extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/location-disabled", JSImport.Default)
  object DeviceLocationDisabled extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/location-searching", JSImport.Default)
  object DeviceLocationSearching extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/network-cell", JSImport.Default)
  object DeviceNetworkCell extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/network-wifi", JSImport.Default)
  object DeviceNetworkWifi extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/nfc", JSImport.Default)
  object DeviceNfc extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/screen-lock-landscape", JSImport.Default)
  object DeviceScreenLockLandscape extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/screen-lock-portrait", JSImport.Default)
  object DeviceScreenLockPortrait extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/screen-lock-rotation", JSImport.Default)
  object DeviceScreenLockRotation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/screen-rotation", JSImport.Default)
  object DeviceScreenRotation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/sd-storage", JSImport.Default)
  object DeviceSdStorage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/settings-system-daydream", JSImport.Default)
  object DeviceSettingsSystemDaydream extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-0-bar", JSImport.Default)
  object DeviceSignalCellular0Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-1-bar", JSImport.Default)
  object DeviceSignalCellular1Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-2-bar", JSImport.Default)
  object DeviceSignalCellular2Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-3-bar", JSImport.Default)
  object DeviceSignalCellular3Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-4-bar", JSImport.Default)
  object DeviceSignalCellular4Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-connected-no-internet-0-bar",
                       JSImport.Default)
  object DeviceSignalCellularConnectedNoInternet0Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-connected-no-internet-1-bar",
                       JSImport.Default)
  object DeviceSignalCellularConnectedNoInternet1Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-connected-no-internet-2-bar",
                       JSImport.Default)
  object DeviceSignalCellularConnectedNoInternet2Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-connected-no-internet-3-bar",
                       JSImport.Default)
  object DeviceSignalCellularConnectedNoInternet3Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-connected-no-internet-4-bar",
                       JSImport.Default)
  object DeviceSignalCellularConnectedNoInternet4Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-no-sim", JSImport.Default)
  object DeviceSignalCellularNoSim extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-null", JSImport.Default)
  object DeviceSignalCellularNull extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-cellular-off", JSImport.Default)
  object DeviceSignalCellularOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-0-bar", JSImport.Default)
  object DeviceSignalWifi0Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-1-bar-lock", JSImport.Default)
  object DeviceSignalWifi1BarLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-1-bar", JSImport.Default)
  object DeviceSignalWifi1Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-2-bar-lock", JSImport.Default)
  object DeviceSignalWifi2BarLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-2-bar", JSImport.Default)
  object DeviceSignalWifi2Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-3-bar-lock", JSImport.Default)
  object DeviceSignalWifi3BarLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-3-bar", JSImport.Default)
  object DeviceSignalWifi3Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-4-bar-lock", JSImport.Default)
  object DeviceSignalWifi4BarLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-4-bar", JSImport.Default)
  object DeviceSignalWifi4Bar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/signal-wifi-off", JSImport.Default)
  object DeviceSignalWifiOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/storage", JSImport.Default)
  object DeviceStorage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/usb", JSImport.Default)
  object DeviceUsb extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/wallpaper", JSImport.Default)
  object DeviceWallpaper extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/widgets", JSImport.Default)
  object DeviceWidgets extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/wifi-lock", JSImport.Default)
  object DeviceWifiLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/device/wifi-tethering", JSImport.Default)
  object DeviceWifiTethering extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/attach-file", JSImport.Default)
  object EditorAttachFile extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/attach-money", JSImport.Default)
  object EditorAttachMoney extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-all", JSImport.Default)
  object EditorBorderAll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-bottom", JSImport.Default)
  object EditorBorderBottom extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-clear", JSImport.Default)
  object EditorBorderClear extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-color", JSImport.Default)
  object EditorBorderColor extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-horizontal", JSImport.Default)
  object EditorBorderHorizontal extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-inner", JSImport.Default)
  object EditorBorderInner extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-left", JSImport.Default)
  object EditorBorderLeft extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-outer", JSImport.Default)
  object EditorBorderOuter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-right", JSImport.Default)
  object EditorBorderRight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-style", JSImport.Default)
  object EditorBorderStyle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-top", JSImport.Default)
  object EditorBorderTop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/border-vertical", JSImport.Default)
  object EditorBorderVertical extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/bubble-chart", JSImport.Default)
  object EditorBubbleChart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/drag-handle", JSImport.Default)
  object EditorDragHandle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-align-center", JSImport.Default)
  object EditorFormatAlignCenter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-align-justify", JSImport.Default)
  object EditorFormatAlignJustify extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-align-left", JSImport.Default)
  object EditorFormatAlignLeft extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-align-right", JSImport.Default)
  object EditorFormatAlignRight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-bold", JSImport.Default)
  object EditorFormatBold extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-clear", JSImport.Default)
  object EditorFormatClear extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-color-fill", JSImport.Default)
  object EditorFormatColorFill extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-color-reset", JSImport.Default)
  object EditorFormatColorReset extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-color-text", JSImport.Default)
  object EditorFormatColorText extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-indent-decrease", JSImport.Default)
  object EditorFormatIndentDecrease extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-indent-increase", JSImport.Default)
  object EditorFormatIndentIncrease extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-italic", JSImport.Default)
  object EditorFormatItalic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-line-spacing", JSImport.Default)
  object EditorFormatLineSpacing extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-list-bulleted", JSImport.Default)
  object EditorFormatListBulleted extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-list-numbered", JSImport.Default)
  object EditorFormatListNumbered extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-paint", JSImport.Default)
  object EditorFormatPaint extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-quote", JSImport.Default)
  object EditorFormatQuote extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-shapes", JSImport.Default)
  object EditorFormatShapes extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-size", JSImport.Default)
  object EditorFormatSize extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-strikethrough", JSImport.Default)
  object EditorFormatStrikethrough extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-textdirection-l-to-r",
                       JSImport.Default)
  object EditorFormatTextdirectionLToR extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-textdirection-r-to-l",
                       JSImport.Default)
  object EditorFormatTextdirectionRToL extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/format-underlined", JSImport.Default)
  object EditorFormatUnderlined extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/functions", JSImport.Default)
  object EditorFunctions extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/highlight", JSImport.Default)
  object EditorHighlight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/insert-chart", JSImport.Default)
  object EditorInsertChart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/insert-comment", JSImport.Default)
  object EditorInsertComment extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/insert-drive-file", JSImport.Default)
  object EditorInsertDriveFile extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/insert-emoticon", JSImport.Default)
  object EditorInsertEmoticon extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/insert-invitation", JSImport.Default)
  object EditorInsertInvitation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/insert-link", JSImport.Default)
  object EditorInsertLink extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/insert-photo", JSImport.Default)
  object EditorInsertPhoto extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/linear-scale", JSImport.Default)
  object EditorLinearScale extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/merge-type", JSImport.Default)
  object EditorMergeType extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/mode-comment", JSImport.Default)
  object EditorModeComment extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/mode-edit", JSImport.Default)
  object EditorModeEdit extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/monetization-on", JSImport.Default)
  object EditorMonetizationOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/money-off", JSImport.Default)
  object EditorMoneyOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/multiline-chart", JSImport.Default)
  object EditorMultilineChart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/pie-chart-outlined", JSImport.Default)
  object EditorPieChartOutlined extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/pie-chart", JSImport.Default)
  object EditorPieChart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/publish", JSImport.Default)
  object EditorPublish extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/short-text", JSImport.Default)
  object EditorShortText extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/show-chart", JSImport.Default)
  object EditorShowChart extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/space-bar", JSImport.Default)
  object EditorSpaceBar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/strikethrough-s", JSImport.Default)
  object EditorStrikethroughS extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/text-fields", JSImport.Default)
  object EditorTextFields extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/title", JSImport.Default)
  object EditorTitle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/vertical-align-bottom", JSImport.Default)
  object EditorVerticalAlignBottom extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/vertical-align-center", JSImport.Default)
  object EditorVerticalAlignCenter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/vertical-align-top", JSImport.Default)
  object EditorVerticalAlignTop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/editor/wrap-text", JSImport.Default)
  object EditorWrapText extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/attachment", JSImport.Default)
  object FileAttachment extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/cloud-circle", JSImport.Default)
  object FileCloudCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/cloud-done", JSImport.Default)
  object FileCloudDone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/cloud-download", JSImport.Default)
  object FileCloudDownload extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/cloud-off", JSImport.Default)
  object FileCloudOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/cloud-queue", JSImport.Default)
  object FileCloudQueue extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/cloud-upload", JSImport.Default)
  object FileCloudUpload extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/cloud", JSImport.Default)
  object FileCloud extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/create-new-folder", JSImport.Default)
  object FileCreateNewFolder extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/file-download", JSImport.Default)
  object FileFileDownload extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/file-upload", JSImport.Default)
  object FileFileUpload extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/folder-open", JSImport.Default)
  object FileFolderOpen extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/folder-shared", JSImport.Default)
  object FileFolderShared extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/file/folder", JSImport.Default)
  object FileFolder extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/cast-connected", JSImport.Default)
  object HardwareCastConnected extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/cast", JSImport.Default)
  object HardwareCast extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/computer", JSImport.Default)
  object HardwareComputer extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/desktop-mac", JSImport.Default)
  object HardwareDesktopMac extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/desktop-windows", JSImport.Default)
  object HardwareDesktopWindows extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/developer-board", JSImport.Default)
  object HardwareDeveloperBoard extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/device-hub", JSImport.Default)
  object HardwareDeviceHub extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/devices-other", JSImport.Default)
  object HardwareDevicesOther extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/dock", JSImport.Default)
  object HardwareDock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/gamepad", JSImport.Default)
  object HardwareGamepad extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/headset-mic", JSImport.Default)
  object HardwareHeadsetMic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/headset", JSImport.Default)
  object HardwareHeadset extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-arrow-down", JSImport.Default)
  object HardwareKeyboardArrowDown extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-arrow-left", JSImport.Default)
  object HardwareKeyboardArrowLeft extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-arrow-right", JSImport.Default)
  object HardwareKeyboardArrowRight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-arrow-up", JSImport.Default)
  object HardwareKeyboardArrowUp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-backspace", JSImport.Default)
  object HardwareKeyboardBackspace extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-capslock", JSImport.Default)
  object HardwareKeyboardCapslock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-hide", JSImport.Default)
  object HardwareKeyboardHide extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-return", JSImport.Default)
  object HardwareKeyboardReturn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-tab", JSImport.Default)
  object HardwareKeyboardTab extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard-voice", JSImport.Default)
  object HardwareKeyboardVoice extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/keyboard", JSImport.Default)
  object HardwareKeyboard extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/laptop-chromebook", JSImport.Default)
  object HardwareLaptopChromebook extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/laptop-mac", JSImport.Default)
  object HardwareLaptopMac extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/laptop-windows", JSImport.Default)
  object HardwareLaptopWindows extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/laptop", JSImport.Default)
  object HardwareLaptop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/memory", JSImport.Default)
  object HardwareMemory extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/mouse", JSImport.Default)
  object HardwareMouse extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/phone-android", JSImport.Default)
  object HardwarePhoneAndroid extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/phone-iphone", JSImport.Default)
  object HardwarePhoneIphone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/phonelink-off", JSImport.Default)
  object HardwarePhonelinkOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/phonelink", JSImport.Default)
  object HardwarePhonelink extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/power-input", JSImport.Default)
  object HardwarePowerInput extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/router", JSImport.Default)
  object HardwareRouter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/scanner", JSImport.Default)
  object HardwareScanner extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/security", JSImport.Default)
  object HardwareSecurity extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/sim-card", JSImport.Default)
  object HardwareSimCard extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/smartphone", JSImport.Default)
  object HardwareSmartphone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/speaker-group", JSImport.Default)
  object HardwareSpeakerGroup extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/speaker", JSImport.Default)
  object HardwareSpeaker extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/tablet-android", JSImport.Default)
  object HardwareTabletAndroid extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/tablet-mac", JSImport.Default)
  object HardwareTabletMac extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/tablet", JSImport.Default)
  object HardwareTablet extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/toys", JSImport.Default)
  object HardwareToys extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/tv", JSImport.Default)
  object HardwareTv extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/videogame-asset", JSImport.Default)
  object HardwareVideogameAsset extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/hardware/watch", JSImport.Default)
  object HardwareWatch extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/add-a-photo", JSImport.Default)
  object ImageAddAPhoto extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/add-to-photos", JSImport.Default)
  object ImageAddToPhotos extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/adjust", JSImport.Default)
  object ImageAdjust extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/assistant-photo", JSImport.Default)
  object ImageAssistantPhoto extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/assistant", JSImport.Default)
  object ImageAssistant extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/audiotrack", JSImport.Default)
  object ImageAudiotrack extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/blur-circular", JSImport.Default)
  object ImageBlurCircular extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/blur-linear", JSImport.Default)
  object ImageBlurLinear extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/blur-off", JSImport.Default)
  object ImageBlurOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/blur-on", JSImport.Default)
  object ImageBlurOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brightness-1", JSImport.Default)
  object ImageBrightness1 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brightness-2", JSImport.Default)
  object ImageBrightness2 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brightness-3", JSImport.Default)
  object ImageBrightness3 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brightness-4", JSImport.Default)
  object ImageBrightness4 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brightness-5", JSImport.Default)
  object ImageBrightness5 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brightness-6", JSImport.Default)
  object ImageBrightness6 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brightness-7", JSImport.Default)
  object ImageBrightness7 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/broken-image", JSImport.Default)
  object ImageBrokenImage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/brush", JSImport.Default)
  object ImageBrush extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/burst-mode", JSImport.Default)
  object ImageBurstMode extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/camera-alt", JSImport.Default)
  object ImageCameraAlt extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/camera-front", JSImport.Default)
  object ImageCameraFront extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/camera-rear", JSImport.Default)
  object ImageCameraRear extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/camera-roll", JSImport.Default)
  object ImageCameraRoll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/camera", JSImport.Default)
  object ImageCamera extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/center-focus-strong", JSImport.Default)
  object ImageCenterFocusStrong extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/center-focus-weak", JSImport.Default)
  object ImageCenterFocusWeak extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/collections-bookmark", JSImport.Default)
  object ImageCollectionsBookmark extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/collections", JSImport.Default)
  object ImageCollections extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/color-lens", JSImport.Default)
  object ImageColorLens extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/colorize", JSImport.Default)
  object ImageColorize extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/compare", JSImport.Default)
  object ImageCompare extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/control-point-duplicate", JSImport.Default)
  object ImageControlPointDuplicate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/control-point", JSImport.Default)
  object ImageControlPoint extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-16-9", JSImport.Default)
  object ImageCrop169 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-3-2", JSImport.Default)
  object ImageCrop32 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-5-4", JSImport.Default)
  object ImageCrop54 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-7-5", JSImport.Default)
  object ImageCrop75 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-din", JSImport.Default)
  object ImageCropDin extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-free", JSImport.Default)
  object ImageCropFree extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-landscape", JSImport.Default)
  object ImageCropLandscape extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-original", JSImport.Default)
  object ImageCropOriginal extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-portrait", JSImport.Default)
  object ImageCropPortrait extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-rotate", JSImport.Default)
  object ImageCropRotate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop-square", JSImport.Default)
  object ImageCropSquare extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/crop", JSImport.Default)
  object ImageCrop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/dehaze", JSImport.Default)
  object ImageDehaze extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/details", JSImport.Default)
  object ImageDetails extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/edit", JSImport.Default)
  object ImageEdit extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/exposure-neg-1", JSImport.Default)
  object ImageExposureNeg1 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/exposure-neg-2", JSImport.Default)
  object ImageExposureNeg2 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/exposure-plus-1", JSImport.Default)
  object ImageExposurePlus1 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/exposure-plus-2", JSImport.Default)
  object ImageExposurePlus2 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/exposure-zero", JSImport.Default)
  object ImageExposureZero extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/exposure", JSImport.Default)
  object ImageExposure extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-1", JSImport.Default)
  object ImageFilter1 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-2", JSImport.Default)
  object ImageFilter2 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-3", JSImport.Default)
  object ImageFilter3 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-4", JSImport.Default)
  object ImageFilter4 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-5", JSImport.Default)
  object ImageFilter5 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-6", JSImport.Default)
  object ImageFilter6 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-7", JSImport.Default)
  object ImageFilter7 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-8", JSImport.Default)
  object ImageFilter8 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-9-plus", JSImport.Default)
  object ImageFilter9Plus extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-9", JSImport.Default)
  object ImageFilter9 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-b-and-w", JSImport.Default)
  object ImageFilterBAndW extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-center-focus", JSImport.Default)
  object ImageFilterCenterFocus extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-drama", JSImport.Default)
  object ImageFilterDrama extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-frames", JSImport.Default)
  object ImageFilterFrames extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-hdr", JSImport.Default)
  object ImageFilterHdr extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-none", JSImport.Default)
  object ImageFilterNone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-tilt-shift", JSImport.Default)
  object ImageFilterTiltShift extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter-vintage", JSImport.Default)
  object ImageFilterVintage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/filter", JSImport.Default)
  object ImageFilter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/flare", JSImport.Default)
  object ImageFlare extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/flash-auto", JSImport.Default)
  object ImageFlashAuto extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/flash-off", JSImport.Default)
  object ImageFlashOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/flash-on", JSImport.Default)
  object ImageFlashOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/flip", JSImport.Default)
  object ImageFlip extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/gradient", JSImport.Default)
  object ImageGradient extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/grain", JSImport.Default)
  object ImageGrain extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/grid-off", JSImport.Default)
  object ImageGridOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/grid-on", JSImport.Default)
  object ImageGridOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/hdr-off", JSImport.Default)
  object ImageHdrOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/hdr-on", JSImport.Default)
  object ImageHdrOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/hdr-strong", JSImport.Default)
  object ImageHdrStrong extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/hdr-weak", JSImport.Default)
  object ImageHdrWeak extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/healing", JSImport.Default)
  object ImageHealing extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/image-aspect-ratio", JSImport.Default)
  object ImageImageAspectRatio extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/image", JSImport.Default)
  object ImageImage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/iso", JSImport.Default)
  object ImageIso extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/landscape", JSImport.Default)
  object ImageLandscape extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/leak-add", JSImport.Default)
  object ImageLeakAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/leak-remove", JSImport.Default)
  object ImageLeakRemove extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/lens", JSImport.Default)
  object ImageLens extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/linked-camera", JSImport.Default)
  object ImageLinkedCamera extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/looks-3", JSImport.Default)
  object ImageLooks3 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/looks-4", JSImport.Default)
  object ImageLooks4 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/looks-5", JSImport.Default)
  object ImageLooks5 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/looks-6", JSImport.Default)
  object ImageLooks6 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/looks-one", JSImport.Default)
  object ImageLooksOne extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/looks-two", JSImport.Default)
  object ImageLooksTwo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/looks", JSImport.Default)
  object ImageLooks extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/loupe", JSImport.Default)
  object ImageLoupe extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/monochrome-photos", JSImport.Default)
  object ImageMonochromePhotos extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/movie-creation", JSImport.Default)
  object ImageMovieCreation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/movie-filter", JSImport.Default)
  object ImageMovieFilter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/music-note", JSImport.Default)
  object ImageMusicNote extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/nature-people", JSImport.Default)
  object ImageNaturePeople extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/nature", JSImport.Default)
  object ImageNature extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/navigate-before", JSImport.Default)
  object ImageNavigateBefore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/navigate-next", JSImport.Default)
  object ImageNavigateNext extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/palette", JSImport.Default)
  object ImagePalette extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/panorama-fish-eye", JSImport.Default)
  object ImagePanoramaFishEye extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/panorama-horizontal", JSImport.Default)
  object ImagePanoramaHorizontal extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/panorama-vertical", JSImport.Default)
  object ImagePanoramaVertical extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/panorama-wide-angle", JSImport.Default)
  object ImagePanoramaWideAngle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/panorama", JSImport.Default)
  object ImagePanorama extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo-album", JSImport.Default)
  object ImagePhotoAlbum extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo-camera", JSImport.Default)
  object ImagePhotoCamera extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo-filter", JSImport.Default)
  object ImagePhotoFilter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo-library", JSImport.Default)
  object ImagePhotoLibrary extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo-size-select-actual", JSImport.Default)
  object ImagePhotoSizeSelectActual extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo-size-select-large", JSImport.Default)
  object ImagePhotoSizeSelectLarge extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo-size-select-small", JSImport.Default)
  object ImagePhotoSizeSelectSmall extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/photo", JSImport.Default)
  object ImagePhoto extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/picture-as-pdf", JSImport.Default)
  object ImagePictureAsPdf extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/portrait", JSImport.Default)
  object ImagePortrait extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/remove-red-eye", JSImport.Default)
  object ImageRemoveRedEye extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/rotate-90-degrees-ccw", JSImport.Default)
  object ImageRotate90DegreesCcw extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/rotate-left", JSImport.Default)
  object ImageRotateLeft extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/rotate-right", JSImport.Default)
  object ImageRotateRight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/slideshow", JSImport.Default)
  object ImageSlideshow extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/straighten", JSImport.Default)
  object ImageStraighten extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/style", JSImport.Default)
  object ImageStyle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/switch-camera", JSImport.Default)
  object ImageSwitchCamera extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/switch-video", JSImport.Default)
  object ImageSwitchVideo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/tag-faces", JSImport.Default)
  object ImageTagFaces extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/texture", JSImport.Default)
  object ImageTexture extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/timelapse", JSImport.Default)
  object ImageTimelapse extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/timer-10", JSImport.Default)
  object ImageTimer10 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/timer-3", JSImport.Default)
  object ImageTimer3 extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/timer-off", JSImport.Default)
  object ImageTimerOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/timer", JSImport.Default)
  object ImageTimer extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/tonality", JSImport.Default)
  object ImageTonality extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/transform", JSImport.Default)
  object ImageTransform extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/tune", JSImport.Default)
  object ImageTune extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/view-comfy", JSImport.Default)
  object ImageViewComfy extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/view-compact", JSImport.Default)
  object ImageViewCompact extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/vignette", JSImport.Default)
  object ImageVignette extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/wb-auto", JSImport.Default)
  object ImageWbAuto extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/wb-cloudy", JSImport.Default)
  object ImageWbCloudy extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/wb-incandescent", JSImport.Default)
  object ImageWbIncandescent extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/wb-iridescent", JSImport.Default)
  object ImageWbIridescent extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/image/wb-sunny", JSImport.Default)
  object ImageWbSunny extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/add-location", JSImport.Default)
  object MapsAddLocation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/beenhere", JSImport.Default)
  object MapsBeenhere extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-bike", JSImport.Default)
  object MapsDirectionsBike extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-boat", JSImport.Default)
  object MapsDirectionsBoat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-bus", JSImport.Default)
  object MapsDirectionsBus extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-car", JSImport.Default)
  object MapsDirectionsCar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-railway", JSImport.Default)
  object MapsDirectionsRailway extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-run", JSImport.Default)
  object MapsDirectionsRun extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-subway", JSImport.Default)
  object MapsDirectionsSubway extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-transit", JSImport.Default)
  object MapsDirectionsTransit extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions-walk", JSImport.Default)
  object MapsDirectionsWalk extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/directions", JSImport.Default)
  object MapsDirections extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/edit-location", JSImport.Default)
  object MapsEditLocation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/ev-station", JSImport.Default)
  object MapsEvStation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/flight", JSImport.Default)
  object MapsFlight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/hotel", JSImport.Default)
  object MapsHotel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/layers-clear", JSImport.Default)
  object MapsLayersClear extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/layers", JSImport.Default)
  object MapsLayers extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-activity", JSImport.Default)
  object MapsLocalActivity extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-airport", JSImport.Default)
  object MapsLocalAirport extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-atm", JSImport.Default)
  object MapsLocalAtm extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-bar", JSImport.Default)
  object MapsLocalBar extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-cafe", JSImport.Default)
  object MapsLocalCafe extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-car-wash", JSImport.Default)
  object MapsLocalCarWash extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-convenience-store", JSImport.Default)
  object MapsLocalConvenienceStore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-dining", JSImport.Default)
  object MapsLocalDining extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-drink", JSImport.Default)
  object MapsLocalDrink extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-florist", JSImport.Default)
  object MapsLocalFlorist extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-gas-station", JSImport.Default)
  object MapsLocalGasStation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-grocery-store", JSImport.Default)
  object MapsLocalGroceryStore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-hospital", JSImport.Default)
  object MapsLocalHospital extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-hotel", JSImport.Default)
  object MapsLocalHotel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-laundry-service", JSImport.Default)
  object MapsLocalLaundryService extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-library", JSImport.Default)
  object MapsLocalLibrary extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-mall", JSImport.Default)
  object MapsLocalMall extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-movies", JSImport.Default)
  object MapsLocalMovies extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-offer", JSImport.Default)
  object MapsLocalOffer extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-parking", JSImport.Default)
  object MapsLocalParking extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-pharmacy", JSImport.Default)
  object MapsLocalPharmacy extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-phone", JSImport.Default)
  object MapsLocalPhone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-pizza", JSImport.Default)
  object MapsLocalPizza extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-play", JSImport.Default)
  object MapsLocalPlay extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-post-office", JSImport.Default)
  object MapsLocalPostOffice extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-printshop", JSImport.Default)
  object MapsLocalPrintshop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-see", JSImport.Default)
  object MapsLocalSee extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-shipping", JSImport.Default)
  object MapsLocalShipping extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/local-taxi", JSImport.Default)
  object MapsLocalTaxi extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/map", JSImport.Default)
  object MapsMap extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/my-location", JSImport.Default)
  object MapsMyLocation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/navigation", JSImport.Default)
  object MapsNavigation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/near-me", JSImport.Default)
  object MapsNearMe extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/person-pin-circle", JSImport.Default)
  object MapsPersonPinCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/person-pin", JSImport.Default)
  object MapsPersonPin extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/pin-drop", JSImport.Default)
  object MapsPinDrop extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/place", JSImport.Default)
  object MapsPlace extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/rate-review", JSImport.Default)
  object MapsRateReview extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/restaurant-menu", JSImport.Default)
  object MapsRestaurantMenu extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/restaurant", JSImport.Default)
  object MapsRestaurant extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/satellite", JSImport.Default)
  object MapsSatellite extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/store-mall-directory", JSImport.Default)
  object MapsStoreMallDirectory extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/streetview", JSImport.Default)
  object MapsStreetview extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/subway", JSImport.Default)
  object MapsSubway extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/terrain", JSImport.Default)
  object MapsTerrain extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/traffic", JSImport.Default)
  object MapsTraffic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/train", JSImport.Default)
  object MapsTrain extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/tram", JSImport.Default)
  object MapsTram extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/transfer-within-a-station", JSImport.Default)
  object MapsTransferWithinAStation extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/maps/zoom-out-map", JSImport.Default)
  object MapsZoomOutMap extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/apps", JSImport.Default)
  object NavigationApps extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/arrow-back", JSImport.Default)
  object NavigationArrowBack extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/arrow-downward", JSImport.Default)
  object NavigationArrowDownward extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/arrow-drop-down-circle", JSImport.Default)
  object NavigationArrowDropDownCircle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/arrow-drop-down", JSImport.Default)
  object NavigationArrowDropDown extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/arrow-drop-up", JSImport.Default)
  object NavigationArrowDropUp extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/arrow-forward", JSImport.Default)
  object NavigationArrowForward extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/arrow-upward", JSImport.Default)
  object NavigationArrowUpward extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/cancel", JSImport.Default)
  object NavigationCancel extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/check", JSImport.Default)
  object NavigationCheck extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/chevron-left", JSImport.Default)
  object NavigationChevronLeft extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/chevron-right", JSImport.Default)
  object NavigationChevronRight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/close", JSImport.Default)
  object NavigationClose extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/expand-less", JSImport.Default)
  object NavigationExpandLess extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/expand-more", JSImport.Default)
  object NavigationExpandMore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/first-page", JSImport.Default)
  object NavigationFirstPage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/fullscreen-exit", JSImport.Default)
  object NavigationFullscreenExit extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/fullscreen", JSImport.Default)
  object NavigationFullscreen extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/last-page", JSImport.Default)
  object NavigationLastPage extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/menu", JSImport.Default)
  object NavigationMenu extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/more-horiz", JSImport.Default)
  object NavigationMoreHoriz extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/more-vert", JSImport.Default)
  object NavigationMoreVert extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/refresh", JSImport.Default)
  object NavigationRefresh extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/subdirectory-arrow-left",
                       JSImport.Default)
  object NavigationSubdirectoryArrowLeft extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/subdirectory-arrow-right",
                       JSImport.Default)
  object NavigationSubdirectoryArrowRight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/unfold-less", JSImport.Default)
  object NavigationUnfoldLess extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation/unfold-more", JSImport.Default)
  object NavigationUnfoldMore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/navigation-arrow-drop-right", JSImport.Default)
  object NavigationArrowDropRight extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/adb", JSImport.Default)
  object NotificationAdb extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-flat-angled",
                       JSImport.Default)
  object NotificationAirlineSeatFlatAngled extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-flat", JSImport.Default)
  object NotificationAirlineSeatFlat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-individual-suite",
                       JSImport.Default)
  object NotificationAirlineSeatIndividualSuite extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-legroom-extra",
                       JSImport.Default)
  object NotificationAirlineSeatLegroomExtra extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-legroom-normal",
                       JSImport.Default)
  object NotificationAirlineSeatLegroomNormal extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-legroom-reduced",
                       JSImport.Default)
  object NotificationAirlineSeatLegroomReduced extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-recline-extra",
                       JSImport.Default)
  object NotificationAirlineSeatReclineExtra extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/airline-seat-recline-normal",
                       JSImport.Default)
  object NotificationAirlineSeatReclineNormal extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/bluetooth-audio", JSImport.Default)
  object NotificationBluetoothAudio extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/confirmation-number", JSImport.Default)
  object NotificationConfirmationNumber extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/disc-full", JSImport.Default)
  object NotificationDiscFull extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/do-not-disturb-alt", JSImport.Default)
  object NotificationDoNotDisturbAlt extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/do-not-disturb-off", JSImport.Default)
  object NotificationDoNotDisturbOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/do-not-disturb-on", JSImport.Default)
  object NotificationDoNotDisturbOn extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/do-not-disturb", JSImport.Default)
  object NotificationDoNotDisturb extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/drive-eta", JSImport.Default)
  object NotificationDriveEta extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/enhanced-encryption", JSImport.Default)
  object NotificationEnhancedEncryption extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/event-available", JSImport.Default)
  object NotificationEventAvailable extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/event-busy", JSImport.Default)
  object NotificationEventBusy extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/event-note", JSImport.Default)
  object NotificationEventNote extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/folder-special", JSImport.Default)
  object NotificationFolderSpecial extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/live-tv", JSImport.Default)
  object NotificationLiveTv extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/mms", JSImport.Default)
  object NotificationMms extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/more", JSImport.Default)
  object NotificationMore extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/network-check", JSImport.Default)
  object NotificationNetworkCheck extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/network-locked", JSImport.Default)
  object NotificationNetworkLocked extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/no-encryption", JSImport.Default)
  object NotificationNoEncryption extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/ondemand-video", JSImport.Default)
  object NotificationOndemandVideo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/personal-video", JSImport.Default)
  object NotificationPersonalVideo extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/phone-bluetooth-speaker",
                       JSImport.Default)
  object NotificationPhoneBluetoothSpeaker extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/phone-forwarded", JSImport.Default)
  object NotificationPhoneForwarded extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/phone-in-talk", JSImport.Default)
  object NotificationPhoneInTalk extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/phone-locked", JSImport.Default)
  object NotificationPhoneLocked extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/phone-missed", JSImport.Default)
  object NotificationPhoneMissed extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/phone-paused", JSImport.Default)
  object NotificationPhonePaused extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/power", JSImport.Default)
  object NotificationPower extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/priority-high", JSImport.Default)
  object NotificationPriorityHigh extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/rv-hookup", JSImport.Default)
  object NotificationRvHookup extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/sd-card", JSImport.Default)
  object NotificationSdCard extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/sim-card-alert", JSImport.Default)
  object NotificationSimCardAlert extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/sms-failed", JSImport.Default)
  object NotificationSmsFailed extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/sms", JSImport.Default)
  object NotificationSms extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/sync-disabled", JSImport.Default)
  object NotificationSyncDisabled extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/sync-problem", JSImport.Default)
  object NotificationSyncProblem extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/sync", JSImport.Default)
  object NotificationSync extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/system-update", JSImport.Default)
  object NotificationSystemUpdate extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/tap-and-play", JSImport.Default)
  object NotificationTapAndPlay extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/time-to-leave", JSImport.Default)
  object NotificationTimeToLeave extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/vibration", JSImport.Default)
  object NotificationVibration extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/voice-chat", JSImport.Default)
  object NotificationVoiceChat extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/vpn-lock", JSImport.Default)
  object NotificationVpnLock extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/wc", JSImport.Default)
  object NotificationWc extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/notification/wifi", JSImport.Default)
  object NotificationWifi extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/ac-unit", JSImport.Default)
  object PlacesAcUnit extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/airport-shuttle", JSImport.Default)
  object PlacesAirportShuttle extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/all-inclusive", JSImport.Default)
  object PlacesAllInclusive extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/beach-access", JSImport.Default)
  object PlacesBeachAccess extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/business-center", JSImport.Default)
  object PlacesBusinessCenter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/casino", JSImport.Default)
  object PlacesCasino extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/child-care", JSImport.Default)
  object PlacesChildCare extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/child-friendly", JSImport.Default)
  object PlacesChildFriendly extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/fitness-center", JSImport.Default)
  object PlacesFitnessCenter extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/free-breakfast", JSImport.Default)
  object PlacesFreeBreakfast extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/golf-course", JSImport.Default)
  object PlacesGolfCourse extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/hot-tub", JSImport.Default)
  object PlacesHotTub extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/kitchen", JSImport.Default)
  object PlacesKitchen extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/pool", JSImport.Default)
  object PlacesPool extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/room-service", JSImport.Default)
  object PlacesRoomService extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/rv-hookup", JSImport.Default)
  object PlacesRvHookup extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/smoke-free", JSImport.Default)
  object PlacesSmokeFree extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/smoking-rooms", JSImport.Default)
  object PlacesSmokingRooms extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/places/spa", JSImport.Default)
  object PlacesSpa extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/cake", JSImport.Default)
  object SocialCake extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/domain", JSImport.Default)
  object SocialDomain extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/group-add", JSImport.Default)
  object SocialGroupAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/group", JSImport.Default)
  object SocialGroup extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/location-city", JSImport.Default)
  object SocialLocationCity extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/mood-bad", JSImport.Default)
  object SocialMoodBad extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/mood", JSImport.Default)
  object SocialMood extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/notifications-active", JSImport.Default)
  object SocialNotificationsActive extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/notifications-none", JSImport.Default)
  object SocialNotificationsNone extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/notifications-off", JSImport.Default)
  object SocialNotificationsOff extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/notifications-paused", JSImport.Default)
  object SocialNotificationsPaused extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/notifications", JSImport.Default)
  object SocialNotifications extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/pages", JSImport.Default)
  object SocialPages extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/party-mode", JSImport.Default)
  object SocialPartyMode extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/people-outline", JSImport.Default)
  object SocialPeopleOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/people", JSImport.Default)
  object SocialPeople extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/person-add", JSImport.Default)
  object SocialPersonAdd extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/person-outline", JSImport.Default)
  object SocialPersonOutline extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/person", JSImport.Default)
  object SocialPerson extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/plus-one", JSImport.Default)
  object SocialPlusOne extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/poll", JSImport.Default)
  object SocialPoll extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/public", JSImport.Default)
  object SocialPublic extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/school", JSImport.Default)
  object SocialSchool extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/sentiment-dissatisfied", JSImport.Default)
  object SocialSentimentDissatisfied extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/sentiment-neutral", JSImport.Default)
  object SocialSentimentNeutral extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/sentiment-satisfied", JSImport.Default)
  object SocialSentimentSatisfied extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/sentiment-very-dissatisfied",
                       JSImport.Default)
  object SocialSentimentVeryDissatisfied extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/sentiment-very-satisfied", JSImport.Default)
  object SocialSentimentVerySatisfied extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/share", JSImport.Default)
  object SocialShare extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/social/whatshot", JSImport.Default)
  object SocialWhatshot extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/check-box-outline-blank", JSImport.Default)
  object ToggleCheckBoxOutlineBlank extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/check-box", JSImport.Default)
  object ToggleCheckBox extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/indeterminate-check-box", JSImport.Default)
  object ToggleIndeterminateCheckBox extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/radio-button-checked", JSImport.Default)
  object ToggleRadioButtonChecked extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/radio-button-unchecked", JSImport.Default)
  object ToggleRadioButtonUnchecked extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/star-border", JSImport.Default)
  object ToggleStarBorder extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/star-half", JSImport.Default)
  object ToggleStarHalf extends MuiSvgIcon
  @js.native @JSImport("material-ui/svg-icons/toggle/star", JSImport.Default)
  object ToggleStar extends MuiSvgIcon
}
