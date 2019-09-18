package com.marleyspoon.challenge.mvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.google.android.flexbox.FlexboxLayoutManager;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.di.ActivityContext;
import com.marleyspoon.challenge.mvp.di.PerActivity;
import com.marleyspoon.challenge.mvp.ui.details.DetailsMvpPresenter;
import com.marleyspoon.challenge.mvp.ui.details.DetailsMvpView;
import com.marleyspoon.challenge.mvp.ui.details.DetailsPresenter;
import com.marleyspoon.challenge.mvp.ui.details.TagsAdapter;
import com.marleyspoon.challenge.mvp.ui.recipes.RecipesAdapter;
import com.marleyspoon.challenge.mvp.ui.recipes.RecipesMvpPresenter;
import com.marleyspoon.challenge.mvp.ui.recipes.RecipesMvpView;
import com.marleyspoon.challenge.mvp.ui.recipes.RecipesPresenter;
import com.marleyspoon.challenge.mvp.utils.rx.AppSchedulerProvider;
import com.marleyspoon.challenge.mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PerActivity
    DetailsMvpPresenter<DetailsMvpView> provideLoginPresenter(
            DetailsPresenter<DetailsMvpView> presenter) {
        return presenter;
    }


    @Provides
    RecipesMvpPresenter<RecipesMvpView> provideDoctorMvpPresenter(
            RecipesPresenter<RecipesMvpView> presenter) {
        return presenter;
    }


    @Provides
    RecipesAdapter provideDoctorAdapter() {
        return new RecipesAdapter(new ArrayList<RecipeResponse>());
    }


    @Provides
    TagsAdapter provideTagsAdapter() {
        return new TagsAdapter(new ArrayList<RecipeResponse.Tags>());
    }


    @Provides
    GridLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new GridLayoutManager(activity, 1);
    }


    @Provides
    FlexboxLayoutManager provideLinearFlexLayoutManager(AppCompatActivity activity) {
        return new FlexboxLayoutManager(activity);
    }
}
