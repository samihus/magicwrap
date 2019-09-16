package com.samihus.magicdraw.wrapper.api.javaapi


import java.util.{Set => JSet}

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.samihus.magicdraw.wrapper.api.javaapi.Converter._
import com.samihus.magicdraw.wrapper.api.javaapi.traits.{JHasGeneralInfo, JHasProperties}
import com.samihus.magicdraw.wrapper.api.scalaapi.WClass

class JClass(c: Class) extends JHasProperties[WClass] with JHasGeneralInfo[Class] {
  override val w = WClass(c)

  override val ne: Class = c

  /**
    * get all specializing JClass
    * @return
    */
  def getAllChildren: JSet[JClass] = w.allChildren

  /**
    * get all direct specializing JClass
    * @return
    */
  def getDirectChildren: JSet[JClass] = w.directChildren


  /**
    * get all hierarchy
    * @return
    */
  def getAllParents: JSet[JClass] = w.allParents

  /**
    * get direct parents the class inherits from
    * @return
    */
  def getDirectParents: JSet[JClass] = w.directParents


}
