package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral
import com.samihus.magicdraw.wrapper.api.scalaApi
import com.samihus.magicdraw.wrapper.internal.traits.WNamedElement

case class WEnumerationLiteral(override val wrappedElement: EnumerationLiteral) extends WNamedElement[EnumerationLiteral]{
  def enumeration: WEnumeration = scalaApi.WEnumeration(wrappedElement.getEnumeration)
}
