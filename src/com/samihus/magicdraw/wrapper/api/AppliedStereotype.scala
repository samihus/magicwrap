package com.samihus.magicdraw.wrapper.api

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper.{getStereotypePropertyValue => getValue}
import com.samihus.magicdraw.wrapper.api.scalaapi.WStereotype
import com.samihus.magicdraw.wrapper.traits.Stereotypable

import scala.collection.JavaConverters._
import scala.reflect.ClassTag

case class AppliedStereotype(element: Stereotypable, stereotype: WStereotype) {

  def hasTag(tagName: String): Boolean = stereotype.allAttributes.exists(_.name == tagName)

  def getTagValueAsString(propertyName: String): Option[String] = getTagSingleValue[String](propertyName)

  def getTagValueAsBoolean(propertyName: String): Option[Boolean] = getTagSingleValue[Boolean](propertyName)

  /**
    * Get Tagged value as single element
    *
    * @param propertyName tag name
    * @tparam T type of the propertyName
    * @return element of the type T
    */
  def getTagSingleValue[T](propertyName: String)(implicit tag: ClassTag[T]): Option[T] = {
    if (isDefined && !getValue(element.wrappedElement, stereotype.wrappedElement, propertyName).isEmpty) {
      getValue(element.wrappedElement, stereotype.wrappedElement, propertyName).asScala.head match {
        case tValue: T => Some(tValue)
        case _ => None
      }
    }
    else None
  }

  /**
    * Check if the stereotype is applied to the element
    *
    * @return true if applied
    */
  def isDefined: Boolean = element.hasStereotype(stereotype)

  /**
    * Get the value of the tag propertyName of the element. To use if we know that the value is of multiplicity 0..*
    *
    * @param propertyName the tagged value property name
    * @return List containing the values
    */
  def getTageValuesList(propertyName: String): List[Any] = {
    getValue(element.wrappedElement, stereotype.wrappedElement, propertyName).asScala.toList
  }

}
