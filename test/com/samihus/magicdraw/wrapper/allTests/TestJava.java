package com.samihus.magicdraw.wrapper.allTests;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.project.ProjectDescriptor;
import com.nomagic.magicdraw.core.project.ProjectDescriptorsFactory;
import com.nomagic.magicdraw.core.project.ProjectsManager;
import com.nomagic.magicdraw.tests.MagicDrawTestRunner;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.samihus.magicdraw.wrapper.api.javaapi.Converter;
import com.samihus.magicdraw.wrapper.api.javaapi.JClass;
import com.samihus.magicdraw.wrapper.api.scalaapi.WClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Nullable;
import java.io.File;

@RunWith(MagicDrawTestRunner.class)
public class TestJava {

    @Nullable
    private Project project;

    void init() {
        ProjectDescriptor pd = ProjectDescriptorsFactory.createProjectDescriptor(
                new File("/Applications/MagicDraw/openapi/ide/MD_DEV_5" +
                        "/plugins/My Plug-in 1/test/resources/ProjetTestWrapper/ProjetTestWrapper.mdzip").toURI());
        ProjectsManager pm = Application.getInstance().getProjectsManager();
        pm.loadProject(pd, true);
        project = pm.getActiveProject();
    }

    @Test
    void test() {
        BaseElement animal = project.getElementByID("_19_0_1_6490213_1566473579096_470275_4629");
        WClass wClass = new WClass((Class) animal);
        JClass jClass = Converter.fromWClass(wClass);
    }
}
