package com.samihus.magicdraw.wrapper.api

import com.nomagic.uml2.ext.jmi.helpers.ClassifierHelper
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier

import scala.collection.JavaConverters._

/**
  * Not part of the library API
  * Helper to be used by classifiers implementing HasHierarchy trait in order
  * to get hierarchy
  * @param c the classifier to implement HasHierarchy
  * @param f the constructor of a wrapper of the classifier
  * @tparam T The type of the wrapper (WClass,...)
  */
case class ClassifierHierarchy[T](c: Classifier)(f: Classifier => Option[T]) {
  def directChildren: Set[T] = {
    ClassifierHelper.getDerivedClassifiers(c).asScala.toSet.map(f).flatten
  }

  def allChildren: Set[T] = {
    ClassifierHelper.getDerivedClassifiersRecursively(c).asScala.toSet.map(f).flatten
  }

  def directParents: Set[T] = {
    ClassifierHelper.getGeneralClassifiers(c).asScala.toSet.map(f).flatten
  }

  def allParents: Set[T] = {
    ClassifierHelper.getGeneralClassifiersRecursively(c).asScala.toSet.map(f).flatten
  }
}
