package com.guiga.twds.api;

import com.guiga.twds.dto.ReportItemDTO;
import com.guiga.twds.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by guilherme on 21/01/17.
 */
@RestController
@RequestMapping(value = "/report")
public class ReportAPI {

    @Autowired
    private ReportService reportService;


    @RequestMapping(value = "/percentage-infected-survivors", method = RequestMethod.GET)
    public Double getPercentageInfectedSurvivors() {
        return reportService.getPercentageInfectedSurvivors();
    }

    @RequestMapping(value = "/percentage-non-infected-survivors", method = RequestMethod.GET)
    public Double getPercentageNonInfectedSurvivors() {
        return reportService.getPercentageNonInfectedSurvivors();
    }

    @RequestMapping(value = "/average-resource-by-survivor", method = RequestMethod.GET)
    public List<ReportItemDTO> getAverageResourceBySurvivor() {
        return reportService.getAverageResourceBySurvivor();
    }

    @RequestMapping(value = "/lost-point-infected-survivors", method = RequestMethod.GET)
    public Long getLostPointInfectedSurvivors() {
        return reportService.getLostPointInfectedSurvivors();
    }
}
