package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{DataType, Property}
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WNamedElement, WType}

case class WDataType (override val wrappedElement: DataType)
  extends com.samihus.magicdraw.wrapper.internal.traits.WDataType[DataType] with ScalaWrapper {
}
