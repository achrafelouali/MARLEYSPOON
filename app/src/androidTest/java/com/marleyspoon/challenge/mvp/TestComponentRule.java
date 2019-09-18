package com.marleyspoon.challenge.mvp;

import android.content.Context;

import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.di.component.DaggerTestComponent;
import com.marleyspoon.challenge.mvp.di.component.TestComponent;
import com.marleyspoon.challenge.mvp.di.module.ApplicationTestModule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by ELOUALI.
 */

public class TestComponentRule implements TestRule {

    private TestComponent mTestComponent;
    private Context mContext;

    public TestComponentRule(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public DataManager getDataManager() {
        return mTestComponent.getDataManager();
    }

    private void setupDaggerTestComponentInApplication() {
        MvpApp application = ((MvpApp) mContext.getApplicationContext());
        mTestComponent = DaggerTestComponent.builder()
                .applicationTestModule(new ApplicationTestModule(application))
                .build();
        application.setComponent(mTestComponent);
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    setupDaggerTestComponentInApplication();
                    base.evaluate();
                } finally {
                    mTestComponent = null;
                }
            }
        };
    }
}
