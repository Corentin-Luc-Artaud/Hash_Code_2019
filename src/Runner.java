import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static ArrayList<Image> imageListV;
    public static ArrayList<Image> imageListH;
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
                RandomAlgo randomAlgo = new RandomAlgo(exampleParseur.getImageList(),new ArrayList<>());
                List<Slide> result = randomAlgo.process();

            }
        }
        else {
            ExampleParseur exampleParseur = new ExampleParseur(args[0]);
            RandomAlgo randomAlgo = new RandomAlgo(exampleParseur.getImageList(), new ArrayList<>());
            List<Slide> result = randomAlgo.process();
            new Output(result.size(),result);
        }
        ExampleParseur exampleParseur = new ExampleParseur(args[0]);
        imageListH = exampleParseur.getImageListH();
        imageListV = exampleParseur.getImageListV();
    }




    private static void printListImage() {
        for(Image image : imageListV)
            System.out.println(image);
        for(Image image : imageListH)
            System.out.println(image);
    }
}
