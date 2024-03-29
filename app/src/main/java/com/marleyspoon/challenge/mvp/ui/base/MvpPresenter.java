package com.marleyspoon.challenge.mvp.ui.base;

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);

    void onDetach();
}
