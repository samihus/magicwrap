package com.samihus.magicdraw.wrapper.api.javaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property
import com.samihus.magicdraw.wrapper.api.javaapi.traits.{JHasGeneralInfo, JStereotypable}
import com.samihus.magicdraw.wrapper.api.scalaapi.WAttribute

class JAttribute(p: Property)
  extends JStereotypable[WAttribute] with JHasGeneralInfo[Property] {

  override val scalaWrapped: WAttribute = WAttribute(p)
  override val ne: Property = p
}
