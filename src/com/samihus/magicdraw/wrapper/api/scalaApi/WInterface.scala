package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WNamedElement, WType}
import scala.collection.JavaConverters._

case class WInterface(override val wrappedElement: Interface)
  extends WNamedElement[Interface]
    with WType[Interface]
    with WClassifier[Interface] {

   override def operations: Set[WOperation] = wrappedElement.getOwnedOperation.asScala.map(WOperation).toSet

  override def getDirectParents: List[WInterface] = wrappedElement.getGeneral.asScala.toList
    .filter(c => c.isInstanceOf[Interface]).map(x => WInterface(x.asInstanceOf[Interface]))

  override def getAllParents: List[WInterface] = ???

}
