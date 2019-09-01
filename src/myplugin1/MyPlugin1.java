package myplugin1;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.project.ProjectDescriptor;
import com.nomagic.magicdraw.core.project.ProjectDescriptorsFactory;
import com.nomagic.magicdraw.core.project.ProjectsManager;
import com.nomagic.magicdraw.plugins.Plugin;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.samihus.magicdraw.wrapper.api.scalaApi.WClass;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyPlugin1 extends Plugin
{
	public static boolean initialized;
	
	@Override
	public void init()
	{
		initialized = true;


	}

	@Override
	public boolean close()
	{


		File projectForTest = new File("/Users/samih/Desktop/ProjetTestWrapper/ProjetTestWrapper.mdzip");
		ProjectDescriptor descriptor = ProjectDescriptorsFactory.createProjectDescriptor(projectForTest.toURI());
		ProjectsManager projectsManager = Application.getInstance().getProjectsManager();
		projectsManager.loadProject(descriptor, false);
		Project project = projectsManager.getActiveProject();

		Class cl = (Class)project.getElementByID("_19_0_1_6490213_1566413767485_541943_4645"); //Pet
		WClass wcl = new WClass(cl);
		HashMap<String,String> map = new HashMap<>();
		wcl.allAttributes().foreach(
			x -> map.put(x.name(),x.classifierType().get().toString())
		);
		String s = "";
		for(Map.Entry<String, String> m: map.entrySet()) {
			s += ":: " + m.getKey() + " : " +m.getValue() +"\n";
			System.out.println(s);
		}
		Application.getInstance().getGUILog().writeLogText(s, true);
		Optional<WClass> dd = Optional.of(wcl.getDirectParents().head());

/*
		cl.getNestedClassifier().forEach(x -> {
			Application.getInstance().getGUILog().showMessage(x.getName());
		});

 */


		//WCaster<Class,WClass> c = new WCaster<>(project.getElementByID("_19_0_1_6490213_1566414121971_53324_4733"));//Dog
		//scala.Option<WClass> xx = c.safeWrap(WClass::new);

/*
		JavaConverters.asJavaCollection(xx.get().getAllParents()).forEach( x -> {
			WClass xwc = (WClass)x;
			Application.getInstance().getGUILog().showMessage(xwc.name());
		});

 */





		return true;
	}

	@Override
	public boolean isSupported()
	{
		return true;
	}
}
