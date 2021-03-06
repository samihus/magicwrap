package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper.{hasStereotype => has}
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement
import com.samihus.magicdraw.wrapper.api.AppliedStereotype
import com.samihus.magicdraw.wrapper.api.scalaapi.WStereotype

import collection.JavaConverters._

/**
  * @groupname stereo
  *            Stereotype operations
  */
trait Stereotypable extends Wrap[NamedElement] {
  /**
    * check if stereotype is applied
    *
    * @group stereo
    * @param stereotype wrapped stereotype to check
    * @return true if stereotype is applied to element
    */
  def hasStereotype(stereotype: WStereotype): Boolean = has(wrappedElement, stereotype.name)

  /** check if stereotype is applied
    *
    * @group stereo
    * @param stereotypeName wrapped stereotype name to check
    * @return true if stereotype is applied to element
    */
  def hasStereotype(stereotypeName: String): Boolean = has(wrappedElement, stereotypeName)

  /**
    * Get Instance of applied stereotype
    *
    * @group stereo
    * @return
    */
  def getAppliedStereotype(stereotype: WStereotype): AppliedStereotype = AppliedStereotype(this, stereotype)

  /**
    * Get Instance of applied stereotype
    *
    * @group stereo
    * @return
    */
  def getAppliedStereotype(stereotypeName: String): AppliedStereotype = AppliedStereotype(this, allAppliedStereotypes.filter(_.name == stereotypeName).head)

  /**
    * Return list of all stereotypes applied to element
    * @return
    */
  def allAppliedStereotypes : Set[WStereotype] = StereotypesHelper.getStereotypes(wrappedElement).asScala.map(WStereotype).toSet

}
