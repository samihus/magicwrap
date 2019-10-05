package com.samihus.magicdraw.wrapper.api.javaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Association
import com.samihus.magicdraw.wrapper.api.javaapi.traits.{JHasGeneralInfo, JStereotypable}
import com.samihus.magicdraw.wrapper.api.scalaapi.WAssociation

class JAssociation(association: Association) extends JStereotypable[WAssociation] with JHasGeneralInfo[Association] {
  override val scalaWrapped: WAssociation = WAssociation(association)
  override val ne: Association = association

  //TODO
}
