package com.marleyspoon.challenge.mvp.ui.recipes;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDACallback;
import com.contentful.java.cda.CDAEntry;
import com.contentful.java.cda.CDAResource;
import com.marleyspoon.challenge.mvp.BuildConfig;
import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.BasePresenter;
import com.marleyspoon.challenge.mvp.utils.CDAUtils.CDAEntryConverter;
import com.marleyspoon.challenge.mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ELOUALI ACHRAF on 05/09/2019.
 */

public class RecipesPresenter<V extends RecipesMvpView> extends BasePresenter<V>
        implements RecipesMvpPresenter<V> {


    @Inject
    public RecipesPresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onServerSearchRecipes() {
        getMvpView().showShimmer();
        getMvpView().hideTryAgain();
        List<RecipeResponse> recipeList = new ArrayList<>();
        Observable.fromCallable(() -> {
            getDataManager().getRecipesFromServer().fetch(CDAEntry.class)
                    .where("content_type", BuildConfig.CONTENT_TYPE)
                    .all(new CDACallback<CDAArray>() {
                        @Override
                        protected void onSuccess(CDAArray result) {
                            for (CDAResource resource : result.items()) {
                                recipeList.add(CDAEntryConverter.Convert(resource));
                            }

                            if (!isViewAttached()) {
                                return;
                            }

                            if (recipeList.size() > 0) {
                                getMvpView().hideShimmer();
                                getMvpView().hideTryAgain();
                                getMvpView().updateRecipes(recipeList);
                            }

                        }

                        @Override
                        protected void onFailure(Throwable error) {
                            if (!isViewAttached()) {
                                return;
                            }
                            getMvpView().hideShimmer();
                            getMvpView().showTryAgain();
                            getMvpView().onError(error.getMessage());
                        }
                    });
            return false;
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    @Override
    public void onSaveCurrentRecipe(RecipeResponse recipeResponse) {
        getDataManager().saveRecipeToPrefs(recipeResponse);
        getMvpView().showRecipeDetails();
    }
}
