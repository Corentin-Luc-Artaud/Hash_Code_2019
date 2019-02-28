import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExampleParseur {

    static int numberOfPhotos;
    private static ArrayList<Image> imageList;

    public static void main(String[] args) {
        String file1 = args[0];
        imageList = new ArrayList<>();
        try {
            readFile(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Image image : imageList){
            System.out.println(image);
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
                imageList.add(image);
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
}
