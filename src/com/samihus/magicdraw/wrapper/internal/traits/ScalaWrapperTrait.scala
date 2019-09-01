package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, DataType, Enumeration, EnumerationLiteral, Operation, PrimitiveType, Property}


trait ScalaWrapperTrait {
  val WAttributeConst: Property => WAttribute
  val WClassConst: Class => WClass[Class]
  val WEnumConst: Enumeration => WEnumeration
  val WPrimitiveTypeConst: PrimitiveType => WPrimitiveType
  val WDataTypeConst: DataType => WDataType[DataType]
  val WInterfaceConst: Interface => WInterface
  val WOperationConst: Operation => WOperation
  val WEnumerationLiteralConst: EnumerationLiteral => WEnumerationLiteral

}
