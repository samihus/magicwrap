package com.samihus.magicdraw.wrapper.api.javaapi.traits

import java.util.{Set => JSet}

import com.samihus.magicdraw.wrapper.api.javaapi.Converter._
import com.samihus.magicdraw.wrapper.api.javaapi.JAttribute
import com.samihus.magicdraw.wrapper.traits.HasProperties

trait JHasProperties[T <: HasProperties] {
  val w: T

  def getAllAttributes: JSet[JAttribute] = w.allAttributes

  def getAllAttributesFromAssociation: JSet[JAttribute] = w.allAttributesFromAssociations

  def getAllAttributesNotFromAssociation: JSet[JAttribute] = w.allAttributesNotFromAssociations

  def getOwnedAttributes: JSet[JAttribute] = w.ownedAttributes

  def getOwnedAttributesFromAssociation: JSet[JAttribute] = w.ownedAttributesFromAssociation

  def getOwnedAttributesNotFromAssociation: JSet[JAttribute] = w.ownedAttributesNotFromAssociation

  def getInheritedAttributes: JSet[JAttribute] = w.inheritedAttributes

  def getAttribute(attName: String): Option[JAttribute] = w.getAttribute(attName)

  def getRedefinedAttributes: JSet[JAttribute] = w.redefinedAttributes
}
