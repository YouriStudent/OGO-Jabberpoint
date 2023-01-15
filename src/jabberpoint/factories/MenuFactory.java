package jabberpoint.factories;

import jabberpoint.AboutBox;
import jabberpoint.JabberPoint;
import jabberpoint.Presentation;

import javax.swing.*;
import java.awt.*;

import static jabberpoint.controllers.MenuController.SAVEFILE;
import static jabberpoint.controllers.MenuController.TESTFILE;
import static jabberpoint.utility.MenuAttributes.*;

public class MenuFactory {
    //Creating a menu-item
    public static MenuItem createMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

    public static Menu CreateMenu(String type, Frame parent, Presentation presentation) {
        MenuItem menuItem;
        Menu menu = null;

        if (type.equals(FILE)) {
            menu = new Menu(FILE);
            menu.add(menuItem = createMenuItem(OPEN));
            menuItem.addActionListener(actionEvent -> {
                presentation.clear();
                PresentationFactory.loadPresentation("xml", presentation, TESTFILE);
                parent.repaint();
            });
            menu.add(menuItem = createMenuItem(NEW));
            menuItem.addActionListener(actionEvent -> {
                presentation.clear();
                parent.repaint();
            });
            menu.add(menuItem = createMenuItem(SAVE));
            menuItem.addActionListener(e -> PresentationFactory.savePresentation("xml", presentation, SAVEFILE, parent));
            menu.addSeparator();
            menu.add(menuItem = createMenuItem(EXIT));
            menuItem.addActionListener(actionEvent -> JabberPoint.exit(0));
        } else if (type.equals(VIEW)) {
            menu = new Menu(VIEW);
            menu.add(menuItem = createMenuItem(NEXT));
            menuItem.addActionListener(actionEvent -> presentation.nextSlide());
            menu.add(menuItem = createMenuItem(PREV));
            menuItem.addActionListener(actionEvent -> presentation.prevSlide());
            menu.add(menuItem = createMenuItem(GOTO));
            menuItem.addActionListener(actionEvent -> {
                String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
                int pageNumber = Integer.parseInt(pageNumberStr);
                presentation.changeSlide(pageNumber - 1);
            });
        } else if (type.equals(HELP)) {
            menu = new Menu(HELP);
            menu.add(createMenuItem(ABOUT));
            menu.addActionListener(actionEvent -> AboutBox.show(parent));
        }
        return menu;
    }
}
