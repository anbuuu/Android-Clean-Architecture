package com.anbu.switchmediaexercise.presentation.view;

import com.anbu.switchmediaexercise.domain.model.CategoryList;
import com.anbu.switchmediaexercise.presentation.view.shared.LoadingView;

import java.util.ArrayList;

/**
 * Created by anbu.ezhilan on 5/07/2017.
 */

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link CategoryList}.
 */
public interface AcmeResultsView extends LoadingView {

    void onCategoryListLoaded(ArrayList<CategoryList> list);
    void onCategoryListLoadError();
}
