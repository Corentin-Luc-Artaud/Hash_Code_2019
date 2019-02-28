import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Slide {

    private List<Image> images;

    public Slide() {
        this.images = new ArrayList<>();

    }

    public List<String> getTags(){
        List<String> tags = new ArrayList<String>();


        for (Image image:images){
            tags.addAll(Arrays.asList(image.getTags()));

        }
        return tags;
    }


    private void checkIntegriry() {
        boolean allowMulti = true;
        for (int i = 0; i < this.images.size(); ++i) {
            if (i == 0 && images.get(i).getOrientation().equals("V")) allowMulti = false;
            if (i > 0 && !allowMulti) throw new RuntimeException("bad Images list -> " + images);
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
