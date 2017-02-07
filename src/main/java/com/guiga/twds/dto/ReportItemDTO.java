package com.guiga.twds.dto;

import com.guiga.twds.enumeration.TypeItemEnum;

/**
 * Created by guilherme on 05/02/17.
 */
public class ReportItemDTO {

    private TypeItemEnum item;

    private Double avgQuantity;

    public ReportItemDTO() {
    }

    public ReportItemDTO(TypeItemEnum item, Double avgQuantity) {
        this.item = item;
        this.avgQuantity = avgQuantity;
    }

    public TypeItemEnum getItem() {
        return item;
    }

    public void setItem(TypeItemEnum item) {
        this.item = item;
    }

    public Double getAvgQuantity() {
        return avgQuantity;
    }

    public void setAvgQuantity(Double avgQuantity) {
        this.avgQuantity = avgQuantity;
    }
}
