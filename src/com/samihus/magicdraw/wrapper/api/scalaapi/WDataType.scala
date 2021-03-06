package com.samihus.magicdraw.wrapper.api.scalaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.DataType
import com.samihus.magicdraw.wrapper.{DATATYPE, TypeOfWrappedElement, WCaster}
import com.samihus.magicdraw.wrapper.api.ClassifierHierarchy
import com.samihus.magicdraw.wrapper.traits.{HasAssociations, HasGeneralInfo, HasHierachy, HasOwnedElements, HasProperties, IWType, Stereotypable, Wrap}

case class WDataType(override val wrappedElement: DataType)
  extends HasHierachy
    with HasAssociations
    with HasProperties
    with HasGeneralInfo
    with IWType
    with Stereotypable
  with HasOwnedElements
    with Wrap[DataType] {
  override type ClassifierType = WDataType

  override def directParents: Set[WDataType] = ClassifierHierarchy[WDataType](wrappedElement)(WCaster.toMayBeWDataType).directParents

  override def allParents: Set[WDataType] = ClassifierHierarchy[WDataType](wrappedElement)(WCaster.toMayBeWDataType).allParents

  override def directChildren: Set[WDataType] = ClassifierHierarchy[WDataType](wrappedElement)(WCaster.toMayBeWDataType).directChildren

  override def allChildren: Set[WDataType] = ClassifierHierarchy[WDataType](wrappedElement)(WCaster.toMayBeWDataType).allChildren

  override val is: TypeOfWrappedElement = DATATYPE
}