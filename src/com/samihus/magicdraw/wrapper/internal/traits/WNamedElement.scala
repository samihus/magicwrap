package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.jmi.helpers.{CoreHelper, StereotypesHelper}
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Element, NamedElement}
import com.samihus.magicdraw.wrapper.api.scalaApi.WStereotype
import com.samihus.magicdraw.wrapper.internal.utils.WStereotypedElement

/**
  *
  * Generic Wrapper of Named Elements
  * @groupname Stereotype
  *            Stereotype related methods
  * @groupname General-Information
  *            General Information about the wrapped elements
  *
  */
trait WNamedElement [+T <: NamedElement] extends ScalaApi {
  /**
    * The wrapped Element by the wrapper
    * @group General-Information
    */
  val wrappedElement: T

  /**
    *  @group General-Information
    * @return unique identifier of the wrapped UML Element
    */
  def uid: String = wrappedElement.getID

  /**
    * @group General-Information
    * @return
    */
  def documentation: String = CoreHelper.getComment(wrappedElement)

  /**
    * @group General-Information
    * @return
    */
  def name:String = wrappedElement.getName

  /**
    * @group General-Information
    * @return
    */
  def owner: Element = wrappedElement.getOwner

  /**
    * Checks if a stereotype is applied
    *
    * @group Stereotype
    * @param stereotype Wrapped Stereotype to check
    * @return true if the stereotype is applied to the wrapped element
    */
  def hasStereotype(stereotype: WStereotype): Boolean = StereotypesHelper.hasStereotype(wrappedElement,stereotype.wrappedElement)

  /**
    * @group Stereotype
    * @param stereotypeName Name of the stereotype
    * @return true if the stereotype is applied to the wrapped element
    */
  def hasStereotype(stereotypeName: String): Boolean = StereotypesHelper.hasStereotype(wrappedElement,stereotypeName)

  def as(stereotype: WStereotype) = ???

  def ownedElementWithStereotype(stereotype: WStereotype) = Option(WStereotypedElement(this, stereotype))

}
