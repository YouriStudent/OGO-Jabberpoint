import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * <p>The abstract class for items on a slide.<p>
 * <p>All SlideItems have drawing capabilities.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class SlideItem {
    private int level;

    public SlideItem(int lev) {
        level = lev;
    }

    public SlideItem() {
        this(0);
    }

    /**
     * Returns the Level of a slide
     *
     * @return integer with the level
     */
    public int getLevel() {
        return level;
    }

    //Returns the bounding box
    public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

    //Draws the item
    public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);
}
