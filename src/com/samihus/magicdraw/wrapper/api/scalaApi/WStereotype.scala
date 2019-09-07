package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits

case class WStereotype(wrappedElement: Stereotype)
  extends  com.samihus.magicdraw.wrapper.internal.traits.IWStereotype with ScalaWrapper {
  /**
    * @group Sub-SuperTypes
    * @return List of direct parents
    */
  override def getDirectParents: List[traits.IWStereotype] = ???

  /**
    * @group Sub-SuperTypes
    * @return List of all parents hierarchy
    */
  override def getAllParents: List[traits.IWStereotype] = ???
}
