package com.guiga.twds.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by guilherme on 30/01/17.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeItemEnum {

    WATER(1, "Water", 4),

    FOOD(2, "Food", 3),

    MEDICATION(3, "Medication", 2),

    AMMUNITION(4, "Ammunition", 1);

    private Integer id;

    private String name;

    private Integer points;

    TypeItemEnum(Integer id, String name, Integer points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    @JsonCreator
    public static TypeItemEnum lookup(final Integer id) {
        for (final TypeItemEnum enumeration : values()) {
            if (enumeration.getId().equals(id)) {
                return enumeration;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
