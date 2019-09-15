package com.samihus.magicdraw.wrapper.api.scalaapi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package
import com.samihus.magicdraw.wrapper.{PACKAGE, TypeOfWrappedElement}
import com.samihus.magicdraw.wrapper.traits.{HasGeneralInfo, Stereotypable, Wrap}
case class WPackage(override val wrappedElement: Package)
  extends HasGeneralInfo
    with Stereotypable
    with Wrap[Package]  {
  override val is: TypeOfWrappedElement = PACKAGE
}
