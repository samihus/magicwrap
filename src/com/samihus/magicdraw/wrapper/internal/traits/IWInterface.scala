package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface

import scala.collection.JavaConverters._

trait IWInterface extends IWClassifier[Interface] with IWType {

  def allOperations: Set[IWOperation]

  def ownedOperations: Set[IWOperation]

  def inheritedOperations: Set[IWOperation]

  def getDirectParents: List[IWInterface] = wrappedElement.getGeneral.asScala.toList
    .filter(c => c.isInstanceOf[Interface]).map(x => WInterfaceConstructor(x.asInstanceOf[Interface]))

  def getAllParents: List[IWInterface] = ???
}
