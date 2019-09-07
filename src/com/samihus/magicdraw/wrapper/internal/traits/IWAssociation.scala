package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Type}

import scala.collection.JavaConverters._

trait IWAssociation[A <: Association] extends IWClassifier[A] with IWType {
  def endTypes: Set[IWType]
//todo
}
