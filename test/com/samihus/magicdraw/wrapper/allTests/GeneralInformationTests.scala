package com.samihus.magicdraw.wrapper.allTests

import java.io.File

import com.nomagic.magicdraw.core.project.{ProjectDescriptor, ProjectDescriptorsFactory, ProjectsManager}
import com.nomagic.magicdraw.core.{Application, Project}
import com.nomagic.magicdraw.tests.MagicDrawTestRunner
import com.nomagic.magicdraw.uml.BaseElement
import com.samihus.magicdraw.wrapper.WCaster._
import com.samihus.magicdraw.wrapper._
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(classOf[MagicDrawTestRunner])
class GeneralInformationTests {
  val descriptor: ProjectDescriptor =
    ProjectDescriptorsFactory.createProjectDescriptor(
      new File("/Applications/MagicDraw/openapi/ide/MD_DEV_5/plugins/My Plug-in 1/test/resources/ProjetTestWrapper/ProjetTestWrapper.mdzip").toURI
    )
  val projectsManager: ProjectsManager = Application.getInstance().getProjectsManager
  val project: Project = {
    projectsManager.loadProject(descriptor, true)
    projectsManager.getActiveProject
  }

  val emptyClass: BaseElement = project.getElementByID("_19_0_1_6490213_1568438944332_49944_4705")
  val animal: BaseElement     = project.getElementByID("_19_0_1_6490213_1566473579096_470275_4629")
  val pet: BaseElement        = project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645")
  val dog: BaseElement        = project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733")
  val cat: BaseElement        = project.getElementByID("_19_0_1_6490213_1566413850034_201781_4681")
  val master: BaseElement     = project.getElementByID("_19_0_1_6490213_1566414160102_998584_4773")
  val friend: BaseElement     = project.getElementByID("_19_0_1_6490213_1566473638161_142640_4660")
  val enum1: BaseElement      = project.getElementByID("_19_0_1_6490213_1567887734310_574362_4777")
  val emptyData: BaseElement  = project.getElementByID("_19_0_1_6490213_1567929782118_953555_4808")
  val moveableI: BaseElement  = project.getElementByID("_19_0_1_6490213_1566413913409_190065_4693")
  val spacLocI: BaseElement   = project.getElementByID("_19_0_1_6490213_1566474163273_634516_4694")
  val param: BaseElement      = project.getElementByID("_19_0_1_6490213_1568317061248_451752_4661")
  val package1: BaseElement   = project.getElementByID("_19_0_1_6490213_1566413742058_44872_4610")
  //
  @Test def CastAndWrap = {
    assert(WCaster.toMayBeWClass(pet).isDefined)
  }

  @Test def testName = {
    assertTrue(toMayBeWClass(pet).get.name == "Pet")
  }

  @Test def testDoc = {
    assertTrue(toMayBeWClass(pet).get.documentation == "Un Animal domestique")
  }

  @Test def testEmptyName = {
    assertTrue(emptyClass.get.name == "")
  }

  @Test def testEmptyDoc = {
    assertTrue(toMayBeWClass(dog).get.documentation == "")
  }

  @Test def testOwner = {
    assertTrue(toMayBeWClass(dog).get.owner.getID == "_19_0_1_6490213_1566413742058_44872_4610")
  }

  @Test def testImplicitElementConv = {
    assertTrue(dog.get.name == "Dog")
  }

  @Test def testImplicitElementConvWithPrecision = {
    assertTrue(dog.get.is == CLASS)
  }

  @Test def testGetClassWithEmptyAssociationEnd = {
    assertTrue(animal.get.name == "Animal")
  }

  @Test def testGetClassWithEmptyAtt = {
    assertTrue(param.get.is == CLASS)
  }

  // Transformations and wrapping testing
  @Test def testImplicitEnumConversion(): Unit = {
    assertTrue {
      package1.get.is == PACKAGE &&
      enum1.get.is == ENUMERATION &&
      moveableI.get.is == INTERFACE
    }
  }

}
