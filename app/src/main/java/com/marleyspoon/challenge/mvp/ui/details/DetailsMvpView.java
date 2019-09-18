package com.marleyspoon.challenge.mvp.ui.details;

import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.MvpView;


public interface DetailsMvpView extends MvpView {
    void showRecipeDetails(RecipeResponse recipeResponse);
}
