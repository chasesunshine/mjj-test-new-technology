package org.wanbang.service;

import java.time.LocalDate;

public interface VisitStatisticsService {
    void recordVisit(String userId);

    long getTotalVisits();

    long getDailyVisits(LocalDate date);
}
