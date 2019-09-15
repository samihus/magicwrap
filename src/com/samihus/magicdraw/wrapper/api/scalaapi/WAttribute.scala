package com.samihus.magicdraw.wrapper.api.scalaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property
import com.samihus.magicdraw.wrapper.{ATTRIBUTE, TypeOfWrappedElement}
import com.samihus.magicdraw.wrapper.traits.IWAttribute

/**
  * Wrapper fo a Magicdraw UML Property Instance
  *
  * @param wrappedElement wrapped MD property element
  */
case class WAttribute(override val wrappedElement: Property) extends IWAttribute {
  override val is:TypeOfWrappedElement = ATTRIBUTE
}
