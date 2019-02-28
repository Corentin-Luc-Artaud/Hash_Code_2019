import java.util.ArrayList;

public class Runner {

    public static ArrayList<Image> imageListV;
    public static ArrayList<Image> imageListH;

    private static ArrayList<Slide> slides;
    private static ArrayList<Slide> OfficialySlides;


    public static void main(String... args){
        ExampleParseur exampleParseur = new ExampleParseur(args[0]);
        imageListH = exampleParseur.getImageListH();
        imageListV = exampleParseur.getImageListV();
        creationSlide();


        //printListImage();

        Output output = new Output(5);
    }

    static void creationSlide(){
        for(int i=0; i<imageListV.size()-1; i+=2){
            Image[] images = new Image[2];
            images[0] = imageListV.get(i);
            images[1] = imageListV.get(i+1);

            slides.add(new Slide(images));
        }
        for(Image image : imageListH){
            Image[] images = new Image[1];
            images[0] = image;
            slides.add(new Slide(images));
        }
    }

    private static void printListImage() {
        for(Image image : imageListV)
            System.out.println(image);
        for(Image image : imageListH)
            System.out.println(image);
    }
}
