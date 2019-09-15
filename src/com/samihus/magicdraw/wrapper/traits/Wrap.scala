package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement
import com.samihus.magicdraw.wrapper.TypeOfWrappedElement

trait Wrap[+T <: NamedElement] {
  val wrappedElement: T
  val is : TypeOfWrappedElement
}


