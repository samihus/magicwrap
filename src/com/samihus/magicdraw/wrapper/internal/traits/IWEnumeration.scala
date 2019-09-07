package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Enumeration, EnumerationLiteral}

import scala.collection.JavaConverters._

trait IWEnumeration extends IWDataType with IWClassifier[Enumeration] {
  override val wrappedElement: Enumeration
  def getEnumerationLiterals: Set[IWEnumerationLiteral] = wrappedElement.getOwnedLiteral.asScala.toSet.map(WEnumerationLiteralConstructor)
}
