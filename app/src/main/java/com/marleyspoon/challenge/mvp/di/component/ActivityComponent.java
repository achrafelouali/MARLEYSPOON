package com.marleyspoon.challenge.mvp.di.component;

import com.marleyspoon.challenge.mvp.di.PerActivity;
import com.marleyspoon.challenge.mvp.di.module.ActivityModule;
import com.marleyspoon.challenge.mvp.ui.details.DetailsActivity;
import com.marleyspoon.challenge.mvp.ui.recipes.RecipesActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(DetailsActivity activity);

    void inject(RecipesActivity fragment);
}
