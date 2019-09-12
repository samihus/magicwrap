package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type
import com.samihus.magicdraw.wrapper.WCaster

case class WType(wrappedElement: Type) {
  def asClass: Option[WClass] = WCaster.toMayBeWClass(wrappedElement)

  def asAssociation: Option[WAssociation] = WCaster.toMayBeWAssociation(wrappedElement)

  def asInterface: Option[WInterface] = WCaster.toMayBeWInterface(wrappedElement)

  def asStereotype: Option[WStereotype] = WCaster.toMayBeWStereotype(wrappedElement)

  def asDataType: Option[WDataType] = WCaster.toMayBeWDataType(wrappedElement)

  def asEnumeration: Option[WEnumeration] = WCaster.toMayBeWEnumeration(wrappedElement)

  def asPrimitiveType: Option[WPrimitiveType] = WCaster.toMayBeWPrimitiveType(wrappedElement)
}
