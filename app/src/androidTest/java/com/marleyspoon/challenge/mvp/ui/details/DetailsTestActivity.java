package com.marleyspoon.challenge.mvp.ui.details;


import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.marleyspoon.challenge.mvp.R;
import com.marleyspoon.challenge.mvp.TestComponentRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class DetailsTestActivity {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final IntentsTestRule<DetailsActivity> main =
            new IntentsTestRule<>(DetailsActivity.class, false, false);
    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);


    @Before
    public void setup() {

    }

    /**
     * This test will fail if the chef is unknown
     */

    @Test
    public void TestUiComponents() throws Exception {
        main.launchActivity(DetailsActivity.getStartIntent(component.getContext()));
        onView(withId(R.id.recipe_photo_bar))
                .check(matches(isDisplayed()));

        onView(withId(R.id.tv_recipe_title))
                .check(matches(isDisplayed()));

        onView(withId(R.id.tv_recipe_description))
                .check(matches(isDisplayed()));

        onView(withId(R.id.tv_recipe_chef)).check(matches(isDisplayed()));
    }


}