package com.samihus.magicdraw.wrapper.api.javaapi

import java.util.Optional

import com.nomagic.magicdraw.uml.BaseElement
import com.samihus.magicdraw.wrapper.WCaster
import Converter._

import compat.java8.OptionConverters._

object JCaster {
  def toMayBeJClass(x: BaseElement): Optional[JClass] = WCaster.toMayBeWClass(x).map(fromWClass).asJava
  def toMayBeJAttribute(x: BaseElement): Optional[JAttribute] =WCaster.toMayBeWAttribute(x).map(fromWAttribute).asJava
  }
