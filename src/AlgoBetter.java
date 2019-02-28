import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgoBetter {
    List<Slide> slides;

    AlgoBetter(List<Slide> slides) {
        this.slides = slides;

    }

    public List<Slide> process() {
        for (int i = 0; i < slides.size() - 1; i++) {
            Slide me = slides.get(i);
            int jmax = (i+100);
            int scoremax = 0;
            int index = i + 1;
            for (int j = i + 1; j < (jmax<=slides.size()?jmax:slides.size()); j++) {
                int scoreactuel = me.computeScore(slides.get(j));
                if(scoremax<scoreactuel){
                    scoremax=scoreactuel;
                    index = j;
                }
                if(me.candidate(slides.get(j))){
                    index = j;
                    break;
                }

            }
            Collections.swap(slides, i + 1, index);
        }

        return slides;
    }

}
