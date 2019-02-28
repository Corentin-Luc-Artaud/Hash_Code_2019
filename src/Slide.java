import java.util.*;

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

    public List<String> getTags() {
        List<String> tags = new ArrayList<String>();
        for (Image image : images) {
            tags.addAll(Arrays.asList(image.getTags()));
        }
        return tags;
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

    int computeScore(Slide o) {
        Set<String> myTags = new HashSet<>(this.getTags());
        Set<String> otherTags = new HashSet<>(o.getTags());

        Set<String> intersection = new HashSet<>(myTags);
        intersection.retainAll(otherTags);

        Set<String> myprivateother = new HashSet<>(myTags);
        myprivateother.removeAll(otherTags);


        Set<String> otherprivatemy = new HashSet<>(otherTags);
        otherprivatemy.removeAll(myTags);

        int smallest = Math.min(otherprivatemy.size(), Math.min(myprivateother.size(), intersection.size()));
        return smallest;
    }
    boolean candidate(Slide o){
        Set<String> myTags = new HashSet<>(this.getTags());
        Set<String> otherTags = new HashSet<>(o.getTags());

        Set<String> intersection = new HashSet<>(myTags);
        intersection.retainAll(otherTags);

        return intersection.size()>=1;
    }
}
