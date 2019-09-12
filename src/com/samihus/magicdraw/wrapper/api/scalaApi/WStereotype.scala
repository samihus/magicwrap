package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.WCaster
import com.samihus.magicdraw.wrapper.api.ClassifierHierarchy
import com.samihus.magicdraw.wrapper.traits.{HasAssociations, HasGeneralInfo, HasHierachy, HasProperties, IWType, STEREOTYPE, Stereotypable, Wrap, TypeOfWrappedElement}

case class WStereotype(override val wrappedElement: Stereotype)
  extends HasProperties
    with HasGeneralInfo
    with HasAssociations
    with Stereotypable
    with HasHierachy
    with IWType
    with Wrap[Stereotype] {
  override type ClassifierType = WStereotype

  override def directParents: Set[WStereotype] = ClassifierHierarchy[WStereotype](wrappedElement)(WCaster.toMayBeWStereotype).directParents

  override def allParents: Set[WStereotype] = ClassifierHierarchy[WStereotype](wrappedElement)(WCaster.toMayBeWStereotype).allParents

  override def directChildren: Set[WStereotype] = ClassifierHierarchy[WStereotype](wrappedElement)(WCaster.toMayBeWStereotype).directChildren

  override def allChildren: Set[WStereotype] = ClassifierHierarchy[WStereotype](wrappedElement)(WCaster.toMayBeWStereotype).allChildren

  override val is: TypeOfWrappedElement = STEREOTYPE
}
