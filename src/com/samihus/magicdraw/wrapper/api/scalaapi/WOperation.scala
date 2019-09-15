package com.samihus.magicdraw.wrapper.api.scalaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation
import com.samihus.magicdraw.wrapper.traits.IWOperation
import com.samihus.magicdraw.wrapper.{OPERATION, TypeOfWrappedElement}

case class WOperation(override val wrappedElement: Operation) extends IWOperation {
  override val is: TypeOfWrappedElement = OPERATION
}
