package com.samihus.magicdraw.wrapper.internal.utils

import java.util

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{NamedElement, Property}
import com.samihus.magicdraw.wrapper.api.scalaApi.{WAttribute => WScalaAttribute}
import com.samihus.magicdraw.wrapper.api.javaApi.{WAttribute => WJavaAttribute}
import com.samihus.magicdraw.wrapper.internal.traits.{JavaApi, ScalaApi, WJavaNamedElement, WNamedElement => WScalaNamedElement}

import scala.collection.JavaConverters._

object JavaConverter {

  def mapThenToJavaSet[T<: ScalaApi, V <: JavaApi](f: T => V)(coll: Set[T]): util.Set[V] = setAsJavaSet(coll.map(f))

  //def scalaWrapToJavaWrap[T<:NamedElement](f: T => WJavaNamedElement[T])(x: WScalaNamedElement[T]): WJavaNamedElement[T] = f(x.wrappedElement)

  //def WAttributeScala2Java(x: WScalaAttribute): WJavaAttribute = scalaWrapToJavaWrap[Property](WJavaAttribute)(x)
}

