package com.anbu.switchmediaexercise;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.anbu.switchmediaexercise.presentation.view.activity.AcmeMainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Test to ensure Fragment view is present
 */

@MediumTest
@RunWith(AndroidJUnit4.class)
public class RecyclerViewValidationTest {

    @Rule
    public ActivityTestRule<AcmeMainActivity> rule =
            new ActivityTestRule<>(AcmeMainActivity.class);

    @Test
    public void ensureFragmentViewIsPresent() throws Exception {

        AcmeMainActivity activity = rule.getActivity();
        View viewbyId = activity.findViewById(R.id.fragmentContainer);
        assertThat(viewbyId, notNullValue());

        View verticalRecyclerViewId = activity.findViewById(R.id.recycler_view);
        assertThat(verticalRecyclerViewId, notNullValue());
        assertThat(verticalRecyclerViewId, instanceOf(RecyclerView.class));

    }

}
