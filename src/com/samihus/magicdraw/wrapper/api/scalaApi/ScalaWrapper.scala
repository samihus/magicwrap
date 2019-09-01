package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, DataType, Enumeration, EnumerationLiteral, Operation, PrimitiveType, Property}
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.ScalaWrapperTrait

trait ScalaWrapper extends ScalaWrapperTrait{
  val WAttributeConst: Property => traits.WAttribute = WAttribute
  val WClassConst: Class => traits.WClass[Class] = WClass
  val WEnumConst: Enumeration => traits.WEnumeration = WEnumeration
  val WPrimitiveTypeConst: PrimitiveType => traits.WPrimitiveType = WPrimitiveType
  val WDataTypeConst: DataType => traits.WDataType[DataType] = WDataType
  val WInterfaceConst: Interface => traits.WInterface = WInterface
  val WOperationConst: Operation => traits.WOperation = WOperation
  val WEnumerationLiteralConst: EnumerationLiteral  => traits.WEnumerationLiteral = WEnumerationLiteral
}
