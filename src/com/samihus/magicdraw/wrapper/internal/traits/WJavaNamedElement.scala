package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement

trait WJavaNamedElement[+T <: NamedElement] extends JavaApi {
  val wrappedElement: T
  val scalaEquivalent: WNamedElement[T]
}
