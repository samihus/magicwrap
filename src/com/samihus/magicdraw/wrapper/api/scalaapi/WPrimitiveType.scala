package com.samihus.magicdraw.wrapper.api.scalaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.PrimitiveType
import com.samihus.magicdraw.wrapper.api.ClassifierHierarchy
import com.samihus.magicdraw.wrapper.traits.{IDataType, Wrap}
import com.samihus.magicdraw.wrapper.{PRIMITIVETYPE, TypeOfWrappedElement, WCaster}

case class WPrimitiveType(override val wrappedElement: PrimitiveType)
  extends IDataType with Wrap[PrimitiveType]{
  override type ClassifierType = WPrimitiveType

  override def directParents: Set[WPrimitiveType] = ClassifierHierarchy[WPrimitiveType](wrappedElement)(WCaster.toMayBeWPrimitiveType).directParents

  override def allParents: Set[WPrimitiveType] = ClassifierHierarchy[WPrimitiveType](wrappedElement)(WCaster.toMayBeWPrimitiveType).allParents

  override def directChildren: Set[WPrimitiveType] = ClassifierHierarchy[WPrimitiveType](wrappedElement)(WCaster.toMayBeWPrimitiveType).directChildren

  override def allChildren: Set[WPrimitiveType] = ClassifierHierarchy[WPrimitiveType](wrappedElement)(WCaster.toMayBeWPrimitiveType).allChildren

  override val is: TypeOfWrappedElement = PRIMITIVETYPE
}
