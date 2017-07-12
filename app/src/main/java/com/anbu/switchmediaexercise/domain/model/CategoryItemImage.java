
package com.anbu.switchmediaexercise.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class that represents Individual Category Item Image from the Category Item Data
 */

public class CategoryItemImage {

    @SerializedName("portrait")
    @Expose
    private String portrait;
    @SerializedName("landscape")
    @Expose
    private String landscape;

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public CategoryItemImage withPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public CategoryItemImage withLandscape(String landscape) {
        this.landscape = landscape;
        return this;
    }


}
