package com.samihus.magicdraw.wrapper.api.scalaApi

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package
import com.samihus.magicdraw.wrapper.api.ScalaWrapper
import com.samihus.magicdraw.wrapper.internal.traits.{IWPackage => WP}

case class WPackage(override val wrappedElement: Package) extends WP with ScalaWrapper {

}
