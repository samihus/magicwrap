package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.jmi.helpers.CoreHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Element, NamedElement}

trait HasGeneralInfo extends Wrap[NamedElement]{
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
    * @TODO wrap
    * @group General-Information
    * @return
    */
  def owner: Element = wrappedElement.getOwner

}
