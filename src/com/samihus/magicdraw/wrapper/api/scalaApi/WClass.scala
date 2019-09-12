package com.samihus.magicdraw.wrapper.api.scalaApi

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.samihus.magicdraw.wrapper.WCaster
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

  //override def ownedOperations: Set[IWOperation] = wrappedElement.getOwnedOperation.asScala.map(WOperation).toSet

  //override def directParents: Set[WClass] = wrappedElement.getSuperClass.asScala.map(WClass).toSet
/*
  override def allParents: Set[WClass] = {
    var tmp = new java.util.ArrayList[Class]
    val all: util.Collection[Class] = ClassifierHelper.collectGeneralClassifiersRecursively(wrappedElement, tmp)
    all.asScala.map(WClass)(collection.breakOut)
  }

  override def directChildren: Set[WClass] = {
    ClassifierHelper.getDerivedClassifiers(wrappedElement).asScala.toSet.flatMap(WCaster.toMayBeWClass)
  }

  override def allChildren: Set[WClass] = {
    ClassifierHelper.getDerivedClassifiersRecursively(wrappedElement).asScala.toSet.flatMap(WCaster.toMayBeWClass)
  }

  override def directParents: Set[WClass] = {
    ClassifierHelper.getGeneralClassifiers(wrappedElement).asScala.toSet.flatMap(WCaster.toMayBeWClass)
  }

 */
  override def directParents: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).directParents

  override def allParents: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).allParents

  override def directChildren: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).directChildren

  override def allChildren: Set[WClass] = ClassifierHierarchy[WClass](wrappedElement)(WCaster.toMayBeWClass).allChildren

  override val is: TypeOfWrappedElement = CLASS
}
