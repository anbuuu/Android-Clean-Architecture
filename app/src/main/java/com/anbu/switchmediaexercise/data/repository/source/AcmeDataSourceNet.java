package com.anbu.switchmediaexercise.data.repository.source;

import com.anbu.switchmediaexercise.data.net.AcmeService;
import com.anbu.switchmediaexercise.domain.model.CategoryList;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

/**
 * {@link AcmeDataSource} implementation
 */

public class AcmeDataSourceNet implements AcmeDataSource {

    AcmeService api;

    @Inject
    public AcmeDataSourceNet(AcmeService api) {
        this.api = api;
    }


    @Override
    public Observable<ArrayList<CategoryList>> categories() {
        return this.api.getMediaListData();
    }

}
