package com.anbu.switchmediaexercise.presentation.view.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.anbu.switchmediaexercise.AcmeApplication;
import com.anbu.switchmediaexercise.R;
import com.anbu.switchmediaexercise.domain.model.CategoryItem;
import com.anbu.switchmediaexercise.presentation.events.EventFragment;
import com.anbu.switchmediaexercise.presentation.view.fragment.AcmeCategoryItemDetailFragment;
import com.anbu.switchmediaexercise.presentation.view.fragment.AcmeCategoryListFragment;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Main Application Screen. This is the app entry point
 */

public class AcmeMainActivity extends AppCompatActivity {

    private Subscription busSubscription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isTablet()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        /*
        Create the Fragment
         */

        if ( savedInstanceState == null) {
            Fragment categoryListFragment = new AcmeCategoryListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .add(R.id.fragmentContainer, categoryListFragment,
                            getResources().getString(R.string.categoryListFragment))
                    .commit();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        autoUnsubBus();
        busSubscription = AcmeApplication.get().bus().toObserverable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Object>() {
                            @Override
                            public void call(Object o) {
                                if (o == null) return;
                                handlerBus(o);
                            }
                        }
                );

    }

    private void handlerBus(@NonNull Object o) {
        if (o instanceof EventFragment) {
            EventFragment event = (EventFragment) o;
            if ( null != event.getCategoryItemdata()) {
                openItemDetail(event.getCategoryItemdata());
            }

        }
    }


    private void autoUnsubBus() {
        if (busSubscription != null && !busSubscription.isUnsubscribed()) {
            busSubscription.unsubscribe();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        autoUnsubBus();
    }

    private void openItemDetail(CategoryItem categoryItem) {

        // Open Fragment Transaction, create a instance of AcmeCategoryItemDetailFragment and
        // open that Fragment

        Bundle bundle = new Bundle();
        bundle.putSerializable(getResources().getString(R.string.itemData), categoryItem);
        Fragment itemDetailFragment = new AcmeCategoryItemDetailFragment();
        itemDetailFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_right_enter,
                R.anim.stay, R.anim.stay, R.anim.exit_animation);
        fragmentTransaction
                .replace(R.id.fragmentContainer, itemDetailFragment,
                        getResources().getString(R.string.itemDetailFragment))
                .addToBackStack(null)
                .commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.is_tablet);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
