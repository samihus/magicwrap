package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.DataType
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WNamedElement, WType}

case class WDataType (wrappedElement: DataType)
  extends WNamedElement[DataType]
    with WType[DataType]
    with WClassifier[DataType]
    with com.samihus.magicdraw.wrapper.internal.traits.WDataType  {
  /**
    * @group Sub-SuperTypes
    * @return List of direct parents
    */
  def getDirectParents: List[WDataType] = ???

  /**
    * @group Sub-SuperTypes
    * @return List of all parents hierarchy
    */
  override def getAllParents: List[WDataType] = ???
}
