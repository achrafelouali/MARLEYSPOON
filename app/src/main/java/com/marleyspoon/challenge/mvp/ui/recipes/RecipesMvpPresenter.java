package com.marleyspoon.challenge.mvp.ui.recipes;

import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.MvpPresenter;

/**
 * Created by ELOUALI ACHRAF on 05/09/2019.
 */

public interface RecipesMvpPresenter<V extends RecipesMvpView>
        extends MvpPresenter<V> {

    void onServerSearchRecipes();

    void onSaveCurrentRecipe(RecipeResponse recipeResponse);

}


