package com.samihus.magicdraw.wrapper.internal.utils

import com.nomagic.magicdraw.uml.BaseElement
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Class, DataType, Enumeration, EnumerationLiteral, NamedElement, Operation, Package, PrimitiveType, Property}
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.api.scalaApi.{WAssociation, WAttribute, WClass, WDataType, WEnumeration, WEnumerationLiteral, WInterface, WOperation, WPackage, WPrimitiveType, WStereotype}

import scala.util.{Failure, Success, Try}

/**
  * Encapsulates a base object in order to safe extract from it a named element (if relevant)
  * {{
  *
  * }}
  *
  * @param baseElement : Element from a Magicdraw's model
  * @tparam T : Supposed type of element
  */
case class WCaster[T <: NamedElement, W](f: T => W)(baseElement: BaseElement) {
  def safeWrap: Option[W] = safeCast match {
    case Some(value) => Some(f(value))
    case None => None
  }

  /**
    * Try to cast
    *
    * @return
    */
  def safeCast: Option[T] = baseElement match {
    case t: T => Some(t)
    case _ => None
  }

}

object WCaster {
  type AsClass = WCaster[Class, WClass]
  type AsAttribute = WCaster[Property, WAttribute]
  type AsAssociation = WCaster[Association, WAssociation]
  type AsDataType = WCaster[DataType, WDataType]
  type AsEnumeration = WCaster[Enumeration, WEnumeration]
  type AsEnumerationLiteral = WCaster[EnumerationLiteral, WEnumerationLiteral]
  type AsInterface = WCaster[Interface, WInterface]
  type AsPackage = WCaster[Package, WPackage]
  type AsPrimitiveType = WCaster[PrimitiveType, WPrimitiveType]
  type AsStereotype = WCaster[Stereotype, WStereotype]
  type AsOperation = WCaster[Operation, WOperation]

  def toMayBeWClass(x: BaseElement): Option[WClass] = new AsClass(WClass)(x).safeWrap

  def toMayBeWAttribute(x: BaseElement): Option[WAttribute] = new AsAttribute(WAttribute)(x).safeWrap

  def toMayBeWAssociation(x: BaseElement): Option[WAssociation] = new AsAssociation(WAssociation)(x).safeWrap

  def toMayBeWDataType(x: BaseElement): Option[WDataType] = new AsDataType(WDataType)(x).safeWrap

  def toMayBeWEnumeration(x: BaseElement): Option[WEnumeration] = new AsEnumeration(WEnumeration)(x).safeWrap

  def toMayBeWEnumerationLiteral(x: BaseElement): Option[WEnumerationLiteral] = new AsEnumerationLiteral(WEnumerationLiteral)(x).safeWrap

  def toMayBeWInterface(x: BaseElement): Option[WInterface] = new AsInterface(WInterface)(x).safeWrap

  def toMayBeWPackage(x: BaseElement): Option[WPackage] = new AsPackage(WPackage)(x).safeWrap

  def toMayBeWPrimitiveType(x: BaseElement): Option[WPrimitiveType] = new AsPrimitiveType(WPrimitiveType)(x).safeWrap

  def toMayBeWStereotype(x: BaseElement): Option[WStereotype] = new AsStereotype(WStereotype)(x).safeWrap

  def toMayBeWOperation(x: BaseElement): Option[WOperation] = new AsOperation(WOperation)(x).safeWrap
}