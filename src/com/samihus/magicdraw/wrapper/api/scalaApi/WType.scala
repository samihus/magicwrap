package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWType => WT}
import com.samihus.magicdraw.wrapper.internal.utils.WCaster

case class WType( wrappedElement: Type) extends WT with ScalaWrapper {
  def asClass: Option[WClass] = WCaster.toMayBeWClass(wrappedElement)
  def asAssociation: Option[WAssociation] = WCaster.toMayBeWAssociation(wrappedElement)
  def asInterface: Option[WInterface] = WCaster.toMayBeWInterface(wrappedElement)
  def asStereotype: Option[WStereotype] = WCaster.toMayBeWStereotype(wrappedElement)
  def asDataType: Option[WDataType] = WCaster.toMayBeWDataType(wrappedElement)
  def asEnumeration: Option[WEnumeration] = WCaster.toMayBeWEnumeration(wrappedElement)
  def asPrimitiveType: Option[WPrimitiveType] =  WCaster.toMayBeWPrimitiveType(wrappedElement)
}
