package com.samihus.magicdraw.wrapper.internal.utils

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement
import com.samihus.magicdraw.wrapper.internal.traits.{IWNamedElement, IWStereotype}

case class WStereotypedElement(element : IWNamedElement[NamedElement], stereotype: IWStereotype) {
  require(element.hasStereotype(stereotype))

}
