package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.samihus.magicdraw.wrapper.WCaster
import com.samihus.magicdraw.wrapper.api.ClassifierHierarchy
import com.samihus.magicdraw.wrapper.traits._

case class WInterface(override val wrappedElement: Interface)
  extends IWType
    with HasAssociations
    with HasGeneralInfo
    with HasHierachy
    with HasOperations
    with HasProperties
    with Stereotypable
    with Wrap[Interface] {
  override type ClassifierType = WInterface

  override def directParents: Set[WInterface] = ClassifierHierarchy[WInterface](wrappedElement)(WCaster.toMayBeWInterface).directParents

  override def allParents: Set[WInterface] = ClassifierHierarchy[WInterface](wrappedElement)(WCaster.toMayBeWInterface).allParents

  override def directChildren: Set[WInterface] = ClassifierHierarchy[WInterface](wrappedElement)(WCaster.toMayBeWInterface).directChildren

  override def allChildren: Set[WInterface] = ClassifierHierarchy[WInterface](wrappedElement)(WCaster.toMayBeWInterface).allChildren

  override val is: TypeOfWrappedElement = INTERFACE
}
