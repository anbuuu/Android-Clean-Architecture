package com.anbu.switchmediaexercise.domain;

import com.anbu.switchmediaexercise.data.repository.AcmeRepository;
import com.anbu.switchmediaexercise.domain.interactor.AcmeInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Module to provide Interactor to outer Layer
 */

@Module
public class AcmeDomainModule {

    @Provides
    AcmeInteractor provideCategoryListInteractor(AcmeRepository acmeRepository) {
        return new AcmeInteractor(acmeRepository);
    }
}
