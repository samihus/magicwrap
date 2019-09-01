package com.samihus.magicdraw.wrapper.internal.utils

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement
import com.samihus.magicdraw.wrapper.internal.traits.{WNamedElement, WStereotype}

case class WStereotypedElement(element : WNamedElement[NamedElement], stereotype: WStereotype) {
  require(element.hasStereotype(stereotype))

}
