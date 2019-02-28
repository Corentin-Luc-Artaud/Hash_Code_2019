import java.util.ArrayList;

public class Runner {

    public static ArrayList<Image> imageListV;
    public static ArrayList<Image> imageListH;
    public static void main(String... args){
        ExampleParseur exampleParseur = new ExampleParseur(args[0]);
        imageListH = exampleParseur.getImageListH();
        imageListV = exampleParseur.getImageListV();
        printListImage();

        Output output = new Output(5);
    }




    private static void printListImage() {
        for(Image image : imageListV)
            System.out.println(image);
        for(Image image : imageListH)
            System.out.println(image);
    }
}
