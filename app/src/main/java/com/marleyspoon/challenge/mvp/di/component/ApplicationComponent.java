package com.marleyspoon.challenge.mvp.di.component;

import android.app.Application;
import android.content.Context;

import com.marleyspoon.challenge.mvp.MvpApp;
import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.di.ApplicationContext;
import com.marleyspoon.challenge.mvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}