package com.guiga.twds.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guiga.twds.base.EntityBase;
import com.guiga.twds.enumeration.TypeItemEnum;

import javax.persistence.*;

/**
 * Created by guilherme on 21/01/17.
 */
@Entity
public class Item extends EntityBase<Long> {

    @Column
    private TypeItemEnum typeItem;

    @Column
    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private People people;

    public TypeItemEnum getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(TypeItemEnum typeItem) {
        this.typeItem = typeItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
