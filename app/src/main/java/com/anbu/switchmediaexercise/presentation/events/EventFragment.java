package com.anbu.switchmediaexercise.presentation.events;

import com.anbu.switchmediaexercise.domain.model.CategoryItem;

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
