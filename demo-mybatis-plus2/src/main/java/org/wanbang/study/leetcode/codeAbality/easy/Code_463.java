package org.wanbang.study.leetcode.codeAbality.easy;

public class Code_463 {
    public static void main(String[] args) {

    }

    /**
     * 题目都看不懂
     * 个人没有做出来
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 检查左边是否为水域或边界
                    if (j == 0 || grid[i][j - 1] == 0) {
                        ans++;
                    }
                    // 检查右边是否为水域或边界
                    if (j == n - 1 || grid[i][j + 1] == 0) {
                        ans++;
                    }
                    // 检查上边是否为水域或边界
                    if (i == 0 || grid[i - 1][j] == 0) {
                        ans++;
                    }
                    // 检查下边是否为水域或边界
                    if (i == m - 1 || grid[i + 1][j] == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
