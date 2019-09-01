package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral
import com.samihus.magicdraw.wrapper.internal.traits.{WEnumerationLiteral => WE}

case class WEnumerationLiteral(override val wrappedElement: EnumerationLiteral) extends WE with ScalaWrapper {

}
