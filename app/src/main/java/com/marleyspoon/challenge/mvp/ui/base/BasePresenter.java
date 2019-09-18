package com.marleyspoon.challenge.mvp.ui.base;


import android.arch.lifecycle.LifecycleObserver;

import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;


public class BasePresenter<V extends MvpView> implements MvpPresenter<V>, LifecycleObserver {

    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;


    private V mMvpView;

    @Inject
    public BasePresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;

    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {

        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }


    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }


}
