
package com.anbu.switchmediaexercise.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Class that represents Individual Category Item from the List
 */
public class CategoryItem implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("images")
    @Expose
    private CategoryItemImage images;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryItem withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public CategoryItem withYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryItem withDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryItemImage getImages() {
        return images;
    }

    public void setImages(CategoryItemImage images) {
        this.images = images;
    }

    public CategoryItem withImages(CategoryItemImage images) {
        this.images = images;
        return this;
    }

}
