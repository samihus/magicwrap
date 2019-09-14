package com.samihus.magicdraw.wrapper.api

import java.util

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper.{getStereotypePropertyValue => tagValues}
import com.samihus.magicdraw.wrapper.api.scalaApi.WStereotype
import com.samihus.magicdraw.wrapper.traits.Stereotypable

case class AppliedStereotype(element: Stereotypable, stereotype: WStereotype) {

  def getTagValueByName(tagName: String): Option[util.List[_]] = {
    if (isDefined && hasTag(tagName)) Some(tagValues(element.wrappedElement, stereotype.wrappedElement, tagName)) else None
  }

  /**
    * Check if the stereotype is applied to the element
    *
    * @return true if applied
    */
  def isDefined: Boolean = element.hasStereotype(stereotype)

  def hasTag(tagName: String): Boolean = stereotype.allAttributes.exists(_.name == tagName)

}
