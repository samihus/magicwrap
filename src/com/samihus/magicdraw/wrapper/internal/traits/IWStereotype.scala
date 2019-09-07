package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype

trait IWStereotype extends IWClassifier[Stereotype] with IWType {

  /**
    * @group Sub-SuperTypes
    * @return List of direct parents
    */
  def getDirectParents: List[IWStereotype]

  /**
    * @group Sub-SuperTypes
    * @return List of all parents hierarchy
    */
  def getAllParents: List[IWStereotype]

}

