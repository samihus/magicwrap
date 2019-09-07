package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Association
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWAssociation => WA}

case class WAssociation(override val wrappedElement: Association) extends WA[Association] with ScalaWrapper {
  override def endTypes: Nothing = ???
}
