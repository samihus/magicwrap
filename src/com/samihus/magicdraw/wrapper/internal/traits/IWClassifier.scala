package com.samihus.magicdraw.wrapper.internal.traits

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Classifier, Property}

import scala.collection.JavaConverters._
/**
  * Generic Wrapper for classifier
  *
  * @tparam C  UML Element which is a subtype of Classifier
  */
trait IWClassifier[+C <: Classifier] extends IWNamedElement[C] {
  /**
    * @groupname Attributes Attributes of the classifier
    * @groupname Operations Operations of the classifier
    * @groupname Sub-SuperTypes Super and sub types
    */

  /**
    * Wrapped Magicdraw element
    */
  val wrappedElement: C

  val isAbstract: Boolean = wrappedElement.isAbstract

  /**
    * @group Attributes
    * @return Returns all self owned attributes (excludes inherited ones)
    */
  def attributes(): Set[IWAttribute] = wrappedElement.getAttribute.asScala.map(WAttributeConstructor).toSet

  /**
    * @group Attributes
    * @return returns all self owned attributes coming from association role (excludes inherited ones)
    */
  def attributesFromAssociations: Set[IWAttribute] = attributes.filter(_.isFromAssociation)

  /**
    * @group Attributes
    * @return all self owned attributes not coming from association role (exclude inherited ones)
    */
  def ownedAttributes: Set[IWAttribute] = attributes.filterNot(_.isFromAssociation)

  /**
    * @group Attributes
    * @return  all attributes, including inherited
    */
  def allAttributes: Set[IWAttribute] = {
    /*
    wrappedElement.getMember.asScala
      .filter(_.isInstanceOf[Property])
      .map(a => WAttribute(a.asInstanceOf[Property])).toSet

     */
    var tmp = new util.LinkedList[Property]()
    ClassifierHelper.collectInheritedAttributes(wrappedElement, tmp, true,true)
    tmp.asScala.toSet.map(WAttributeConstructor)(collection.breakOut)
  }

  /**
    * @group Attributes
    * @return all attributes coming from associations
    */
  def allAttributesFromAssociations: Set[IWAttribute] = allAttributes.filter(_.isFromAssociation)

  /**
    * @group Attributes
    * @return all attributes, exluding association roles
    */
  def allAttributesNotFromAssociations: Set[IWAttribute] = allAttributes.filterNot(_.isFromAssociation)

  /**
    * @group Attributes
    * @param name name of the attribute
    * @return returns true if the classifier has attribute, looks in all attributes
    */

  def hasAttribute(name:String): Boolean= allAttributes.map(p => p.name).contains(name)

  /**
    * Given a name, finds an attribute in the classifier among all attributes (owned and inherited)
    * @group Attributes
    * @param name name of the attribute
    * @return Some(WAttribute) if attribute is found, None if not
    */

  def getAttribute(name:String): Option[IWAttribute] = if (hasAttribute(name)) {
    Some(allAttributes.filter(a => a.name.equals(name)).head)
  } else {
    None
  }

  /**
    *
    * @group Attributes
    * @return List of the  redefined attributes
    */
  def ownedRedefinedAttributes: Set[IWAttribute] = allAttributes.filter(_.redefinesAttribute.isDefined)


}
