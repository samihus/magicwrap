package com.samihus.magicdraw.wrapper.api.javaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property
import com.samihus.magicdraw.wrapper.internal.traits.{IWJavaNamedElement, IWNamedElement}
import com.samihus.magicdraw.wrapper.api.{scalaApi => sc}

case class WAttribute(override val wrappedElement: Property ) extends IWJavaNamedElement[Property]{
  override val scalaEquivalent: IWNamedElement[Property] = sc.WAttribute(wrappedElement)
}
