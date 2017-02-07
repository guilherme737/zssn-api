package com.guiga.twds.repository;

import com.guiga.twds.dto.ReportItemDTO;
import com.guiga.twds.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by guilherme on 04/02/17.
 */
@Repository
public interface ReportRepository extends JpaRepository<People, Long> {


    @Query(value = "" +
            "SELECT ( " +
            "   (SELECT COUNT(*) " +
            "      FROM people " +
            "     WHERE infected = :infected) * 100 / COUNT(*) ) " +
            "FROM people", nativeQuery = true)
    Double getPercentageSurvivorsByStatus(@Param("infected") Boolean infected);


    @Query(value = "select new com.guiga.twds.dto.ReportItemDTO(i.typeItem, " +
            "                     CAST(SUM(i.quantity) / CAST((select count(p) " +
            "                                        from People p " +
            "                                        where p.infected = false) AS double) AS double) )" +
            "   FROM Item i " +
            "  GROUP BY i.typeItem " +
            "  ORDER BY i.typeItem ")
    List<ReportItemDTO> getAverageResourceBySurvivor();

    @Query(value = " WITH sumbyitem AS ( " +
            "   select type_item, SUM(quantity), " +
            "       case type_item " +
            "           WHEN 1 THEN " +
            "               SUM(quantity) * 4" +
            "           WHEN 2 THEN" +
            "               SUM(quantity) * 3" +
            "           WHEN 3 THEN" +
            "               SUM(quantity) * 2" +
            "           WHEN 4 THEN" +
            "               SUM(quantity) * 1" +
            "           end as points" +
            "    FROM item i INNER JOIN people p ON p.id = i.people_id" +
            "   GROUP BY type_item" +
            "   ORDER BY type_item)" +
            " SELECT SUM(points) FROM sumbyitem", nativeQuery = true)
    Long getLostPointInfectedSurvivors();
}
