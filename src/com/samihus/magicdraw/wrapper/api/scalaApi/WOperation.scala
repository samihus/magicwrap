package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.traits.{IWOperation, OPERATION, TypeOfWrappedElement}

case class WOperation(override val wrappedElement: Operation) extends IWOperation {
  override val is: TypeOfWrappedElement = OPERATION
}
