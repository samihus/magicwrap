package com.samihus.magicdraw.wrapper.api.scalaapi

import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction
import com.nomagic.magicdraw.uml.BaseElement
import com.samihus.magicdraw.wrapper.WCaster
import javax.swing.KeyStroke

/**
  * Wrapper for the default browser action
  */
class WDefaultBrowserAction(actionID: String = "", actionName: String, stroke: KeyStroke = null, group: String = null)
  extends DefaultBrowserAction(actionID, actionName, stroke, group) {
  def getSelectedObjectAsBaseElement: Option[BaseElement] = Option(getSelectedObject.asInstanceOf[BaseElement])
  def getSelectedObjectAsMayBeWClass: Option[WClass] = getSelectedObjectAsBaseElement.flatMap(WCaster.toMayBeWClass)
  def getSelectedObjectAsMayBeWPackage: Option[WPackage] = getSelectedObjectAsBaseElement.flatMap(WCaster.toMayBeWPackage)
}
