import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Output {
  private int number_slides;
  private String fileName = "test";

  public Output(int number_slides) {
    this.number_slides = number_slides;
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
        char orientation = 'H';
        String[] tags  = new String[] {"cat","dog"};
        writer.print(orientation+" "+tags.length);
        for (int i = 0 ; i < tags.length; i++){
          writer.print( " " + tags[i]);
        }

        //writer.print(cutSlice.startX + " " + cutSlice.startY + " " + cutSlice.endX + " " + cutSlice.endY);
        writer.println();
      }
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }




}
