import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.samihus.magicdraw.wrapper.api.javaapi.JClass;

import javax.swing.*;
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