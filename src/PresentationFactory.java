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

        if (type == null) {
            new DemoPresentation().loadFile(presentation, filename);
            presentation.changeSlide(0);
            return;
        }
        type = type.toLowerCase();
        if (type.equals("xml")) {
            try {
                new XMLAccessor().loadFile(presentation, filename);
                presentation.changeSlide(0);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void savePresentation(String type, Presentation presentation, String filename, Frame parent){
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.saveFile(presentation, filename);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
