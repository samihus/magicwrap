package com.samihus.magicdraw.wrapper

import com.nomagic.magicdraw.uml.BaseElement
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Class, DataType, EnumerationLiteral, NamedElement, Operation, Package, PrimitiveType, Property, Enumeration => Enu}
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.api.scalaapi._
import com.samihus.magicdraw.wrapper.traits.{HasGeneralInfo, Stereotypable}

import scala.reflect.ClassTag

/**
  * Encapsulates a base object in order to safe extract from it a named element (if relevant)
  *  {{{
  *     WCaster[Class, WClass](WClass)(element)
  *   }}}
  *
  * @param f
  * @param baseElement Element from a Magicdraw's model
  * @tparam T Supposed type of element
  * @tparam W Type of the wrapper
  */
case class WCaster[T <: NamedElement, W]( f: T => W)(baseElement: BaseElement) {
  def safeWrap(implicit tag: ClassTag[T]): Option[W] = safeCast.map(f)

  /**
    * Try to cast
    *
    * @return
    */
  def safeCast(implicit tag: ClassTag[T]): Option[T] = baseElement match {
    case t: T => Some(t)
    case _ => None
  }

}

object WCaster {
  type AsClass              = WCaster[Class, WClass]
  type AsAttribute          = WCaster[Property, WAttribute]
  type AsAssociation        = WCaster[Association, WAssociation]
  type AsDataType           = WCaster[DataType, WDataType]
  type AsEnumeration        = WCaster[Enu, WEnumeration]
  type AsEnumerationLiteral = WCaster[EnumerationLiteral, WEnumerationLiteral]
  type AsInterface          = WCaster[Interface, WInterface]
  type AsPackage            = WCaster[Package, WPackage]
  type AsPrimitiveType      = WCaster[PrimitiveType, WPrimitiveType]
  type AsStereotype         = WCaster[Stereotype, WStereotype]
  type AsOperation          = WCaster[Operation, WOperation]

  def toMayBeWClass(x: BaseElement): Option[WClass] =
    new AsClass(WClass)(x).safeWrap

  def toMayBeWAttribute(x: BaseElement): Option[WAttribute] =
    new AsAttribute(WAttribute)(x).safeWrap

  def toMayBeWAssociation(x: BaseElement): Option[WAssociation] =
    new AsAssociation(WAssociation)(x).safeWrap

  def toMayBeWDataType(x: BaseElement): Option[WDataType] =
    new AsDataType(WDataType)(x).safeWrap

  def toMayBeWEnumeration(x: BaseElement): Option[WEnumeration] =
    new AsEnumeration (WEnumeration)(x).safeWrap

  def toMayBeWEnumerationLiteral(x: BaseElement): Option[WEnumerationLiteral] =
    new AsEnumerationLiteral(WEnumerationLiteral)(x).safeWrap

  def toMayBeWInterface(x: BaseElement): Option[WInterface] =
    new AsInterface(WInterface)(x).safeWrap

  def toMayBeWPackage(x: BaseElement): Option[WPackage] =
    new AsPackage(WPackage)(x).safeWrap

  def toMayBeWPrimitiveType(x: BaseElement): Option[WPrimitiveType] =
    new AsPrimitiveType(WPrimitiveType)(x).safeWrap

  def toMayBeWStereotype(x: BaseElement): Option[WStereotype] =
    new AsStereotype(WStereotype)(x).safeWrap

  def toMayBeWOperation(x: BaseElement): Option[WOperation] =
    new AsOperation(WOperation)(x).safeWrap

  implicit def convert(baseElem: BaseElement): Option[HasGeneralInfo with Stereotypable] = baseElem match {
    case s: Stereotype          => Some(WStereotype(s))
    case c: Class               => Some(WClass(c))
    case p: Property            => Some(WAttribute(p))
    case a: Association         => Some(WAssociation(a))
    case l: EnumerationLiteral  => Some(WEnumerationLiteral(l))
    case r: Enu                 => Some(WEnumeration(r))
    case i: Interface           => Some(WInterface(i))
    case k: Package             => Some(WPackage(k))
    case v: PrimitiveType       => Some(WPrimitiveType(v))
    case o: Operation           => Some(WOperation(o))
    case d: DataType            => Some(WDataType(d))
    case _                      => None
  }


}