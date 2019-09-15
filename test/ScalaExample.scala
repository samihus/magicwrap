import java.awt.event.ActionEvent

import com.samihus.magicdraw.wrapper.WCaster
import com.samihus.magicdraw.wrapper.api.scalaapi.{WClass, WDefaultBrowserAction}

class ScalaExample() extends WDefaultBrowserAction(actionName= "Name of the action") {
  override def actionPerformed(actionEvent: ActionEvent): Unit = {
    val mayBeWClass: Option[WClass] = getSelectedObjectAsMayBeWClass
  }
}