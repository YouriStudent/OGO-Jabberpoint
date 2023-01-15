package jabberpoint.controllers;

import jabberpoint.AboutBox;
import jabberpoint.JabberPoint;
import jabberpoint.Presentation;
import jabberpoint.factories.PresentationFactory;

import javax.swing.*;
import java.awt.*;

import static jabberpoint.utility.MenuAttributes.*;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
    protected static final String TESTFILE = "testPresentation.xml";
    protected static final String SAVEFILE = "savedPresentation.xml";

    private static final long serialVersionUID = 227L;
    private final Frame parent; //The frame, only used as parent for the Dialogs
    private final Presentation presentation; //Commands are given to the presentation

    public MenuController(Frame frame, Presentation pres) {
        parent = frame;
        presentation = pres;
        MenuItem menuItem;
        Menu fileMenu = new Menu(FILE);
        fileMenu.add(menuItem = mkMenuItem(OPEN));
        menuItem.addActionListener(actionEvent -> {
            presentation.clear();
            PresentationFactory.loadPresentation("xml", presentation, TESTFILE);
            parent.repaint();
        });
        fileMenu.add(menuItem = mkMenuItem(NEW));
        menuItem.addActionListener(actionEvent -> {
            presentation.clear();
            parent.repaint();
        });
        fileMenu.add(menuItem = mkMenuItem(SAVE));
        menuItem.addActionListener(e -> PresentationFactory.savePresentation("xml", presentation, SAVEFILE, parent));
        fileMenu.addSeparator();
        fileMenu.add(menuItem = mkMenuItem(EXIT));
        menuItem.addActionListener(actionEvent -> JabberPoint.exit(0));
        add(fileMenu);
        Menu viewMenu = new Menu(VIEW);
        viewMenu.add(menuItem = mkMenuItem(NEXT));
        menuItem.addActionListener(actionEvent -> presentation.nextSlide());
        viewMenu.add(menuItem = mkMenuItem(PREV));
        menuItem.addActionListener(actionEvent -> presentation.prevSlide());
        viewMenu.add(menuItem = mkMenuItem(GOTO));
        menuItem.addActionListener(actionEvent -> {
            String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
            int pageNumber = Integer.parseInt(pageNumberStr);
            presentation.changeSlide(pageNumber - 1);
        });
        add(viewMenu);
        Menu helpMenu = new Menu(HELP);
        helpMenu.add(menuItem = mkMenuItem(ABOUT));
        menuItem.addActionListener(actionEvent -> AboutBox.show(parent));
        setHelpMenu(helpMenu);
    }

    //Creating a menu-item
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
