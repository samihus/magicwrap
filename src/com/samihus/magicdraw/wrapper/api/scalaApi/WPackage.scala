package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package
import com.samihus.magicdraw.wrapper.traits.{HasGeneralInfo, PACKAGE, Stereotypable, Wrap, TypeOfWrappedElement}
case class WPackage(override val wrappedElement: Package)
  extends HasGeneralInfo
    with Stereotypable
    with Wrap[Package]  {
  override val is: TypeOfWrappedElement = PACKAGE
}
