import java.awt.event.ActionEvent

import com.samihus.magicdraw.wrapper.WCaster
import com.samihus.magicdraw.wrapper.api.scalaapi.{WClass, WDefaultBrowserAction}

class example() extends WDefaultBrowserAction(actionName= "Name of the action") {
  override def actionPerformed(actionEvent: ActionEvent): Unit = {
    val mayBeWClass: Option[WClass] = getSelectedObjectAsBaseElement.flatMap(WCaster.toMayBeWClass)
  }
}