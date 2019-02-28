
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

   @Override
   public String toString(){
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("Index : ").append(this.index).append(" Orientation : ").append(this.orientation);
       stringBuilder.append(" Tags : ");
       for(int i=0;i<tags.length;i++){
           stringBuilder.append(tags[i]+' ');
       }
       return String.valueOf(stringBuilder);
   }
}