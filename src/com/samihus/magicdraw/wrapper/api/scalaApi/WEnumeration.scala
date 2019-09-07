package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Enumeration
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWEnumeration => E}

case class WEnumeration(override val wrappedElement: Enumeration) extends E with ScalaWrapper {

}
