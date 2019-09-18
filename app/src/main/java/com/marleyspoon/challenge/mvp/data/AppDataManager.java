package com.marleyspoon.challenge.mvp.data;


import android.content.Context;

import com.contentful.java.cda.CDAClient;
import com.marleyspoon.challenge.mvp.data.network.ApiHelper;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.data.prefs.PreferencesHelper;
import com.marleyspoon.challenge.mvp.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;
    private final ApiHelper mApiHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper, PreferencesHelper preferencesHelper) {
        mContext = context;
        mApiHelper = apiHelper;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public CDAClient getRecipesFromServer() {
        return mApiHelper.getRecipesFromServer();
    }


    @Override
    public RecipeResponse getRecipeFromPrefs() {
        return mPreferencesHelper.getRecipeFromPrefs();
    }


    @Override
    public void saveRecipeToPrefs(RecipeResponse recipeResponse) {
        mPreferencesHelper.saveRecipeToPrefs(recipeResponse);
    }
}
