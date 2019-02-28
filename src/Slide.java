import java.util.ArrayList;
import java.util.List;

public class Slide {
    private List<Image> images;

    public Slide() {
        this.images = new ArrayList<>();
    }

    private void checkIntegriry() {
        boolean allowMulti = true;
        for (int i = 0; i < this.images.size(); ++i) {
            if (i == 0 && images.get(i).getOrientation().equals("V")) allowMulti = false;
            if (i > 0 && ! allowMulti) throw new RuntimeException("bad Images list -> "+images);
        }
    }
    public String possibility(){
        if(images.size()==0){
            return "HV";
        }
        else if(images.size()==1) {
            if(images.get(0).getOrientation().equals("V")){
                return "V";
            }
            else{
                return "";
            }
        }
        else{
            return "";
        }
    }
    /**
     * @return the images
     */
    public List<Image> getImages() {
        return images;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.images.size(); ++i) {
            if (i > 0) builder.append(" ");
            builder.append(images.get(i).getIndex());
        }
        System.out.println((builder.toString()));
        return builder.toString();
    }

    public void add(Image image) {
        images.add(image);
    }
}

