package com.samihus.magicdraw.wrapper.api.javaapi


import java.util.{Set => JSet}

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.samihus.magicdraw.wrapper.api.javaapi.Converter._
import com.samihus.magicdraw.wrapper.api.javaapi.traits.{JHasGeneralInfo, JHasProperties}
import com.samihus.magicdraw.wrapper.api.scalaapi.WClass

class JClass(c: Class) extends JHasProperties[WClass] with JHasGeneralInfo[Class] {
  override val w = WClass(c)
  override val ne: Class = c
  def getAllChildren: JSet[JClass] = w.allChildren

  def getDirectChildren: JSet[JClass] = w.directChildren

  def getAllParents: JSet[JClass] = w.allParents

  def getDirectParents: JSet[JClass] = w.directParents


}
