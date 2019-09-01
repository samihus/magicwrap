package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.PrimitiveType
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.WType

case class WPrimitiveType(wrappedElement: PrimitiveType)
  extends com.samihus.magicdraw.wrapper.internal.traits.WDataType
    with WType[PrimitiveType] {

}
