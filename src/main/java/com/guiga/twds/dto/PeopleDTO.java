package com.guiga.twds.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by guilherme on 21/01/17.
 */
@ApiModel
public class PeopleDTO {

    private Long id;

    @ApiModelProperty(required = true)
    @NotNull(message = "CAMPO_OBRIGATORIO")
    private BigDecimal latitude;

    @NotNull(message = "CAMPO_OBRIGATORIO")
    private BigDecimal longitude;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
