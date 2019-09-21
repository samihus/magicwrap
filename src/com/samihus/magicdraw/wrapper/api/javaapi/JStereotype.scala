package com.samihus.magicdraw.wrapper.api.javaapi

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.api.javaapi.traits.{JHasGeneralInfo, JHasProperties, JStereotypable}
import com.samihus.magicdraw.wrapper.api.scalaapi.WStereotype

case class JStereotype(s: Stereotype)
  extends JHasProperties[WStereotype] with JStereotypable[WStereotype] with JHasGeneralInfo[Stereotype] {

  override val scalaWrapped: WStereotype = WStereotype(s)
  override val ne: Stereotype = s

}
