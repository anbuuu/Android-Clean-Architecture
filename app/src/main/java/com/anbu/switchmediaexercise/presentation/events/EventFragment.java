package com.anbu.switchmediaexercise.presentation.events;

import com.anbu.switchmediaexercise.domain.model.CategoryItem;

/**
 * Created by anbu.ezhilan on 9/07/2017.
 */

/**
 * Class to capture the new Fragment Event
 */
public class EventFragment {

    public CategoryItem getCategoryItemdata() {
        return categoryItemdata;
    }

    private CategoryItem categoryItemdata;

    public EventFragment(CategoryItem onClickData) {
        categoryItemdata = onClickData;

    }

}
