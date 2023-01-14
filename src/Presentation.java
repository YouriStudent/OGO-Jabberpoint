import java.util.ArrayList;


/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
    private String showTitle; //The title of the presentation
    private ArrayList<Slide> slides = null; //An ArrayList with slides
    private int currentSlideNumber = 0; //The number of the current slide
    private SlideViewerComponent slideViewComponent = null; //The view component of the slides

    public Presentation() {
        this(null);
    }

    public Presentation(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    public int getSize() {
        return slides.size();
    }

    public String getTitle() {
        return showTitle;
    }

    public void setTitle(String nt) {
        showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }

    // Returns the current slide number
    public int getSlideNumber() {
        return currentSlideNumber;
    }

    // report the current slide number to the window
    public void changeSlide(int number) {
        if (slides != null && slides.size() > number) {
            currentSlideNumber = number;
        }
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    //Navigate to the previous slide unless we are at the first slide
    public void prevSlide() {
        if (currentSlideNumber > 0) {
            changeSlide(currentSlideNumber - 1);
        }
    }

    //Navigate to the next slide unless we are at the last slide
    public void nextSlide() {
        if (currentSlideNumber < (slides.size() - 1)) {
            changeSlide(currentSlideNumber + 1);
        }
    }

    //Remove the presentation
    void clear() {
        slides = new ArrayList<Slide>();
        changeSlide(-1);
    }

    //Add a slide to the presentation
    public void append(Slide slide) {
        slides.add(slide);
    }

    //Return a slide with a specific number
    public Slide getSlide(int number) {
        if (number < 0 || number >= getSize()) {
            return null;
        }
        return slides.get(number);
    }

    //Return the current slide
    public Slide getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }
}
