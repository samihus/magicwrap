# How to use in a plugin 
## Scala

```scala 
import java.awt.event.ActionEvent

import com.samihus.magicdraw.wrapper.WCaster
import com.samihus.magicdraw.wrapper.api.scalaapi.{WClass, WDefaultBrowserAction}

class ScalaExample() extends WDefaultBrowserAction(actionName= "Name of the action") {
  override def actionPerformed(actionEvent: ActionEvent): Unit = {
    val mayBeWClass: Option[WClass] = getSelectedObjectAsBaseElement.flatMap(WCaster.toMayBeWClass)
  }
}
```

## Java

```java
import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.samihus.magicdraw.wrapper.api.javaapi.JClass;

import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.util.Optional;

public class Example extends DefaultBrowserAction {
    public Example(String actionID, String actionName, KeyStroke stroke, String group) {
        super(actionID, actionName, stroke, group);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        final Optional<Object> selectedObject = Optional.ofNullable(getSelectedObject());
        if (selectedObject.isPresent()) {
            try {
                JClass JavaWrappedClass = new JClass((Class) selectedObject.get());
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }
}
```