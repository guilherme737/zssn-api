package com.guiga.twds.service;

import com.guiga.twds.dto.ReportItemDTO;
import com.guiga.twds.entity.People;
import com.guiga.twds.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilherme on 21/01/17.
 */
@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Transactional(readOnly = true)
    public Double getPercentageInfectedSurvivors() {
        return reportRepository.getPercentageSurvivorsByStatus(Boolean.TRUE);
    }

    @Transactional(readOnly = true)
    public Double getPercentageNonInfectedSurvivors() {
        return reportRepository.getPercentageSurvivorsByStatus(Boolean.FALSE);
    }

    @Transactional(readOnly = true)
    public List<ReportItemDTO> getAverageResourceBySurvivor() {
        return reportRepository.getAverageResourceBySurvivor();
    }

    @Transactional(readOnly = true)
    public Long getLostPointInfectedSurvivors() {

        return reportRepository.getLostPointInfectedSurvivors();
    }
}
