package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WNamedElement, WType}

case class WStereotype(wrappedElement: Stereotype)
  extends WNamedElement[Stereotype]
      with WType[Stereotype]
      with WClassifier[Stereotype]
      with com.samihus.magicdraw.wrapper.internal.traits.WClass[Stereotype] {

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


  }
