package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{DataType, Enumeration}
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WNamedElement, WType}
import com.samihus.magicdraw.wrapper.internal.traits
import scala.collection.JavaConverters._
case class WEnumeration(wrappedElement: Enumeration) extends WNamedElement[DataType]
  with WType[Enumeration]
  with WClassifier[DataType]
  with com.samihus.magicdraw.wrapper.internal.traits.WDataType {

  /**
    * @group Sub-SuperTypes
    * @return List of direct parents
    */
  override def getDirectParents: List[WEnumeration] = ???

  /**
    * @group Sub-SuperTypes
    * @return List of all parents hierarchy
    */
  override def getAllParents: List[WEnumeration] = ???

  def getEnumerationLiterals: Set[WEnumerationLiteral] = wrappedElement.getOwnedLiteral.asScala.toSet.map(WEnumerationLiteral)
}
