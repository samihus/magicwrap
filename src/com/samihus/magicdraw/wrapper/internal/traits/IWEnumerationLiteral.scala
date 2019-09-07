package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral
import com.samihus.magicdraw.wrapper.api.scalaApi

trait IWEnumerationLiteral extends IWNamedElement[EnumerationLiteral] {
  def enumeration: IWEnumeration = scalaApi.WEnumeration(wrappedElement.getEnumeration)
}
