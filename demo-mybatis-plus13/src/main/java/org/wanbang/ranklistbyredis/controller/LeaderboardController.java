package org.wanbang.ranklistbyredis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wanbang.ranklistbyredis.service.LeaderboardService;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    @Resource
    private LeaderboardService leaderboardService; // 排行榜服务

    /**
     * 添加用户到排行榜
     */
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestParam("userId") String userId, @RequestParam("score") double score) {
        leaderboardService.addUserToLeaderboard(userId, score);
        return ResponseEntity.ok("User added to leaderboard.");
    }

    /**
     * 获取前N名用户
     */
    @GetMapping("/top")
    public ResponseEntity<Set<String>> getTopUsers(@RequestParam("topN") int topN) {
        return ResponseEntity.ok(leaderboardService.getTopUsers(topN));
    }

    /**
     * 获取指定用户的排名和得分
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String, Object>> getUserRankAndScore(@PathVariable String userId) {
        return ResponseEntity.ok(leaderboardService.getUserRankAndScore(userId));
    }
}

