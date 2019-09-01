package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Association, Property}
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WAssociation => WA}

case class WAssociation(override val wrappedElement: Association) extends WA[Association] with ScalaWrapper {

}
