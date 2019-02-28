import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {

    public static List<Image> imageListV;
    public static List<Image> imageListH;

    private static List<Slide> slides = new ArrayList<>();
    private static List<Slide> OfficialySlides;


    public static void main(String... args){

        if(args[0].equals("ALL")){
            String[] allFiles = new String[5];
            allFiles[0]= "inputs/a_example.txt";
            allFiles[1] = "inputs/b_lovely_landscapes.txt";
            allFiles[2] = "inputs/c_memorable_moments.txt";
            allFiles[3] = "inputs/d_pet_pictures.txt";
            allFiles[4] = "inputs/e_shiny_selfies.txt";
            for(String file : allFiles){
                ExampleParseur exampleParseur = new ExampleParseur(file);
                imageListH = exampleParseur.getImageListH();
                imageListV = exampleParseur.getImageListV();
                creationSlide();
                RandomAlgo randomAlgo = new RandomAlgo(slides);
                List<Slide> result = randomAlgo.process();
                new Output(result.size(),result,file);
                slides = new ArrayList<>();
            }
        }
        else {
            ExampleParseur exampleParseur = new ExampleParseur(args[0]);
            imageListH = exampleParseur.getImageListH();
            imageListV = exampleParseur.getImageListV();
            creationSlide();
            RandomAlgo randomAlgo = new RandomAlgo(slides);
            List<Slide> result = randomAlgo.process();
            new Output(result.size(),result,args[0].split("/")[1]);
        }

    }

    static void creationSlide(){
        int length = imageListV.size()-1;
        if(imageListV.size()%2==0){
            length = imageListV.size();
        }
        Collections.shuffle(imageListV);
        for(int i=0; i<length-1; i+=2){
            Image[] images = new Image[2];
            images[0] = imageListV.get(i);
            images[1] = imageListV.get(i+1);
            Slide slide = new Slide();
            slide.add(images[0]);
            slide.add(images[1]);
            slides.add(slide);
        }
        Collections.shuffle(imageListH);
        for(Image image : imageListH){
            Slide slide = new Slide();
            slide.add(image);
            slides.add(slide);
        }
    }

    private static void printListImage() {
        for(Image image : imageListV)
            System.out.println(image);
        for(Image image : imageListH)
            System.out.println(image);
    }
}
