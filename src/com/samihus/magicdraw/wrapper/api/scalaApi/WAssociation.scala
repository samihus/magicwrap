package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Association
import com.samihus.magicdraw.wrapper.internal.traits.{WNamedElement, WType}

case class WAssociation(override val wrappedElement: Association) extends WNamedElement[Association] with WType[Association] {

}
