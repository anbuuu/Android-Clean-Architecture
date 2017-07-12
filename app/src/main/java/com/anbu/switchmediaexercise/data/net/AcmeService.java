package com.anbu.switchmediaexercise.data.net;

import com.anbu.switchmediaexercise.domain.model.CategoryList;

import java.util.ArrayList;

import retrofit2.http.GET;
import rx.Observable;


/**
 * RestApi for retrieving data from the network.
 */

public interface AcmeService {

    /**
     * Retrieves an {@link Observable} which will emit a List of {@link CategoryList}.
     */
    @GET(".")
    Observable<ArrayList<CategoryList>> getMediaListData();

}
