package com.samihus.magicdraw.wrapper.api.scalaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral
import com.samihus.magicdraw.wrapper.{ENUMLITERAL, TypeOfWrappedElement}
import com.samihus.magicdraw.wrapper.traits.{HasGeneralInfo, Stereotypable, Wrap}

case class WEnumerationLiteral(override val wrappedElement: EnumerationLiteral)
  extends HasGeneralInfo
    with Stereotypable
    with Wrap[EnumerationLiteral] {
  override val is: TypeOfWrappedElement = ENUMLITERAL
}
