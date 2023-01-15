package jabberpoint.factories;

import jabberpoint.*;
import jabberpoint.accessors.Accessor;
import jabberpoint.accessors.DemoAccessor;
import jabberpoint.accessors.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PresentationFactory {
    protected static final String IOERR = "IO Error: ";
    protected static final String JABERR = "Jabberpoint Error ";
    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";

    public static void loadPresentation(String type, Presentation presentation, String filename) {
        // Generate styles for a presentation
        StyleFactory.generateDefaultStyles();
        Accessor accessor;

        if (type == null) {
            accessor = new DemoAccessor();
        } else if (type.equals("xml")) {
            accessor = new XMLAccessor();
        } else {
            JOptionPane.showMessageDialog(null, String.format("Function not available for type %s", type));
            return;
        }
        try {
            accessor.loadFile(presentation, filename);
            presentation.changeSlide(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void savePresentation(String type, Presentation presentation, String filename, Frame parent) {

        Accessor accessor;
        if (type == null) {
            accessor = new DemoAccessor();
        } else if (type.equals("xml")) {
            accessor = new XMLAccessor();
        } else {
            JOptionPane.showMessageDialog(parent, String.format("Function not available for type %s", type));
            return;
        }

        try {
            accessor.saveFile(presentation, filename);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
