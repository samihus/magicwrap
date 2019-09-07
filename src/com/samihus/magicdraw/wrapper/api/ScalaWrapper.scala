package com.samihus.magicdraw.wrapper.api

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, DataType, Enumeration, EnumerationLiteral, Operation, PrimitiveType, Property}
import com.samihus.magicdraw.wrapper.api.scalaApi._
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.ScalaWrapperTrait

trait ScalaWrapper extends ScalaWrapperTrait {

  val WAttributeConstructor: Property => traits.IWAttribute = WAttribute
  val WClassConstructor: Class => traits.IWClass = WClass
  val WEnumerationConstructor: Enumeration => traits.IWEnumeration = WEnumeration
  val WPrimitiveTypeConstructor: PrimitiveType => traits.IWPrimitiveType = WPrimitiveType
  val WDataTypeConstructor: DataType => traits.IWDataType = WDataType
  val WInterfaceConstructor: Interface => traits.IWInterface = WInterface
  val WOperationConstructor: Operation => traits.IWOperation = WOperation
  val WEnumerationLiteralConstructor: EnumerationLiteral => traits.IWEnumerationLiteral = WEnumerationLiteral
}

object ScalaWrapper {
  implicit val WAttributeConstructor: Property => traits.IWAttribute = WAttribute
  implicit val WClassConstructor: Class => traits.IWClass = WClass
  implicit val WEnumerationConstructor: Enumeration => traits.IWEnumeration = WEnumeration
  implicit val WPrimitiveTypeConstructor: PrimitiveType => traits.IWPrimitiveType = WPrimitiveType
  implicit val WDataTypeConstructor: DataType => traits.IWDataType = WDataType
  implicit val WInterfaceConstructor: Interface => traits.IWInterface = WInterface
  implicit val WOperationConstructor: Operation => traits.IWOperation = WOperation
  implicit val WEnumerationLiteralConstructor: EnumerationLiteral => traits.IWEnumerationLiteral = WEnumerationLiteral

}
