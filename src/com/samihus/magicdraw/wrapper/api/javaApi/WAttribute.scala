package com.samihus.magicdraw.wrapper.api.javaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property
import com.samihus.magicdraw.wrapper.internal.traits.{WJavaNamedElement, WNamedElement}
import com.samihus.magicdraw.wrapper.api.{scalaApi => sc}

case class WAttribute(override val wrappedElement: Property ) extends WJavaNamedElement[Property]{
  override val scalaEquivalent: WNamedElement[Property] = sc.WAttribute(wrappedElement)
}
