package org.wanbang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.service.VisitStatisticsService;

import java.time.LocalDate;

@RestController
public class VisitController {

    @Autowired
    private VisitStatisticsService visitStatisticsService;

    /**
     * 记录用户访问
     *
     * @param userId
     * @return
     */
    @GetMapping("/visit")
    public String visit(@RequestParam(required = false) String userId) {
        visitStatisticsService.recordVisit(userId);
        return "Visit recorded";
    }

    /**
     * 获取总访问量
     *
     * @return
     */
    @GetMapping("/stats/total")
    public long getTotalVisits() {
        return visitStatisticsService.getTotalVisits();
    }

    /**
     * 获取某天的访问量
     *
     * @param date
     * @return
     */
    @GetMapping("/stats/daily")
    public long getDailyVisits(@RequestParam String date) {
        return visitStatisticsService.getDailyVisits(LocalDate.parse(date));
    }
}