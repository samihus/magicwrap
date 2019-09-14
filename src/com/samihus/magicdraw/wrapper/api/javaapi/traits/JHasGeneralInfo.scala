package com.samihus.magicdraw.wrapper.api.javaapi.traits

import com.nomagic.uml2.ext.jmi.helpers.CoreHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Element, NamedElement}

trait JHasGeneralInfo[+M <: NamedElement] {

  val ne : M
   /**
    *  @group General-Information
    * @return unique identifier of the wrapped UML Element
    */
  def uid: String = ne.getID

  /**
    * @group General-Information
    * @return
    */
  def documentation: String = CoreHelper.getComment(ne)

  /**
    * @group General-Information
    * @return
    */
  def name:String = ne.getName

  /**
    *
    * @group General-Information
    * @return
    */
  def owner: Element = ne.getOwner
  //TODO wrap

}
