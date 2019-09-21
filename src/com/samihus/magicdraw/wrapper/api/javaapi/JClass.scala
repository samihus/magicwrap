package com.samihus.magicdraw.wrapper.api.javaapi


import java.util.{Set => JSet}

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.samihus.magicdraw.wrapper.api.javaapi.Converter._
import com.samihus.magicdraw.wrapper.api.javaapi.traits.{JHasGeneralInfo, JHasProperties, JStereotypable}
import com.samihus.magicdraw.wrapper.api.scalaapi.WClass

class JClass(c: Class) extends JHasProperties[WClass] with JStereotypable[WClass] with JHasGeneralInfo[Class] {
  override val scalaWrapped = WClass(c)

  override val ne: Class = c

  /**
    * get all specializing JClass
    * @return
    */
  def getAllChildren: JSet[JClass] = scalaWrapped.allChildren

  /**
    * get all direct specializing JClass
    * @return
    */
  def getDirectChildren: JSet[JClass] = scalaWrapped.directChildren


  /**
    * get all hierarchy
    * @return
    */
  def getAllParents: JSet[JClass] = scalaWrapped.allParents

  /**
    * get direct parents the class inherits from
    * @return
    */
  def getDirectParents: JSet[JClass] = scalaWrapped.directParents


}
