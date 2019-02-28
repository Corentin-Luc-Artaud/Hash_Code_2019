import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagDictionnary {

    Map<String, ArrayList<Image>> tag_dict_image = new HashMap<String, ArrayList<Image>>();
    Map<String, ArrayList<Slide>> tag_dict_slide = new HashMap<String, ArrayList<Slide>>();


    public void addTag2(ArrayList<Slide> slides) {
        for (Slide slide : slides) {
            addTag(slide);
        }
    }


    public void addTag(Slide slide) {
        String[] tags = slide.getTags().toArray(new String[0]);

        for (String tag : tags) {
            List<Slide> itemsList = tag_dict_slide.get(tag);

            if (itemsList == null) {
                itemsList = new ArrayList<Slide>();
                itemsList.add(slide);
                tag_dict_slide.put(tag, (ArrayList<Slide>) itemsList);
            } else {
                // add if item is not already in list
                if (!itemsList.contains(slide)) itemsList.add(slide);
            }


        }
    }


    public void addTag(ArrayList<Image> images) {
        for (Image image : images) {
            addTag(image);
        }
    }

    public void addTag(Image image) {
        String[] tags = image.getTags();

        for (String tag : tags) {
            List<Image> itemsList = tag_dict_image.get(tag);

            if (itemsList == null) {
                itemsList = new ArrayList<Image>();
                itemsList.add(image);
                tag_dict_image.put(tag, (ArrayList<Image>) itemsList);
            } else {
                // add if item is not already in list
                if (!itemsList.contains(image)) itemsList.add(image);
            }

        }
    }


}



