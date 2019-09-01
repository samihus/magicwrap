package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, Operation}

import scala.collection.JavaConverters._

trait WClass[+T <: Class] extends WClassifier[T] {

  override def operations: Set[WOperation] = wrappedElement.getOwnedOperation.asScala.map(WOperationConst).toSet

  /**
    * @group Sub-SuperTypes
    * @return List of direct parents
    */
  def getDirectParents: List[WClass[T]]

  /**
    * @group Sub-SuperTypes
    * @return List of all parents hierarchy
    */
  def getAllParents: List[WClass[T]]

}
