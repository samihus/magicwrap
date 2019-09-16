package com.samihus.magicdraw.wrapper.api

import java.util

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper.{getStereotypePropertyValue => getValue}
import com.samihus.magicdraw.wrapper.api.scalaapi.WStereotype
import com.samihus.magicdraw.wrapper.traits.Stereotypable
import collection.JavaConverters._
case class AppliedStereotype(element: Stereotypable, stereotype: WStereotype) {

  /**
    * Check if the stereotype is applied to the element
    *
    * @return true if applied
    */
  def isDefined: Boolean = element.hasStereotype(stereotype)


  def hasTag(tagName: String): Boolean = stereotype.allAttributes.exists(_.name == tagName)

  /**
    * Get Tagged value as single element
    * @param propertyName tag name
    * @tparam T type of the propertyName
    * @return element of the type T
    */
  def getPropertySingleValue[T](propertyName:String):Option[T] = {
    if(isDefined && !getValue(element.wrappedElement,stereotype.wrappedElement,propertyName).isEmpty) {
      getValue(element.wrappedElement,stereotype.wrappedElement,propertyName).asScala.head match {
        case tValue: T => Some(tValue)
        case _ => None
      }
    }
    else None
  }

  def getPropertyValueAsString(propertyName:String): Option[String] = getPropertySingleValue[String](propertyName)

  def getPropertyValueAsBoolean(propertyName:String): Option[Boolean] = getPropertySingleValue[Boolean](propertyName)

  /**
    * Get the value of the tag propertyName of the element. To use if we know that the value is of multiplicity 0..*
    * @param propertyName the tagged value property name
    * @return List containing the values
    */
  def getPropertyListValues(propertyName:String): List[Any] = {
    getValue(element.wrappedElement,stereotype.wrappedElement,propertyName).asScala.toList
  }

}
