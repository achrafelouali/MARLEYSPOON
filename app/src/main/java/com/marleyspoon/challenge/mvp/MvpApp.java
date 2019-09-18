package com.marleyspoon.challenge.mvp;

import android.app.Application;

import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.di.component.ApplicationComponent;
import com.marleyspoon.challenge.mvp.di.component.DaggerApplicationComponent;
import com.marleyspoon.challenge.mvp.di.module.ApplicationModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;
    @Inject
    CalligraphyConfig mCalligraphyConfig;


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
        CalligraphyConfig.initDefault(mCalligraphyConfig);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
