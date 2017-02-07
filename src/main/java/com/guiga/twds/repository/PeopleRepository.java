package com.guiga.twds.repository;

import com.guiga.twds.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guilherme on 21/01/17.
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    People findByName(String name);

    List<People> findByNameLike(String name);

}
