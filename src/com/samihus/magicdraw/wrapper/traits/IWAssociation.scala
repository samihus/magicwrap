package com.samihus.magicdraw.wrapper.traits

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Association

trait IWAssociation
  extends HasGeneralInfo
    with HasHierachy
    with IWType
    with Stereotypable
    with Wrap[Association]