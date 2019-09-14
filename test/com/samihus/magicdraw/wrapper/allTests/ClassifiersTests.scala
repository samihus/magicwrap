package com.samihus.magicdraw.wrapper.allTests

import java.io.File

import com.nomagic.magicdraw.core.project.{ProjectDescriptor, ProjectDescriptorsFactory, ProjectsManager}
import com.nomagic.magicdraw.core.{Application, Project}
import com.nomagic.magicdraw.tests.MagicDrawTestRunner
import com.nomagic.magicdraw.uml.BaseElement
import com.samihus.magicdraw.wrapper.WCaster._
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(classOf[MagicDrawTestRunner])
class ClassifiersTests {
  val descriptor: ProjectDescriptor =
    ProjectDescriptorsFactory.createProjectDescriptor(
      new File("/Applications/MagicDraw/openapi/ide/MD_DEV_5/plugins/My Plug-in 1/test/resources/ProjetTestWrapper/ProjetTestWrapper.mdzip").toURI
    )
  val projectsManager: ProjectsManager = Application.getInstance().getProjectsManager
  val project: Project = {
    projectsManager.loadProject(descriptor, true)
    projectsManager.getActiveProject
  }

  val emptyClass: BaseElement = project.getElementByID("_19_0_1_6490213_1568265874138_307782_4671")
  val animal: BaseElement = project.getElementByID("_19_0_1_6490213_1566473579096_470275_4629")
  val pet: BaseElement = project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645")
  val dog: BaseElement = project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733")
  val cat: BaseElement = project.getElementByID("_19_0_1_6490213_1566413850034_201781_4681")
  val master: BaseElement = project.getElementByID("_19_0_1_6490213_1566414160102_998584_4773")
  val friend: BaseElement = project.getElementByID("_19_0_1_6490213_1566473638161_142640_4660")
  val enum1: BaseElement = project.getElementByID("_19_0_1_6490213_1567887734310_574362_4777")
  val eee: BaseElement = project.getElementByID("_19_0_1_6490213_1567887739341_848491_4801")
  val emptyData: BaseElement = project.getElementByID("_19_0_1_6490213_1567929782118_953555_4808")
  val moveableI: BaseElement = project.getElementByID("_19_0_1_6490213_1566413913409_190065_4693")
  val spacLocI: BaseElement = project.getElementByID("_19_0_1_6490213_1566474163273_634516_4694")
  val param: BaseElement = project.getElementByID("_19_0_1_6490213_1568317061248_451752_4661")

  // hierarchy tests
  @Test def directParentsTest(): Unit = {
    assertTrue(toMayBeWClass(dog).get.directParents.map(_.name) == Set("Pet", "Friend"))
  }

  @Test def directParentsEnumTest(): Unit = {
    assertTrue(toMayBeWEnumeration(eee).get.directParents.map(_.name) == Set("enum1"))
  }

  @Test def directParentsInterfaceTest(): Unit = {
    assertTrue(toMayBeWInterface(moveableI).get.directParents.map(_.name) == Set("SpaceLocated"))
  }

  @Test def allParentsTest(): Unit = {
    assertTrue(toMayBeWClass(dog).get.allParents.map(_.name) == Set("Pet", "Friend", "Animal"))
  }

  @Test def allChildrenTest(): Unit = {
    assertTrue(toMayBeWClass(animal).get.allChildren.map(_.name) == Set("Pet", "Cat", "Dog"))
  }

  @Test def directChildrenTest(): Unit = {
    assertTrue(toMayBeWClass(animal).get.directChildren.map(_.name) == Set("Pet"))
  }


  // attributes tests
  @Test def ownedAttributesTest(): Unit = {
    assertTrue(toMayBeWClass(pet).get.ownedAttributes.map(_.name) == Set("birth date", "specie", "petMaster"))
  }

  @Test def ownedAttributesFromAssoTest(): Unit = {
    assertTrue(toMayBeWClass(pet).get.ownedAttributesFromAssociation.map(_.name) == Set("petMaster"))
  }

  @Test def ownedAttributesNotFromAssoTest(): Unit = {
    assertTrue(toMayBeWClass(pet).get.ownedAttributesNotFromAssociation.map(_.name) == Set("birth date", "specie"))
  }

  @Test def allAttributesTest(): Unit = {
    assertTrue(toMayBeWClass(pet).get.allAttributes.map(_.name) == Set("birth date", "specie", "petMaster", "unnamed1", "master"))
  }

  @Test def allAttributesFromAssoTest(): Unit = {
    assertTrue(toMayBeWClass(pet).get.allAttributesFromAssociations.map(_.name) == Set("petMaster", "master"))
  }

  @Test def allAttributesNotFromAssoTest(): Unit = {
    assertTrue(toMayBeWClass(pet).get.allAttributesNotFromAssociations.map(_.name) == Set("birth date", "specie", "unnamed1"))
  }

  @Test def inheritedAttTest(): Unit = {
    assertTrue(toMayBeWClass(dog).get.inheritedAttributes.map(_.name) == Set("birth date", "specie", "petMaster", "unnamed1", "master", "friendName"))
  }

  @Test def checkAttributeTest(): Unit = {
    assertTrue(toMayBeWClass(pet).get.hasAttribute("birth date"))
  }

  @Test def redefinedAttrTest(): Unit = {
    assertTrue(toMayBeWClass(cat).get.redefinedAttributes.map(_.name) == Set("specie"))
  }


}
