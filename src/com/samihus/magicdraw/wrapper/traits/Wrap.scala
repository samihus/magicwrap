package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement

trait Wrap[+T <: NamedElement] {
  val wrappedElement: T
  val is : TypeOfWrappedElement
}



sealed trait TypeOfWrappedElement

object ATTRIBUTE      extends TypeOfWrappedElement
object ASSOCIATION    extends TypeOfWrappedElement
object CLASS          extends TypeOfWrappedElement
object DATATYPE       extends TypeOfWrappedElement
object ENUMERATION    extends TypeOfWrappedElement
object ENUMLITERAL    extends TypeOfWrappedElement
object INTERFACE      extends TypeOfWrappedElement
object OPERATION      extends TypeOfWrappedElement
object PACKAGE        extends TypeOfWrappedElement
object STEREOTYPE     extends TypeOfWrappedElement
object PRIMITIVETYPE  extends TypeOfWrappedElement
