package jabberpoint;

import jabberpoint.factories.StyleFactory;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>A slide. This class has drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide {
    protected String title; //The title is kept separately
    protected Vector<SlideItem> items; //The SlideItems are kept in a vector

    public Slide() {
        items = new Vector<>();
    }

    /*
     * Append
     */
    public void append(SlideItem anItem) {
        items.addElement(anItem);
    }

    public void append(int level, String message) {
        append(new TextItem(level, message));
    }

    /*
     * Main Functions
     */
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;
        // The title is treated separately
        SlideItem slideItem = new TextItem(0, getTitle());

        Style style = StyleFactory.getStyle(slideItem.getLevel());

        slideItem.draw(area.x, y, scale, g, style, view);
        y += slideItem.getBoundingBox(g, view, scale, style).height;
        for (int number = 0; number < getSize(); number++) {
            slideItem = getSlideItems().elementAt(number);
            style = StyleFactory.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    /*
     * GETTERS
     */

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.items.size();
    }

    public Vector<SlideItem> getSlideItems() {
        return this.items;
    }

    //Returns the scale to draw a slide
    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / ((float) JabberPoint.WIDTH), ((float) area.height) / ((float) JabberPoint.HEIGHT));
    }

    /*
     * SETTERS
     */
    public void setTitle(String newTitle) {
        title = newTitle;
    }

}
