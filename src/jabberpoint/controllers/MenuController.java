package jabberpoint.controllers;

import jabberpoint.Presentation;
import jabberpoint.factories.MenuFactory;

import java.awt.*;

import static jabberpoint.utility.MenuAttributes.FILE;
import static jabberpoint.utility.MenuAttributes.HELP;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
    public static final String TESTFILE = "testPresentation.xml";
    public static final String SAVEFILE = "savedPresentation.xml";

    private static final long serialVersionUID = 227L;

    public MenuController(Frame parent, Presentation presentation) {
        add(MenuFactory.CreateMenu(FILE, parent, presentation));
        add(MenuFactory.CreateMenu(HELP, parent, presentation));
        setHelpMenu(MenuFactory.CreateMenu(HELP, parent, presentation));
    }
}
