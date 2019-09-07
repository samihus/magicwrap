package com.samihus.magicdraw.wrapper.api.scalaApi

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, Operation}
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWOperation, IWClass => WC}

import scala.collection.JavaConverters._

/**
  * Wrapper Class for an UML Class instance in Magicdraw
  *
  * @param wrappedElement The instance of UML Class to wrap
  */
case class WClass(override val wrappedElement: Class) extends WC with ScalaWrapper {

  override def ownedOperations: Set[IWOperation] = wrappedElement.getOwnedOperation.asScala.map(WOperation).toSet

  override def allOperations: Set[IWOperation] = {
    val res: util.ArrayList[Operation] = new util.ArrayList()
    ClassifierHelper.collectInheritedOperations(wrappedElement, res, true, true)
    res.asScala.toSet.map(WOperation)
  }

  override def inheritedOperations: Set[IWOperation] = {
    val res: util.ArrayList[Operation] = new util.ArrayList()
    ClassifierHelper.collectInheritedOperations(wrappedElement, res, false, true)
    res.asScala.toSet.map(WOperation)
  }

  override def getDirectParents: List[WClass] = wrappedElement.getSuperClass.asScala.map(WClass).toList

  override def getAllParents: List[WClass] = {
    var tmp = new java.util.ArrayList[Class]
    val all: util.Collection[Class] = ClassifierHelper.collectGeneralClassifiersRecursively(wrappedElement, tmp)
    all.asScala.map(WClass)(collection.breakOut)
  }
}
