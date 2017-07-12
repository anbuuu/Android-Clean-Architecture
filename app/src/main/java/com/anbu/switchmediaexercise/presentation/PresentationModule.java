package com.anbu.switchmediaexercise.presentation;

import com.anbu.switchmediaexercise.domain.interactor.AcmeInteractor;
import com.anbu.switchmediaexercise.presentation.presenter.AcmePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module that provides Category List related collaborators
 */
@Module
public class PresentationModule {

    @Provides
    public AcmePresenter provideCategoryListInteractory(AcmeInteractor acmeInteractor) {
        return new AcmePresenter(acmeInteractor);
    }


}
