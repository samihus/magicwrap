package com.samihus.magicdraw.wrapper.api.scalaapi

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.samihus.magicdraw.wrapper.{CLASS, TypeOfWrappedElement, WCaster}
import com.samihus.magicdraw.wrapper.api.ClassifierHierarchy
import com.samihus.magicdraw.wrapper.traits._

import scala.collection.JavaConverters._

/**
  * Wrapper Class for an UML Class instance in Magicdraw
  *
  * @param wrappedElement The instance of UML Class to wrap
  */
case class WClass(override val wrappedElement: Class)
  extends HasAssociations
    with HasHierachy
    with HasProperties
    with HasOperations
    with HasGeneralInfo
    with Stereotypable
    with IWType {
  override type ClassifierType = WClass

  override def directParents: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).directParents

  override def allParents: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).allParents

  override def directChildren: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).directChildren

  override def allChildren: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).allChildren

  override val is: TypeOfWrappedElement = CLASS
}
