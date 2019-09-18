package com.marleyspoon.challenge.mvp.ui.details;


import com.marleyspoon.challenge.mvp.di.PerActivity;
import com.marleyspoon.challenge.mvp.ui.base.MvpPresenter;


@PerActivity
public interface DetailsMvpPresenter<V extends DetailsMvpView> extends MvpPresenter<V> {
    void onGetRecipeDetails();
}
