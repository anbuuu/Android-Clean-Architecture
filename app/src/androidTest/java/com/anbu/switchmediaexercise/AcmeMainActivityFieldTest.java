package com.anbu.switchmediaexercise;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.anbu.switchmediaexercise.presentation.view.activity.AcmeMainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Main Activity Item Fields Test
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AcmeMainActivityFieldTest {

    @Rule
    public ActivityTestRule<AcmeMainActivity> mActivityRule = new ActivityTestRule(AcmeMainActivity.class);

    @Test
    public void validateTvTitle() {
       onView(allOf(withId(R.id.tvTitle), withText("Pirates of the Caribbean!"))).check(matches(isDisplayed()));
    }


}
