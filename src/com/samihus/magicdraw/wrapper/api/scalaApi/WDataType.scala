package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.DataType
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits

case class WDataType (override val wrappedElement: DataType)
  extends traits.IWDataType with traits.IWClassifier[DataType] with ScalaWrapper {
}
