package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Enumeration
import com.samihus.magicdraw.wrapper.WCaster
import com.samihus.magicdraw.wrapper.api.ClassifierHierarchy
import com.samihus.magicdraw.wrapper.traits.{ENUMERATION, HasHierachy, IDataType, IWType, Stereotypable, Wrap, TypeOfWrappedElement}

case class WEnumeration(override val wrappedElement: Enumeration)
  extends  IDataType
    with Wrap[Enumeration] {
  override type ClassifierType = WEnumeration

  override def directParents: Set[WEnumeration] = ClassifierHierarchy[WEnumeration](wrappedElement)(WCaster.toMayBeWEnumeration).directParents

  override def allParents: Set[WEnumeration] = ClassifierHierarchy[WEnumeration](wrappedElement)(WCaster.toMayBeWEnumeration).allParents

  override def directChildren: Set[WEnumeration] = ClassifierHierarchy[WEnumeration](wrappedElement)(WCaster.toMayBeWEnumeration).directChildren

  override def allChildren: Set[WEnumeration] = ClassifierHierarchy[WEnumeration](wrappedElement)(WCaster.toMayBeWEnumeration).allChildren

  override val is: TypeOfWrappedElement = ENUMERATION
}
