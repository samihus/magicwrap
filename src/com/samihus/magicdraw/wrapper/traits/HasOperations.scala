package com.samihus.magicdraw.wrapper.traits

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Classifier, Operation}
import com.samihus.magicdraw.wrapper.api.ScalaWrapper

import scala.collection.JavaConverters._

/**
  * Trait of elements that have operations
  *
  * @groupname oper
  *            Operations
  */
trait HasOperations extends Wrap[Classifier] {
  /**
    * @group oper
    * @return
    */
  def allOperations: Set[IWOperation] = {
    var set = new util.HashSet[Operation]
    ClassifierHelper.collectInheritedOperations(wrappedElement, set, true, true)
    set.asScala.toSet.map(ScalaWrapper.WOperationConstructor)
  }

  /**
    * @group oper
    * @return
    */
  def inheritedOperations: Set[IWOperation] = {
    var set = new util.HashSet[Operation]
    ClassifierHelper.collectInheritedOperations(wrappedElement, set, false, true)
    set.asScala.toSet.map(ScalaWrapper.WOperationConstructor)
  }

  /**
    * @group oper
    * @return
    */
  def ownedOperations: Set[IWOperation] = allOperations.diff(inheritedOperations)
}
