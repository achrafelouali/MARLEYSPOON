package com.marleyspoon.challenge.mvp.ui.recipes;

/**
 * Created by ELOUALI Achraf on 17/09/2019.
 */

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

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
public class RecipesTestActivity {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final IntentsTestRule<RecipesActivity> main =
            new IntentsTestRule<>(RecipesActivity.class, false, false);
    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);
    Activity activity;

    @Before
    public void setup() {

    }


    @Test
    public void TestUiComponents() throws Exception {
        activity = main.launchActivity(RecipesActivity.getStartIntent(component.getContext()));
        onView(withId(R.id.shimmer_layout))
                .check(matches(isDisplayed()));

        /**
         * We a better solution could use IdlingResource instead
         */

        Thread.sleep(5000);
        activity = main.launchActivity(RecipesActivity.getStartIntent(component.getContext()));
        onView(withId(R.id.recipe_recycler_view))
                .check(matches(isDisplayed()));

        RecyclerView recyclerView = activity.findViewById(R.id.recipe_recycler_view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        onView(withId(R.id.recipe_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(itemCount - 1));
    }


}