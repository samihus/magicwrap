package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral
import com.samihus.magicdraw.wrapper.api.scalaApi

trait WEnumerationLiteral extends WNamedElement[EnumerationLiteral] {
  def enumeration: WEnumeration = scalaApi.WEnumeration(wrappedElement.getEnumeration)
}
