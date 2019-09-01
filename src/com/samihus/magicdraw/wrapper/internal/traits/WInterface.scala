package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface

import scala.collection.JavaConverters._

trait WInterface extends WClassifier[Interface] {
  override def operations: Set[WOperation] = wrappedElement.getOwnedOperation.asScala.map(WOperationConst).toSet

  def getDirectParents: List[WInterface] = wrappedElement.getGeneral.asScala.toList
    .filter(c => c.isInstanceOf[Interface]).map(x => WInterfaceConst(x.asInstanceOf[Interface]))

  def getAllParents: List[WInterface] = ???
}
