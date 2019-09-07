package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWAttribute, IWType}

/**
  * Wrapper fo a Magicdraw UML Property Instance
  *
  * @param wrappedElement
  */
case class WAttribute(override val wrappedElement: Property) extends IWAttribute with ScalaWrapper {
  def hasType: IWType = WType(wrappedElement.getType)
}
