package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement

trait IWJavaNamedElement[+T <: NamedElement]  {
  val wrappedElement: T
  val scalaEquivalent: IWNamedElement[T]
}
