package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.samihus.magicdraw.wrapper.internal.traits.{WInterface => WI}

import scala.collection.JavaConverters._

case class WInterface(override val wrappedElement: Interface) extends WI with ScalaWrapper {


}
