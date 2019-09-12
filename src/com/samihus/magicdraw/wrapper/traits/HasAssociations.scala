package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier
import com.samihus.magicdraw.wrapper.api.ScalaWrapper

import scala.collection.JavaConverters._

trait HasAssociations extends Wrap[Classifier] {

  def inheritedAssociations: Set[IWAssociation] = allAssociations.diff(ownedAssociations)

  def allAssociations: Set[IWAssociation] = ClassifierHelper.associationsIncludingInherited(wrappedElement).asScala.map(ScalaWrapper.WAssociationConstructor).toSet

  def ownedAssociations: Set[IWAssociation] = ClassifierHelper.associations(wrappedElement).asScala.map(ScalaWrapper.WAssociationConstructor).toSet
}
