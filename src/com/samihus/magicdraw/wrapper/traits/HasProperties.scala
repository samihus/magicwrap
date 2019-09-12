package com.samihus.magicdraw.wrapper.traits

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Classifier, Element, Property}
import com.samihus.magicdraw.wrapper.api.ScalaWrapper.WAttributeConstructor

import scala.collection.JavaConverters._

/**
  * Trait for elements that has attributes
  *
  * @groupname prop
  *            Attributes operations
  */
trait HasProperties extends Wrap[Classifier] {
  /**
    * @group prop
    */
  def allAttributesFromAssociations: Set[IWAttribute] = allAttributes.filter(_.isFromAssociation)

  /**
    * @group prop
    */
  def allAttributesNotFromAssociations: Set[IWAttribute] = allAttributes.filterNot(_.isFromAssociation)

  /**
    * @group prop
    */
  def ownedAttributesFromAssociation: Set[IWAttribute] = ownedAttributes.filter(_.isFromAssociation)

  /**
    * @group prop
    */
  def ownedAttributesNotFromAssociation: Set[IWAttribute] = ownedAttributes.filterNot(_.isFromAssociation)

  /**
    * @group prop
    */
  def ownedAttributes: Set[IWAttribute] = {
    wrappedElement.getOwnedElement.asScala
      .filter(_.isInstanceOf[Property])
      .map(_.asInstanceOf[Property])
      .map(WAttributeConstructor).toSet
  }

  /**
    * @group prop
    */
  def inheritedAttributes: Set[IWAttribute] = {
    var set = new util.HashSet[Property]
    ClassifierHelper.collectInheritedAttributes(wrappedElement, set, false, true)
    set.asScala.map(WAttributeConstructor).toSet
  }

  /**
    * @group prop
    */
  def redefinedAttributes: Set[IWAttribute] = allAttributes.filter(_.redefinesAttribute.isDefined)

  /**
    * @group prop
    */
  def hasAttribute(propertyName: String): Boolean = allAttributes.exists(_.name == propertyName)

  /**
    * @group prop
    */
  def getAttribute(propertyName: String): Option[IWAttribute] = allAttributes.find(_.name == propertyName)

  /**
    * @group prop
    */
  def allAttributes: Set[IWAttribute] = {
    var set = new util.HashSet[Property]
    ClassifierHelper.collectInheritedAttributes(wrappedElement, set, true, true)
    set.asScala.map(WAttributeConstructor).toSet
  }
}
