import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExampleParseur {

    private static int numberOfPhotos;
    private static ArrayList<Image> imageListV;
    private static ArrayList<Image> imageListH;

    public ExampleParseur(String path){
        imageListV = new ArrayList<>();
        imageListH = new ArrayList<>();

        try {
            readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void readFile(String path) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            String line = sc.nextLine();

            setData(line);
            int index = 0;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] photoParameters = line.split(" ");
                int numberTag = Integer.parseInt(photoParameters[1]);
                String[] photosTags = new String[numberTag];
                for(int i=0;i<numberTag;i++){
                    photosTags[i] = photoParameters[i+2];
                }
                Image image = new Image(index,photoParameters[0],photosTags);

                if(image.getOrientation().equals("H"))
                    imageListH.add(image);
                else
                    imageListV.add(image);
                System.out.println(image);
                index++;
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    private static void setData(String line) {
       numberOfPhotos = Integer.parseInt(line);
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public ArrayList<Image> getImageListH() {
        return imageListH;
    }
    public ArrayList<Image> getImageListV() {
        return imageListV;
    }
}
