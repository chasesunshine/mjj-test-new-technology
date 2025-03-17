package org.wanbang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.ranklistbyredis.service.LeaderboardService;

import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class RankListTest {
    @Autowired
    private LeaderboardService leaderboardService;

    /**
     * 测试排行榜功能
     */
    @Test
    public void testLeaderboard() {
        leaderboardService.addUserToLeaderboard("user1", 100);
        leaderboardService.addUserToLeaderboard("user2", 200);
        leaderboardService.addUserToLeaderboard("user3", 150);

        Set<String> topUsers = leaderboardService.getTopUsers(3);
        System.out.println("Top Users: " + topUsers);

        Map<String, Object> userRankAndScore = leaderboardService.getUserRankAndScore("user1");
        System.out.println("User1 Rank and Score: " + userRankAndScore);
    }

}
