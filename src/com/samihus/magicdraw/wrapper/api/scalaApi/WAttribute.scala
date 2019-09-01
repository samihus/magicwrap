package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, DataType, Enumeration, PrimitiveType, Property}
import com.samihus.magicdraw.wrapper.internal.traits

/**
  * Wrapper fo a Magicdraw UML Property Instance
  *
  * @param wrappedElement
  */
case class WAttribute(override val wrappedElement: Property) extends traits.WAttribute with ScalaWrapper {

}
