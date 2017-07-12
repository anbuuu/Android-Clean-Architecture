
package com.anbu.switchmediaexercise.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Class that represents Category List
 */

public class CategoryList<T> {

    public CategoryList(String category, List<CategoryItem> items) {
        this.category = category;
        this.items = items;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setItems(List<CategoryItem> items) {
        this.items = items;
    }

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("items")
    @Expose
    private List<CategoryItem> items = null;

    public String getCategory() {
        return category;
    }


    public List<CategoryItem> getItems() {
        return items;
    }



}
