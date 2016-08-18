package com.jipata.thegumza.jipata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Thegumza on 8/15/2016.
 */
public class DailyRubber {

    /**
     * dataDate : 17 สิงหาคม  2559
     * local_price : 51.60
     * latex_price : 49.50
     * global_price : 53.79
     * smoke_sheet_price : 55.18
     */

    @SerializedName("dataDate")
    private String dataDate;
    @SerializedName("local_price")
    private String localPrice;
    @SerializedName("latex_price")
    private String latexPrice;
    @SerializedName("global_price")
    private String globalPrice;
    @SerializedName("smoke_sheet_price")
    private String smokeSheetPrice;

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getLocalPrice() {
        return localPrice;
    }

    public void setLocalPrice(String localPrice) {
        this.localPrice = localPrice;
    }

    public String getLatexPrice() {
        return latexPrice;
    }

    public void setLatexPrice(String latexPrice) {
        this.latexPrice = latexPrice;
    }

    public String getGlobalPrice() {
        return globalPrice;
    }

    public void setGlobalPrice(String globalPrice) {
        this.globalPrice = globalPrice;
    }

    public String getSmokeSheetPrice() {
        return smokeSheetPrice;
    }

    public void setSmokeSheetPrice(String smokeSheetPrice) {
        this.smokeSheetPrice = smokeSheetPrice;
    }
}
