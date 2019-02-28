
public class Image {
    private int index;
    private String orientation;
    private String[] tags;
    public Image(int index, String orientation, String[] tags) {
        this.tags = tags;
        this.index = index;
        this.orientation = orientation;
    }

   /**
    * @return the index
    */
   public int getIndex() {
       return index;
   }

   /**
    * @return the orientation
    */
   public String getOrientation() {
       return orientation;
   }

   /**
    * @return the tags
    */
   public String[] getTags() {
       return tags;
   }

}