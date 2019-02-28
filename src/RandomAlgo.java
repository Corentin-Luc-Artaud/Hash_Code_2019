import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomAlgo {
    List<Slide> slides;

    RandomAlgo(List<Slide> slides) {
        this.slides = slides;

    }

    public List<Slide> process() {
        Collections.shuffle(slides);
        return slides;
    }
}
