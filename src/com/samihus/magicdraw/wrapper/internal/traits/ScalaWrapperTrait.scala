package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, DataType, Enumeration, EnumerationLiteral, Operation, PrimitiveType, Property}


trait ScalaWrapperTrait {
  val WAttributeConstructor: Property => IWAttribute
  val WClassConstructor: Class => IWClass
  val WEnumerationConstructor: Enumeration => IWEnumeration
  val WPrimitiveTypeConstructor: PrimitiveType => IWPrimitiveType
  val WDataTypeConstructor: DataType => IWDataType
  val WInterfaceConstructor: Interface => IWInterface
  val WOperationConstructor: Operation => IWOperation
  val WEnumerationLiteralConstructor: EnumerationLiteral => IWEnumerationLiteral
}
