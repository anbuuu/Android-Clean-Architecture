package com.anbu.switchmediaexercise.presentation.view;

import com.anbu.switchmediaexercise.domain.model.CategoryItem;
import com.anbu.switchmediaexercise.presentation.view.shared.LoadingView;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a Item profile.
 */

public interface AcmeItemDetailView extends LoadingView {

    void onItemDetailLoaded(CategoryItem categoryItem);
    void onItemDetailLoadError();
}
