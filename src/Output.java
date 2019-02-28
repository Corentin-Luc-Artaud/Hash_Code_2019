import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Output {
    private int number_slides;
    private String fileName = "test";
    private List<Slide> slides;

    public Output(int number_slides, List<Slide> slideList) {
        this.number_slides = number_slides;
        this.slides = slideList;
        printOutput();
    }


    //ArrayList<Slice> cutSlices = new ArrayList<>();


    public void printOutput() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(this.fileName + ".out", "UTF-8");

            int noOfSlices = number_slides;

            writer.print(noOfSlices);  // First line
            writer.println();

            //=================


            for (int j = 0; j < number_slides; j++) {
                //Slide side = pizzaCutter.cutSlices.get(j);
                // Get tags and orientation
                Slide slide = slides.get(j);
                writer.print(slide.toString()+'\n');
            }


            //writer.print(cutSlice.startX + " " + cutSlice.startY + " " + cutSlice.endX + " " + cutSlice.endY);
            writer.println();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        writer.close();
    }
}

