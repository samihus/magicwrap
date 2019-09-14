package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier


trait HasHierachy extends Wrap[Classifier] {
  type ClassifierType <: HasHierachy

  /**
    * Get Direct Parents of the classifier
    * @return
    */
  def directParents: Set[ClassifierType]

  /**
    * Get all parents hierarchy of the classifier
    * @return
    */
  def allParents:Set[ClassifierType]

  /**
    * Get direct children
    * @return
    */
  def directChildren:Set[ClassifierType]

  /**
    * Get all children hierarchy
    * @return
    */
  def allChildren: Set[ClassifierType]
}
