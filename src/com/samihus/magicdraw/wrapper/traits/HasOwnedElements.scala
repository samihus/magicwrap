package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdinterfaces.Interface
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, NamedElement, Namespace, Operation, Package, Property}
import com.samihus.magicdraw.wrapper.api.scalaapi._

import scala.collection.JavaConverters._

trait HasOwnedElements extends Wrap[Namespace] {
  def ownedAttributesStereotypedAs(stereotypeName: String): Set[WAttribute] =
    membersOfTypeStereotypedAs[Property, WAttribute](stereotypeName)(WAttribute)

  def ownedClassesStereotypedAs(stereotypeName: String): Set[WClass] =
    membersOfTypeStereotypedAs[Class, WClass](stereotypeName)(WClass)

  private def membersOfTypeStereotypedAs[T <: NamedElement, W](stereotypeName: String)(f: T => W): Set[W] =
    membersStereotypedAs(stereotypeName)
      .filter(_.isInstanceOf[T])
      .map(x => f(x.asInstanceOf[T]))

  private def membersStereotypedAs(stereotypeName: String): Set[NamedElement] = wrappedElement.getMember
    .asScala.toSet
    .filter(StereotypesHelper.hasStereotype(_, stereotypeName))

  def ownedInterfacesStereotypedAs(stereotypeName: String): Set[WInterface] =
    membersOfTypeStereotypedAs[Interface, WInterface](stereotypeName)(WInterface)

  def ownedPackagesStereotypedAs(stereotypeName: String): Set[WPackage] =
    membersOfTypeStereotypedAs[Package, WPackage](stereotypeName)(WPackage)

  def ownedOperationsStereotypedAs(stereotypeName: String): Set[WOperation] =
    membersOfTypeStereotypedAs[Operation, WOperation](stereotypeName)(WOperation)
}
