package com.samihus.magicdraw.wrapper.api.javaapi.traits

import com.samihus.magicdraw.wrapper.api.AppliedStereotype
import com.samihus.magicdraw.wrapper.api.javaapi.Converter._
import com.samihus.magicdraw.wrapper.api.javaapi.JStereotype
import com.samihus.magicdraw.wrapper.traits.Stereotypable

trait JStereotypable[T <: Stereotypable] {

  val scalaWrapped: T

  def hasStereotype(stereotypeName: String): Boolean = scalaWrapped.hasStereotype(stereotypeName)

  def hasStereotype(stereotype: JStereotype): Boolean = scalaWrapped.hasStereotype(stereotype) //implicit here

  def getAppliedStereotype(stereotype: JStereotype): AppliedStereotype = scalaWrapped.getAppliedStereotype(stereotype) //implicit here

}
