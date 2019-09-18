package com.marleyspoon.challenge.mvp.ui.details;

import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.BasePresenter;
import com.marleyspoon.challenge.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;


public class DetailsPresenter<V extends DetailsMvpView> extends BasePresenter<V>
        implements DetailsMvpPresenter<V> {

    @Inject
    public DetailsPresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    @Override
    public void onGetRecipeDetails() {
        RecipeResponse recipe = getDataManager().getRecipeFromPrefs();
        getMvpView().showRecipeDetails(recipe);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }
}
