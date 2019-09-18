package com.marleyspoon.challenge.mvp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.di.ApplicationContext;
import com.marleyspoon.challenge.mvp.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ELOUALI Achraf on 15/09/2019.
 */
@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_RECIPE = "PREF_KEY_RECIPE";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public RecipeResponse getRecipeFromPrefs() {
        return new Gson().fromJson(mPrefs.getString(PREF_KEY_RECIPE, null), RecipeResponse.class);
    }

    @Override
    public void saveRecipeToPrefs(RecipeResponse recipeResponse) {
        //RecipeResponse rp = new RecipeResponse("achraf",null,null,null,null) ;
        mPrefs.edit().putString(PREF_KEY_RECIPE, new Gson().toJson(recipeResponse)).apply();

    }
}
