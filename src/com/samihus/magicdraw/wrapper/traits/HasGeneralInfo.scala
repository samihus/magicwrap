package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.jmi.helpers.CoreHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Element, NamedElement, Class => MDClass, Enumeration => MDEnum, Package => MDPackage}
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.api.scalaapi.{WClass, WEnumeration, WInterface, WPackage, WStereotype}

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
    *
    * @group General-Information
    * @return
    */
  def owner: Either[HasGeneralInfo with Stereotypable, Element] = wrappedElement.getOwner match {
    case s: Stereotype    => Left(WStereotype(s))
    case e:  MDEnum       => Left(WEnumeration(e))
    case c:  MDClass      => Left(WClass(c))
    case i:  Interface    => Left(WInterface(i))
    case p:  MDPackage    => Left(WPackage(p))
    case el: Element      => Right(el)
  }

}
