package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.jmi.helpers.CoreHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Class, DataType, Enumeration, PrimitiveType, Property}
import com.samihus.magicdraw.wrapper.api.ScalaWrapper._

import scala.collection.JavaConverters._

/**
  * @groupname General-Information
  *            General Information
  */
trait IWAttribute extends HasGeneralInfo with Stereotypable with Wrap[Property] {

  /**
    * @group General-Information
    * @return multiplicity string of the attribute. Ex: {{"0..1"}}
    */
  def multiplicity: String = CoreHelper.getMultiplicity(wrappedElement)


  /**
    * @group General-Information
    * @return return the wrapped type instance of the attribute
    */
  def classifierType: Option[IWType] = wrappedElement.getType match {
    case x: Class => Some(WClassConstructor(x))
    case y: Enumeration => Some(WEnumerationConstructor(y))
    case z: PrimitiveType => Some(WPrimitiveTypeConstructor(z))
    case w: DataType => Some(WDataTypeConstructor(w))
    case t: Interface => Some(WInterfaceConstructor(t))
    case _ => None
  }


  /**
    * Checks if attribute is originated by association end
    *
    * @group General-Information
    * @return true if the property come from an association
    */
  def isFromAssociation: Boolean = association.isDefined

  /**
    * General - Information
    *
    * @return Some(Association) if isFromAssociation = true, None else
    *         TODO WRAP THE ASSOCIATION
    */
  def association: Option[Association] = Option(wrappedElement.getAssociation)

  /**
    * @group General-Information
    * @return return the redefined attribute if it is defined. None else
    */
  def redefinesAttribute: Option[IWAttribute] = wrappedElement.getRedefinedProperty.isEmpty match {
    case true => None
    case false => Some(WAttributeConstructor(wrappedElement.getRedefinedProperty.asScala.head))
  }

  //todo : test
  /**
    * @group General-Information
    * @return return the redefined attribute set if it is defined. None else
    */
  def redefinesList: Set[IWAttribute] = wrappedElement.getRedefinedProperty.asScala.toSet.map(WAttributeConstructor)


}
