package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWOperation => WO}

case class WOperation(override val wrappedElement: Operation) extends WO with ScalaWrapper
