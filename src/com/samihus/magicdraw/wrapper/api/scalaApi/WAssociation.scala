package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Association
import com.samihus.magicdraw.wrapper.WCaster
import com.samihus.magicdraw.wrapper.api.ClassifierHierarchy
import com.samihus.magicdraw.wrapper.traits.{ASSOCIATION, IWAssociation}

case class WAssociation(override val wrappedElement: Association) extends IWAssociation {

  override type ClassifierType = WAssociation

  override def directParents: Set[WAssociation] = ClassifierHierarchy[WAssociation](wrappedElement)(WCaster.toMayBeWAssociation).directParents

  override def allParents: Set[WAssociation] = ClassifierHierarchy[WAssociation](wrappedElement)(WCaster.toMayBeWAssociation).allParents


  override def directChildren: Set[WAssociation] = ClassifierHierarchy[WAssociation](wrappedElement)(WCaster.toMayBeWAssociation).directChildren


  override def allChildren: Set[WAssociation] = ClassifierHierarchy[WAssociation](wrappedElement)(WCaster.toMayBeWAssociation).allChildren

  override val is = ASSOCIATION
}
