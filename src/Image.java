import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return index == image.index &&
                Objects.equals(orientation, image.orientation) &&
                Arrays.equals(tags, image.tags);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(index, orientation);
        result = 31 * result + Arrays.hashCode(tags);
        return result;
    }
}