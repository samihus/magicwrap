package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Operation, Property}
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype
import com.samihus.magicdraw.wrapper.internal.traits
import com.samihus.magicdraw.wrapper.internal.traits.{WClassifier, WNamedElement, WType}

case class WStereotype(wrappedElement: Stereotype)
  extends  com.samihus.magicdraw.wrapper.internal.traits.WStereotype with ScalaWrapper {

}
