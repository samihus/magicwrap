package com.samihus.magicdraw.wrapper

import java.io.{File, PrintWriter}
import java.text.SimpleDateFormat
import java.util.Calendar

import com.nomagic.magicdraw.core.project.{ProjectDescriptor, ProjectDescriptorsFactory, ProjectsManager}
import com.nomagic.magicdraw.core.{Application, Project}
import com.nomagic.magicdraw.tests.MagicDrawTestRunner
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package
import com.samihus.magicdraw.wrapper.api.scalaapi
import com.samihus.magicdraw.wrapper.api.scalaapi.WPackage
import org.junit.Test
import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterAll, FunSuite}

// NOT USED
@RunWith(classOf[MagicDrawTestRunner])
class WrapperTests2 extends FunSuite with BeforeAndAfterAll {
  val printer = new PrintWriter(
    new File(
      "/Users/samih/Desktop/ProjetTestWrapper/" +
        new SimpleDateFormat("yyyyMMdd-hhmmss-").format(Calendar.getInstance().getTime)
        + "log.txt"
    )
  )
  val projectForTest: File = new File("/Users/samih/Desktop/ProjetTestWrapper/ProjetTestWrapper.mdzip")
  val descriptor: ProjectDescriptor = ProjectDescriptorsFactory.createProjectDescriptor(projectForTest.toURI)
  val projectsManager: ProjectsManager = Application.getInstance().getProjectsManager
  val project: Project = {
    projectsManager.loadProject(descriptor,true)
    projectsManager.getActiveProject
  }

  override def afterAll(): Unit = {
    projectsManager.closeProject()
    printer.close()
  }

  /**
    * TESTS
    */

  test("Test of the first level structure") {
    assert(project.getModels.get(0).getName == "Model")
    assert(project.getName == "ProjetTestWrapper")
  }

  test("") {
    val pack = project.getElementByID("_19_0_1_6490213_1566413742058_44872_4610")
    val wp = scalaapi.WPackage(pack.asInstanceOf[Package])

    assert({
      printer.write(wp.name)
      wp.name == "package1"
    })
    assert {
      printer.write(wp.owner.asInstanceOf[Package].getName)
      wp.owner.asInstanceOf[Package].getName == "Model"
    }
  }
}
