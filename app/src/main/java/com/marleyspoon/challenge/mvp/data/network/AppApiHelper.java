package com.marleyspoon.challenge.mvp.data.network;


import com.contentful.java.cda.CDAClient;
import com.marleyspoon.challenge.mvp.BuildConfig;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }

    @Override
    public CDAClient getRecipesFromServer() {
        return CDAClient.builder()
                .setToken(BuildConfig.CONTENTFUL_ACCESS_TOKEN)
                .setSpace(BuildConfig.CONTENTFUL_SPACE_ID)
                .build();
    }
}

