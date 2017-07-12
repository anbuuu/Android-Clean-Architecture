package com.anbu.switchmediaexercise.domain.interactor;

import com.anbu.switchmediaexercise.data.repository.AcmeRepository;
import com.anbu.switchmediaexercise.domain.model.CategoryList;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

/**
 * This class is an implementation of {@link Interactor} that represents a use case for
 * retrieving a collection of all {@link CategoryList}
 */

public class AcmeInteractor extends
        Interactor<CategoryList, Void> {

    private AcmeRepository acmeRepository;

    @Inject
    public AcmeInteractor(AcmeRepository acmeRepository) {
        this.acmeRepository = acmeRepository;
    }

    @Override
    protected Observable<ArrayList<CategoryList>> createObservable(Void aVoid) {
        return this.acmeRepository.getCategoriesList();
    }

}
