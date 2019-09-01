package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Enumeration, EnumerationLiteral}

import scala.collection.JavaConverters._

trait WEnumeration extends WDataType[Enumeration] {
  def getEnumerationLiterals: Set[WEnumerationLiteral] = wrappedElement.getOwnedLiteral.asScala.toSet.map(WEnumerationLiteralConst)
}
