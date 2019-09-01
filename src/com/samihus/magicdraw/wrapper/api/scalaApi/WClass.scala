package com.samihus.magicdraw.wrapper.api.scalaApi

import java.util

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.{WNamedElement, WType}
import scala.collection.JavaConverters._
/**
  * Wrapper Class for an UML Class instance in Magicdraw
  *
  * @param wrappedElement The instance of UML Class to wrap
  */
case class WClass(override val wrappedElement: Class)
  extends WNamedElement[Class]
      with WType[Class]
      with com.samihus.magicdraw.wrapper.internal.traits.WClass[Class] {

    override def getDirectParents: List[WClass] = wrappedElement.getSuperClass.asScala.map(WClass).toList

    override def getAllParents: List[WClass] = {
      var tmp = new java.util.ArrayList[Class]
      val all: util.Collection[Class] = ClassifierHelper.collectGeneralClassifiersRecursively(wrappedElement, tmp)
      all.asScala.map(WClass)(collection.breakOut)
    }
}
