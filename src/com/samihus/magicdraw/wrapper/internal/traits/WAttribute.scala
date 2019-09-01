package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.jmi.helpers.CoreHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Class, Classifier, DataType, Enumeration, PrimitiveType, Property}

import scala.collection.JavaConverters._

trait WAttribute extends WNamedElement[Property] {

  /**
    * @group General-Information
    * @return multiplicity string of the attribute. Ex: {{"0..1"}}
    */
  def multiplicity: String = CoreHelper.getMultiplicity(wrappedElement)


  /**
    *
    * @return return the wrapped type instance of the attribute
    */
  def classifierType: Option[WClassifier[Classifier]] = wrappedElement.getType match {
    case x: Class => Some(WClassConst(x))
    case y: Enumeration => Some(WEnumConst(y))
    case z: PrimitiveType => Some(WPrimitiveTypeConst(z))
    case w: DataType => Some(WDataTypeConst(w))
    case t: Interface => Some(WInterfaceConst(t))
    case _ => None
  }

  /**
    * Checks if attribute is originated by association end
    *
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
  def redefinesAttribute: Option[WAttribute] = wrappedElement.getRedefinedProperty.isEmpty match {
    case true => None
    case false => Some(WAttributeConst(wrappedElement.getRedefinedProperty.asScala.head))
  }

  //todo : test
  /**
    *
    * @return return the redefined attribute set if it is defined. None else
    */
  def redefinesList: Set[WAttribute] = wrappedElement.getRedefinedProperty.asScala.toSet.map(WAttributeConst)

}
