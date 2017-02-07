package com.guiga.twds.entity;

import com.guiga.twds.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by guilherme on 28/01/17.
 */
@Entity
public class RatingInfected extends EntityBase<Long>{

    @ManyToOne
    private People peopleInfected;

    @ManyToOne
    private People people;

    public People getPeopleInfected() {
        return peopleInfected;
    }

    public void setPeopleInfected(People peopleInfected) {
        this.peopleInfected = peopleInfected;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
