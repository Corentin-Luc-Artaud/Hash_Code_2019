import java.util.*;

public class Runner {

    public static List<Image> imageListV = new ArrayList<>();
    public static List<Image> imageListH;

    public static TagDictionnary tagDictionnary = new TagDictionnary();

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
                AlgoBetter randomAlgo = new AlgoBetter(slides);
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
            AlgoBetter randomAlgo = new AlgoBetter(slides);
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
        tagDictionnary.addTag((ArrayList<Image>) imageListV);

        Iterator it = imageListV.iterator();
        ArrayList<Image> temp = new ArrayList<>();

        while(it.hasNext()){
            Image image = (Image) it.next();
            if(temp.contains(image)){
                it.remove();
                temp.remove(image);
                continue;
            }
            ArrayList<Image> images = getImage(image.getTags(), (ArrayList<Image>) ((ArrayList<Image>) imageListV).clone());
            Slide slide = new Slide();
            slide.add(image);
            Random rand = new Random();
            int index = rand.nextInt(images.size()>1?images.size()-1:1);
            Image imageTemp = images.get(index);
            temp.add(imageTemp);
            slide.add(imageTemp);
            slides.add(slide);
            it.remove();

        }
/*
        for(int i=0; i<length; i+=2){

            Image[] images = new Image[2];
            images[0] = imageListV.get(i);
            images[1] = imageListV.get(i+1);
            Slide slide = new Slide();
            slide.add(images[0]);
            slide.add(images[1]);
            slides.add(slide);
        }*/
        Collections.shuffle(imageListH);
        for(Image image : imageListH){
            Slide slide = new Slide();
            slide.add(image);
            slides.add(slide);
        }
    }

    public static ArrayList<Image> getImage(String[] tags, ArrayList<Image> images){
        for(String tag : tags){
            images.removeAll(tagDictionnary.tag_dict_image.get(tag));
            if(images.size()==0) {
                System.out.println(tagDictionnary.tag_dict_image.get(tag));
                return tagDictionnary.tag_dict_image.get(tag);
            }
        }
        return images;
    }
    private static void printListImage() {
        for(Image image : imageListV)
            System.out.println(image);
        for(Image image : imageListH)
            System.out.println(image);
    }
}
