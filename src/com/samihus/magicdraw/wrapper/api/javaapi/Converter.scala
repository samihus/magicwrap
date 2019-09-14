package com.samihus.magicdraw.wrapper.api.javaapi

import java.util

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property
import com.samihus.magicdraw.wrapper.api.scalaapi.{WAttribute, WClass}
import com.samihus.magicdraw.wrapper.traits.IWAttribute

import scala.collection.JavaConverters._

object Converter {

  implicit def fromWClass(w: WClass): JClass = new JClass(w.wrappedElement)

  implicit def fromSetWClass(swc: Set[WClass]): util.Set[JClass] = swc.map(fromWClass).asJava

  implicit def fromWAttribute(p : IWAttribute): JAttribute = new JAttribute(p.wrappedElement)

  implicit def fromOptionWAttr(p:Option[IWAttribute]): Option[JAttribute] = p.map(fromWAttribute)

  implicit def fromWAttSet(x: Set[IWAttribute]): util.Set[JAttribute] = x.map(fromWAttribute).asJava

}
