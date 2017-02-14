package com.guiga.twds.service;

import com.guiga.twds.dto.PeopleDTO;
import com.guiga.twds.entity.People;
import com.guiga.twds.entity.RatingInfected;
import com.guiga.twds.repository.PeopleRepository;
import com.guiga.twds.repository.RatingInfectedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilherme on 21/01/17.
 */
@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private RatingInfectedRepository ratingInfectedRepository;

    @Transactional(readOnly = true)
    public List<People> findAll(){

        return peopleRepository.findAll();

    }

    @Transactional(readOnly = true)
    public List<People> findByName(String name){
        return peopleRepository.findByNameLike(name);
    }

    @Transactional(readOnly = true)
    public People findOne(Long id){
        return peopleRepository.findOne(id);
    }

    @Transactional
    public void save(People people){

        people.getItems().stream().forEach(item -> {
            item.setPeople(people);
        });

        peopleRepository.save(people);
    }

    @Transactional
    public void setInfected(Long userIdInfected, Long userId) {

        People peopleInfected = peopleRepository.findOne(userIdInfected);

        People people = peopleRepository.findOne(userId);

        RatingInfected ratingInfected = new RatingInfected();

        ratingInfected.setPeopleInfected(peopleInfected);

        ratingInfected.setPeopleInfected(people);

        ratingInfectedRepository.save(ratingInfected);

    }

    @Transactional
    public void updateLocation(PeopleDTO dto) {

        People people = peopleRepository.findOne(dto.getId());

        people.setLatitude(dto.getLatitude());

        people.setLongitude(dto.getLongitude());

        peopleRepository.save(people);
    }


    @Transactional(readOnly = true)
    public Boolean isInfected(Long userId) {

        return ratingInfectedRepository.infected(userId);
    }

}
