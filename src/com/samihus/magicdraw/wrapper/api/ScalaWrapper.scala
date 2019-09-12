package com.samihus.magicdraw.wrapper.api

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Class, DataType, Enumeration, EnumerationLiteral, Operation, PrimitiveType, Property}
import com.samihus.magicdraw.wrapper.api.scalaApi._
import com.samihus.magicdraw.wrapper.traits.{IWAssociation, IWAttribute, IWOperation}


object ScalaWrapper {
  val WAssociationConstructor: Association => IWAssociation = WAssociation
  val WAttributeConstructor: Property => IWAttribute = WAttribute
  val WClassConstructor: Class => WClass = WClass
  val WEnumerationConstructor: Enumeration => WEnumeration = WEnumeration
  val WPrimitiveTypeConstructor: PrimitiveType => WPrimitiveType = WPrimitiveType
  val WDataTypeConstructor: DataType => WDataType = WDataType
  val WInterfaceConstructor: Interface => WInterface = WInterface
  val WOperationConstructor: Operation => IWOperation = WOperation
  val WEnumerationLiteralConstructor: EnumerationLiteral => WEnumerationLiteral = WEnumerationLiteral

}
