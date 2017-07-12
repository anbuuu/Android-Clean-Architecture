package com.anbu.switchmediaexercise;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.anbu.switchmediaexercise.presentation.view.activity.AcmeMainActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Tests to handle item clicks
 */

@RunWith(AndroidJUnit4.class)
public class AcmeMainActivityItemClickTest {

    @Rule
    public ActivityTestRule<AcmeMainActivity> mActivityRule =
            new ActivityTestRule<>(AcmeMainActivity.class);


    @Test
    public void performMediaItemClick() {

     onView(withId(R.id.recycler_view)).perform(
               RecyclerViewActions.actionOnItemAtPosition(0, click()));
     onView(withId(R.id.itemDetailYear)).check(matches(withText("2016")));

    }


    public static Matcher<View> withRecyclerViewId(int recyclerViewId) {
        return allOf(ViewMatchers.isAssignableFrom(RecyclerView.class), withId(recyclerViewId));
    }

    /**
     *  Returns a matcher for an item (cell) in recycler view.
     *
     * @param recyclerViewId
     * @param childViewMatcher
     * @return
     */
    public static Matcher<View> withRecyclerItemView(
            int recyclerViewId,
            Matcher<View> childViewMatcher) {

        return allOf(withParent(withRecyclerViewId(recyclerViewId)),
                (childViewMatcher));
    }

    /**
     * Get the view interaction of the child view inside of a RecyclerView item
     *
     * @param recyclerViewId  resources Id of target RecyclerView
     * @param ItemIdentifier   Matcher for the desired item (cell)
     * @param childViewMatcher  Matcher for the child view in the item
     * @return
     *
     */
    public static ViewInteraction onRecyclerItemView(
            int recyclerViewId,
            Matcher<View> ItemIdentifier,
            Matcher<View> childViewMatcher) {

        Matcher<View> itemView = withRecyclerItemView(recyclerViewId, ItemIdentifier);
        return onView(allOf(isDescendantOfA(itemView), childViewMatcher));
    }

}
