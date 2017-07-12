package com.anbu.switchmediaexercise.presentation.presenter;

import android.util.Log;

import com.anbu.switchmediaexercise.domain.interactor.AcmeInteractor;
import com.anbu.switchmediaexercise.domain.model.CategoryList;
import com.anbu.switchmediaexercise.presentation.presenter.shared.Presenter;
import com.anbu.switchmediaexercise.presentation.view.AcmeResultsView;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */

public class AcmePresenter implements Presenter<AcmeResultsView>{


    private final AcmeInteractor acmeInteractor;
    private AcmeResultsView view;
    private final String TAG = AcmePresenter.class.getSimpleName();

    @Inject
    public AcmePresenter(AcmeInteractor acmeInteractor) {
        this.acmeInteractor = acmeInteractor;
    }

    /**
     * Loads all Categories
     */
    public void loadCategoryList() {

        view.showLoading();

        getCategoriesList(new Subscriber<ArrayList<CategoryList>>() {
            @Override
            public void onCompleted() {
                view.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "Exception Thrown while Loading List -- " + e.getMessage());
                view.hideLoading();
                view.onCategoryListLoadError();
            }

            @Override
            public void onNext(ArrayList<CategoryList> mediaItemResult) {
                view.onCategoryListLoaded(mediaItemResult);
            }
        });

    }

    /**
     * Retrieves Get Categories List Subscriber
     * @param subscriber
     */
    private void getCategoriesList(Subscriber<ArrayList<CategoryList>> subscriber) {
        this.acmeInteractor.execute(null, subscriber);
    }

    @Override
    public void bind(AcmeResultsView view) {
        this.view = view;
    }
}
