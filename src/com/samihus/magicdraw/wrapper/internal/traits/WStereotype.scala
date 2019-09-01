package com.samihus.magicdraw.wrapper.internal.traits

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype

trait WStereotype extends WClass[Stereotype] {

  /**
    * @group Sub-SuperTypes
    * @return List of direct parents
    */
  override def getDirectParents: List[WStereotype] = ???
  /*wrappedElement.getSuperClass.asScala
    .flatMap(
      WCaster[Stereotype, WStereotype](_)
        .safeWrap(WStereotype))
    .toList

   */

  /**
    * @group Sub-SuperTypes
    * @return List of all parents hierarchy
    */
  override def getAllParents: List[WStereotype] = ???

  //todo
}
