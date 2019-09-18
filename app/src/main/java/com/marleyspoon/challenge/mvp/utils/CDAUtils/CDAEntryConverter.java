package com.marleyspoon.challenge.mvp.utils.CDAUtils;


import com.contentful.java.cda.CDAAsset;
import com.contentful.java.cda.CDAEntry;
import com.contentful.java.cda.CDAResource;
import com.contentful.java.cda.image.ImageOption;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ELOUALI Achraf on 15/09/2019.
 */
public class CDAEntryConverter {

    private static final String photo = "photo";
    private static final String title = "title";
    private static final String description = "description";
    private static final String chef = "chef";
    private static final String name = "name";
    private static final String tags = "tags";

    public static RecipeResponse Convert(CDAResource cdaResource) {
        CDAEntry entry = (CDAEntry) cdaResource;
        return new RecipeResponse(getTitle(entry),
                getDescription(entry),
                getPhoto(entry),
                getTags(entry),
                getChef(entry));
    }

    private static String getPhoto(CDAEntry entry) {
        CDAAsset asset = entry.getField(photo);
        return asset.urlForImageWith(ImageOption.https(), ImageOption.formatOf(ImageOption.Format.png));
    }


    private static String getTitle(CDAEntry entry) {
        return entry.getField(title);
    }

    private static String getDescription(CDAEntry entry) {
        return entry.getField(description);
    }

    private static RecipeResponse.Chef getChef(CDAEntry entry) {
        CDAEntry chefEntry = entry.getField(chef);
        if (chefEntry == null) {
            return null;
        } else {
            return new RecipeResponse.Chef(chefEntry.getField(name));
        }

    }

    private static List<RecipeResponse.Tags> getTags(CDAEntry entry) {
        List<CDAEntry> tagsListEntries = entry.getField(tags);
        List<RecipeResponse.Tags> tagsList = new ArrayList<>();
        if (tagsListEntries != null) {
            for (int i = 0; i < tagsListEntries.size(); i++) {
                CDAEntry TagEntry = tagsListEntries.get(i);
                tagsList.add(new RecipeResponse.Tags(TagEntry.getField(name)));
            }
        }
        return tagsList;
    }
}
