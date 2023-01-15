package jabberpoint;

import jabberpoint.controllers.KeyController;
import jabberpoint.controllers.MenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>The applicatiewindow for a slideviewcomponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerFrame extends JFrame {

    private static final long serialVersionUID = 3227L;
    private static final String JABTITLE = "Jabberpoint 1.6 - OU";

    public SlideViewerFrame(String title, Presentation presentation) {
        super(title);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
        presentation.setShowView(slideViewerComponent);
        setupWindow(slideViewerComponent, presentation);
    }

    //Setup the GUI
    public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
        setTitle(JABTITLE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JabberPoint.exit(0);
            }
        });
        getContentPane().add(slideViewerComponent);
        addKeyListener(new KeyController(presentation)); //Add a controller
        setMenuBar(new MenuController(this, presentation));    //Add another controller
        setSize(new Dimension(JabberPoint.WIDTH, JabberPoint.HEIGHT)); //Same sizes a slide has
        setVisible(true);
    }
}
