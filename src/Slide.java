public class Slide {
    private Image[] images;

    public Slide(Images[] images) {
        this.images = images;
    }

    private checkIntegriry() {
        boolean allowMulti = true;
        for (int i = 0; i < this.images.length; ++i) {
            if (i == 0 && images[i].getOrientation() == "V") allowMulti = false;
            if (i > 0 && ! allow) throw new RuntimeException("bad Images list -> "+images);
        }
    }

    /**
     * @return the images
     */
    public Image[] getImages() {
        return images;
    }

    @Override
    public String toString() {
        StringBuilder builder;
        for (int i = 0; i < this.images.length; ++i) {
            if (i > 0) builder.append(" ");
            builder.append(images[i].getIndex());
        }
        return builder.toString();
    }

}

