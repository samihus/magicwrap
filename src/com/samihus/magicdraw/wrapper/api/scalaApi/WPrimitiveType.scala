package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{PrimitiveType, Property}
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WPrimitiveType => PT}

case class WPrimitiveType(override val wrappedElement: PrimitiveType)  extends PT with ScalaWrapper {
}
