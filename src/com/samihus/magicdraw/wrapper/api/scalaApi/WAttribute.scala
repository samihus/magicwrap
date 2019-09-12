package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property
import com.samihus.magicdraw.wrapper.traits.{ATTRIBUTE, IWAttribute}

/**
  * Wrapper fo a Magicdraw UML Property Instance
  *
  * @param wrappedElement
  */
case class WAttribute(override val wrappedElement: Property) extends IWAttribute {
  override val is = ATTRIBUTE
}
