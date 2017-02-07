package com.guiga.twds.repository;

import com.guiga.twds.entity.RatingInfected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by guilherme on 28/01/17.
 */
@Repository
public interface RatingInfectedRepository extends JpaRepository<RatingInfected, Long> {


    @Query("SELECT COUNT(*) FROM RatingInfected WHERE userInfectedId = :id ")
    Boolean infected(@Param("id") Long id);
}
