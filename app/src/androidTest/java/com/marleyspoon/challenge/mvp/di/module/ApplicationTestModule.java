package com.marleyspoon.challenge.mvp.di.module;

/**
 * Created by ELOUALI Achraf on 17/09/2019.
 */

import android.app.Application;
import android.content.Context;

import com.marleyspoon.challenge.mvp.BuildConfig;
import com.marleyspoon.challenge.mvp.R;
import com.marleyspoon.challenge.mvp.data.AppDataManager;
import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.data.network.ApiHelper;
import com.marleyspoon.challenge.mvp.data.network.AppApiHelper;
import com.marleyspoon.challenge.mvp.data.prefs.AppPreferencesHelper;
import com.marleyspoon.challenge.mvp.data.prefs.PreferencesHelper;
import com.marleyspoon.challenge.mvp.di.ApplicationContext;
import com.marleyspoon.challenge.mvp.di.PreferenceInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ELOUALI.
 */
@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return BuildConfig.PREF_NAME;
    }


    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }


    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Avenir-Next-Font/AvenirNextLTPro-Regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }


}
