package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWEnumerationLiteral => WE}

case class WEnumerationLiteral(override val wrappedElement: EnumerationLiteral) extends WE with ScalaWrapper {

}
