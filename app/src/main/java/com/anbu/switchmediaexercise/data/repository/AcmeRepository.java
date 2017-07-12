package com.anbu.switchmediaexercise.data.repository;

import com.anbu.switchmediaexercise.data.repository.source.AcmeDataSource;
import com.anbu.switchmediaexercise.data.repository.source.AcmeDataSourceNet;
import com.anbu.switchmediaexercise.domain.model.CategoryList;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * {@link AcmeRepository} for retrieving Category List
 */

@Singleton
public class AcmeRepository {

    private AcmeDataSource acmeDataSourceNet;

    /**
     * Constructs a {@link AcmeRepository}
     * @param categoryDataSource
     */
    @Inject
    public AcmeRepository(AcmeDataSourceNet categoryDataSource) {
        this.acmeDataSourceNet = categoryDataSource;
    }

    public Observable<ArrayList<CategoryList>> getCategoriesList() {
        return acmeDataSourceNet.categories();
    }

}
