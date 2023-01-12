import java.awt.*;

/**
 * <p>Style stands for Indent, Color, Font and Leading.</p>
 * <p>The link between a style number and a item level is hard-linked:
 * in Slide the style is grabbed for an item
 * with a style number the same as the item level.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Style {
    private static final String FONTNAME = "Helvetica";
    private static Style[] styles; // de styles
    int indent;
    Color color;
    Font font;
    int fontSize;
    int leading;

    public Style(int indent, Color color, int points, int leading) {
        this.indent = indent;
        this.color = color;
        font = new Font(FONTNAME, Font.BOLD, fontSize = points);
        this.leading = leading;
    }

    public static void createStyles() {
        styles = StyleFactory.generateDefaultStyles();
    }

    public static Style getStyle(int level) {
        if (level >= styles.length) {
            level = styles.length - 1;
        }
        return styles[level];
    }

    public String toString() {
        return String.format("[%s,$s; %s on %s]", indent, color, fontSize, leading);
    }

    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }
}
