package com.anbu.switchmediaexercise;

import com.anbu.switchmediaexercise.data.AcmeDataModule;
import com.anbu.switchmediaexercise.domain.AcmeDomainModule;
import com.anbu.switchmediaexercise.presentation.PresentationModule;
import com.anbu.switchmediaexercise.presentation.view.fragment.AcmeCategoryListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Dagger Component Injection
 */
@Singleton
@Component(modules = {
        AcmeDataModule.class,
        AcmeDomainModule.class,
        PresentationModule.class
})
public interface ComponentApplication {
    void inject(AcmeCategoryListFragment host);
}
