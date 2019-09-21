package com.samihus.magicdraw.wrapper.api.javaapi

import java.util.{Set => JSet}

import com.samihus.magicdraw.wrapper.api.scalaapi.{WClass, WStereotype}
import com.samihus.magicdraw.wrapper.traits.IWAttribute

import scala.collection.JavaConverters._

/**
  * Conversion from Scala Wrappers to Java ones
  */
object Converter {

  implicit def fromWClass(w: WClass): JClass = new JClass(w.wrappedElement)

  implicit def fromSetWClass(swc: Set[WClass]): JSet[JClass] = swc.map(fromWClass).asJava

  implicit def fromWAttribute(p: IWAttribute): JAttribute = new JAttribute(p.wrappedElement)

  implicit def fromOptionWAttr(p: Option[IWAttribute]): Option[JAttribute] = p.map(fromWAttribute)

  implicit def fromWAttSet(x: Set[IWAttribute]): JSet[JAttribute] = x.map(fromWAttribute).asJava

  implicit def fromWStereotype(ws: WStereotype): JStereotype = new JStereotype(ws.wrappedElement)

  implicit def fromJStereotype(js: JStereotype): WStereotype = new WStereotype(js.s)

  implicit def fromSetWStereotype(sws: Set[WStereotype]) : JSet[JStereotype] = sws.map(fromWStereotype).asJava

}
