package com.samihus.magicdraw.wrapper.api.scalaApi

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWOperation, IWInterface => WI}

import scala.collection.JavaConverters._

case class WInterface(override val wrappedElement: Interface) extends WI with ScalaWrapper {

  override def ownedOperations: Set[IWOperation] =  wrappedElement.getOwnedOperation.asScala.map(WOperation).toSet

  override def allOperations: Set[IWOperation] = {
    val res: util.ArrayList[Operation] = new util.ArrayList()
    ClassifierHelper.collectInheritedOperations(wrappedElement,res,true,true)
    res.asScala.toSet.map(WOperation)
  }

  override def inheritedOperations: Set[IWOperation] = {
    val res: util.ArrayList[Operation] = new util.ArrayList()
    ClassifierHelper.collectInheritedOperations(wrappedElement,res,false,true)
    res.asScala.toSet.map(WOperation)
  }
}
