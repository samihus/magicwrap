package com.samihus.magicdraw.wrapper.api.javaapi.traits

import com.samihus.magicdraw.wrapper.api.AppliedStereotype
import com.samihus.magicdraw.wrapper.api.javaapi.Converter._
import com.samihus.magicdraw.wrapper.api.javaapi.JStereotype
import com.samihus.magicdraw.wrapper.traits.Stereotypable

import java.util.{Set => JSet}

trait JStereotypable[T <: Stereotypable] {

  val scalaWrapped: T

  def hasStereotype(stereotypeName: String): Boolean = scalaWrapped.hasStereotype(stereotypeName)

  def hasStereotype(stereotype: JStereotype): Boolean = scalaWrapped.hasStereotype(stereotype) //implicit here

  def getAllAppliedStereotypes: JSet[JStereotype] = scalaWrapped.allAppliedStereotypes //implicit here

  def getAppliedStereotype(stereotype: JStereotype): AppliedStereotype = scalaWrapped.getAppliedStereotype(stereotype) //implicit here

  def getAppliedStereotype(stereotypeName: String): AppliedStereotype = scalaWrapped.getAppliedStereotype(stereotypeName)
}
