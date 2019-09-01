package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.jmi.helpers.CoreHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Class, Classifier, DataType, Enumeration, PrimitiveType, Property}
import com.samihus.magicdraw.wrapper.internal.traits.{WNamedElement, WType}
import com.samihus.magicdraw.wrapper._

import scala.collection.JavaConverters._

/**
  * Wrapper fo a Magicdraw UML Property Instance
  *
  * @param wrappedElement
  */
case class WAttribute(override val wrappedElement: Property) extends WNamedElement[Property] {

  /**
    * @group General-Information
    * @return multiplicity string of the attribute. Ex: {{"0..1"}}
    */
  def multiplicity: String = CoreHelper.getMultiplicity(wrappedElement)

  /**
    *
    * @return return the wrapped type instance of the attribute
    */
  def isOfType: Option[WType[Classifier]] = wrappedElement.getType match {
    case x: Class => Some(WClass(x))
    case y: Enumeration => Some(WEnumeration(y))
    case z: PrimitiveType => Some(WPrimitiveType(z))
    case w: DataType => Some(WDataType(w))
    case t: Interface => Some(WInterface(t))
    case _ => None
  }

  /**
    * Checks if attribute is originated by association end
    * @return true if the property come from an association
    */
  def isFromAssociation: Boolean = association.isDefined

  /**
    *
    * @return Some(Association) if isFromAssociation = true, None else
    *         TODO WRAP THE ASSOCIATION
    */
  def association: Option[Association] = Option(wrappedElement.getAssociation)

  /**
    *
    * @return return the redefined attribute if it is defined. None else
    */
  def redefinesAttribute : Option[WAttribute] = wrappedElement.getRedefinedProperty.isEmpty match {
    case true => None
    case false => Some(WAttribute(wrappedElement.getRedefinedProperty.asScala.head))
  }

  //todo : test
  /**
    *
    * @return return the redefined attribute set if it is defined. None else
    */
  def redefinesList: Set[WAttribute] = wrappedElement.getRedefinedProperty.asScala.toSet.map(WAttribute)

}
