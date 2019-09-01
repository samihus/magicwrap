package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Enumeration
import com.samihus.magicdraw.wrapper.internal.traits.{WEnumeration => E}

case class WEnumeration(override val wrappedElement: Enumeration) extends E with ScalaWrapper {

}
