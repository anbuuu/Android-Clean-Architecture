package com.anbu.switchmediaexercise.data.repository.source;

import com.anbu.switchmediaexercise.domain.model.CategoryList;

import java.util.ArrayList;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */

public interface AcmeDataSource {

    /**
     * Retrieves an {@link Observable} which will emit a List of {@link CategoryList}.
     */
    Observable<ArrayList<CategoryList>> categories();

}
