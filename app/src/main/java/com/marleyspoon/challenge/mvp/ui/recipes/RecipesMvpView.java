package com.marleyspoon.challenge.mvp.ui.recipes;

import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by ELOUALI ACHRAF on 05/09/2019.
 */

public interface RecipesMvpView extends MvpView {

    void updateRecipes(List<RecipeResponse> DoctorList);

    void showRecipeDetails();

    void showShimmer();

    void hideShimmer();

    void showTryAgain();

    void hideTryAgain();

}
