package com.marleyspoon.challenge.mvp.data.prefs;

import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;

/**
 * Created by ELOUALI Achraf on 15/09/2019.
 */
public interface PreferencesHelper {

    RecipeResponse getRecipeFromPrefs();

    void saveRecipeToPrefs(RecipeResponse recipeResponse);
}