import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAlgo {

    List<Image> imageList;
    List<Slide> slides;

    RandomAlgo(List<Image> images, List<Slide> slides) {
        this.imageList = images;
        this.slides = slides;

    }

    public List<Slide> process() {
        boolean finish = false;
        int currentSlide = 0;
        while(!finish) {
            Slide slide = new Slide();
            slides.add(slide);
            while(!slide.possibility().equals(""))
            switch (slides.get(currentSlide).possibility()) {
                case "":
                    break;
                case "HV":
                    Random rand = new Random();
                    int random = rand.nextInt(imageList.size());
                    slides.get(currentSlide).add(imageList.get(random));
                    break;
                case "V":
                    while(slides.get(currentSlide).possibility().length()>0){
                        Random randomV = new Random();
                        int randomVint = randomV.nextInt(imageList.size());
                        if(imageList.get(randomVint).getOrientation().equals("V") && !slides.get(currentSlide).getImages().get(0).equals(imageList.get(randomVint))) {
                            slides.get(currentSlide).add(imageList.get(randomVint));
                            break;
                        }
                    }
            }
            currentSlide++;
            if(currentSlide>3){
                finish=true;
            }
        }
        return slides;
    }
}
