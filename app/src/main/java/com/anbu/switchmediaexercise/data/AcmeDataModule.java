package com.anbu.switchmediaexercise.data;

import com.anbu.switchmediaexercise.data.net.AcmeService;
import com.anbu.switchmediaexercise.data.net.AcmeServiceImpl;
import com.anbu.switchmediaexercise.data.repository.AcmeRepository;
import com.anbu.switchmediaexercise.data.repository.source.AcmeDataSourceNet;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Modue that provides Service related collaborators
 */
@Module
public class AcmeDataModule {

    @Provides
    @Singleton
    AcmeService provideServiceApi() { return AcmeServiceImpl.getInstance();}

    @Provides
    AcmeDataSourceNet provideCategoryDataSourceNet(AcmeService api) {
        return new AcmeDataSourceNet(api);
    }

    @Provides
    AcmeRepository provideCategoryRepository(AcmeDataSourceNet categoryDataSourceNet) {
        return new AcmeRepository(categoryDataSourceNet);
    }
}
