package com.samihus.magicdraw.wrapper

import java.io.{File, PrintWriter}

import com.nomagic.magicdraw.core.project.{ProjectDescriptor, ProjectDescriptorsFactory, ProjectsManager}
import com.nomagic.magicdraw.core.{Application, Project}
import com.nomagic.magicdraw.tests.MagicDrawTestRunner
import com.nomagic.magicdraw.uml.BaseElement
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.{Class, Package}
import myplugin1.MyPlugin1
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import com.samihus.magicdraw.wrapper.api.scalaApi
import com.samihus.magicdraw.wrapper.api.scalaApi.{WClass, WPackage}

//remove if not needed

@RunWith(classOf[MagicDrawTestRunner])
class WrapperTest  {


  val descriptor: ProjectDescriptor =
          ProjectDescriptorsFactory.createProjectDescriptor(
            new File("/Users/samih/Desktop/ProjetTestWrapper/ProjetTestWrapper.mdzip").toURI
          )
  val projectsManager: ProjectsManager = Application.getInstance().getProjectsManager
  val project: Project = {
    projectsManager.loadProject(descriptor,true)
    projectsManager.getActiveProject
  }

  @Test
  def testPluginInitialized(): Unit = {
    assertTrue(MyPlugin1.initialized)
  }

  @Test
  def testProjectLoad(): Unit = {
    assertTrue(project.getModels.size == 1)
    assertTrue(project.getName.==("ProjetTestWrapper"))
  }

  @Test
  def testGeneralInfosOnWrap(): Unit = {
    val pack = project.getElementByID("_19_0_1_6490213_1566413742058_44872_4610")
    val wp = WPackage(pack.asInstanceOf[Package])
    //name
    assertTrue({
      //printer.write(wp.name)
      wp.name == "package1"
    })
    //Owner
    assertTrue {
      wp.owner.asInstanceOf[Package].getName == "Model"
    }

    //Documentation
    assertTrue(wp.documentation == "documentation")
  }

  @Test
  def testStereotypeApplication(): Unit = {
    val wp = scalaApi.WPackage(
      //package1
      project.getElementByID("_19_0_1_6490213_1566413742058_44872_4610").
        asInstanceOf[Package]
    )
    assertTrue("really applied stereotype",wp.hasStereotype("racine"))
    assertFalse("fake stereotype",wp.hasStereotype("fakeStereotype"))
    assertFalse("not applied stereotype", wp.hasStereotype("subPackage"))
  }

  @Test
  def testClassAllAttributes(): Unit = {
    val cl = WClass(
      //Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.allAttributes.size == 5)
  }

  @Test
  def testClassAttributes(): Unit = {
    val cl = scalaApi.WClass(
      //Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.ownedAttributes.map(_.name) == Set("birth date","specie","petMaster" ))
  }

  @Test
  def testClassAttributesFromAssociation(): Unit = {
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    val attFromAsso:Set[String] = Set("petMaster")
    assertTrue(cl.ownedAttributesFromAssociation.map(_.name).toSet == attFromAsso)
  }

  @Test
  def testClassOwnedAttributes(): Unit = {
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )

    val listOfOwnedAttributesNames: Set[String] = Set("birth date","specie","petMaster")
    assertTrue(
      cl.ownedAttributes.map(_.name) == listOfOwnedAttributesNames
    )

  }

  @Test
  def testHasAttributeOwned(): Unit ={
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.hasAttribute("birth date"))
  }

  @Test
  def testAllAttributes(): Unit = {
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.allAttributes.map(_.name).toSet == Set("birth date","specie","petMaster","unnamed1","master"))
  }

  @Test
  def testAllAttributesFromAssociations(): Unit = {
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.allAttributesFromAssociations.map(_.name).toSet == Set("petMaster","master"))
  }

  @Test
  def testAllAttributesNotFromAssociations(): Unit = {
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.allAttributesNotFromAssociations.map(_.name).toSet == Set("birth date","specie","unnamed1"))
  }


  @Test
  def testHasAttributeInherited(): Unit = {
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.hasAttribute("unnamed1"))
  }

  @Test
  def testHasAttributeFromInheritedAssociation(): Unit = {
    val cl = scalaApi.WClass(
      // Pet
      project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645").asInstanceOf[Class]
    )
    assertTrue(cl.hasAttribute("master"))
  }

  @Test
  def testClassGetAllParents(): Unit = {
    val cl = scalaApi.WClass(
      project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733").asInstanceOf[Class]
    )

    assertTrue(cl.allParents.map(_.name).toSet == Set("Friend","Pet","Animal"))
  }

  @Test
  def testClassGetDirectParents(): Unit = {
    val cl = scalaApi.WClass(
      project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733").asInstanceOf[Class]
    )
    val printer = new PrintWriter(
      new File(
        "/Users/samih/Desktop/ProjetTestWrapper/log.txt"
      )
    )
    cl.directParents.map(_.name).foreach(printer.write)
    printer.close()
    assertTrue(cl.directParents.map(_.name).toSet == Set("Friend","Pet"))
  }

  @Test
  def testWCaster(): Unit = {
    import WCaster._
    val mdCl: BaseElement= project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733")
   // assertTrue(WClass(WCaster[Class,WClass](mdCl).safeCast.get).name == "Dog")
    assertTrue(toMayBeWClass(mdCl).get.name ==  "Dog")
  }

  @Test
  def testWCasterWrap(): Unit = {

    val mdCl: BaseElement= project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733")
    val c = WCaster[Class,WClass](WClass)(mdCl)


    assertTrue(
     WCaster.toMayBeWClass(mdCl).get.name == "Dog"
       //c.safeCast.get.getName ==  "Dog"
    )
  }

  /*
  @Test
  def toto: Unit = {
    val mdCl: BaseElement= project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733")
    //val toto:Toto[Class,WClass] =
    assertTrue(
      Toto[Class,WClass](WClass)(mdCl).safeWrap.get.name == "Dog"
    )
  }
   */
  @Test
  def ownedRedefinedAttributesTest(): Unit = {
    val mdCl: BaseElement= project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733") //Dog
    assertTrue(WCaster[Class,WClass](WClass)(mdCl).safeWrap.get.redefinedAttributes.map(_.name) == Set("birth date"))
  }

  @Test
  def testAttributeWrapper(): Unit = {
    val mdCl: BaseElement= project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733") //Dog
//TODO
  }

  @Test
  def testClassOperations: Unit = {
    val pet = project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645")
    val wpet: WClass = WCaster.toMayBeWClass(pet).get
    assertTrue(wpet.ownedOperations.map(_.name) == Set("sansnom1"))

  }

  @Test
  def testallClassOperations: Unit = {
    val dog =  project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733")
    val wdog: WClass = WCaster.toMayBeWClass(dog).get
    assertTrue(wdog.allOperations.map(_.name) == Set("sansnom1","aboie"))
  }

    @Test
  def testInheritedClassOperations: Unit = {
    val dog =  project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733")
    val wdog: WClass = WCaster.toMayBeWClass(dog).get
    assertTrue(wdog.inheritedOperations.map(_.name) == Set("sansnom1"))
  }

  def close(): Unit = {
  }
}
