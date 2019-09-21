package com.samihus.magicdraw.wrapper.api.javaapi.traits

import java.util.{Set => JSet}

import com.samihus.magicdraw.wrapper.api.javaapi.Converter._
import com.samihus.magicdraw.wrapper.api.javaapi.JAttribute
import com.samihus.magicdraw.wrapper.traits.HasProperties

trait JHasProperties[T <: HasProperties] {

  val scalaWrapped: T

  def getAllAttributes: JSet[JAttribute] = scalaWrapped.allAttributes

  def getAllAttributesFromAssociation: JSet[JAttribute] = scalaWrapped.allAttributesFromAssociations

  def getAllAttributesNotFromAssociation: JSet[JAttribute] = scalaWrapped.allAttributesNotFromAssociations

  def getOwnedAttributes: JSet[JAttribute] = scalaWrapped.ownedAttributes

  def getOwnedAttributesFromAssociation: JSet[JAttribute] = scalaWrapped.ownedAttributesFromAssociation

  def getOwnedAttributesNotFromAssociation: JSet[JAttribute] = scalaWrapped.ownedAttributesNotFromAssociation

  def getInheritedAttributes: JSet[JAttribute] = scalaWrapped.inheritedAttributes

  def getAttribute(attName: String): Option[JAttribute] = scalaWrapped.getAttribute(attName)

  def getRedefinedAttributes: JSet[JAttribute] = scalaWrapped.redefinedAttributes
}
