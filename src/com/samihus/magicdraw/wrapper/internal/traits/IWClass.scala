package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class

trait IWClass extends IWClassifier[Class] with IWType {

  def allOperations: Set[IWOperation]

  def ownedOperations: Set[IWOperation]

  def inheritedOperations: Set[IWOperation]

  /**
    * @group Sub-SuperTypes
    * @return List of direct parents
    */
  def getDirectParents: List[IWClass]

  /**
    * @group Sub-SuperTypes
    * @return List of all parents hierarchy
    */
  def getAllParents: List[IWClass]

}
