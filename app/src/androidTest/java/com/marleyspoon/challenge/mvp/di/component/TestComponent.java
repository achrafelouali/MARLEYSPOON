package com.marleyspoon.challenge.mvp.di.component;

/**
 * Created by ELOUALI Achraf on 17/09/2019.
 */

import com.marleyspoon.challenge.mvp.di.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ELOUALI.
 */
@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}

