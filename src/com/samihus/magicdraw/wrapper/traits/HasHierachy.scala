package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier

import scala.collection.JavaConverters._

trait HasHierachy extends Wrap[Classifier] {
  type ClassifierType <: HasHierachy

  def directParents: Set[ClassifierType]
  def allParents:Set[ClassifierType]
  def directChildren:Set[ClassifierType]
  def allChildren: Set[ClassifierType]
}
