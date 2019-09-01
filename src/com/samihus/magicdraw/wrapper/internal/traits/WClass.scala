package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.samihus.magicdraw.wrapper.api.scalaApi.WOperation

import scala.collection.JavaConverters._

trait WClass[+T <:Class] extends WClassifier[T] {
  val wrappedElement: T

  override def operations: Set[WOperation] = wrappedElement.getOwnedOperation.asScala.map(WOperation).toSet
  override def getAllParents: List[WClass[T]]
  override def getDirectParents: List[WClass[T]]
}
