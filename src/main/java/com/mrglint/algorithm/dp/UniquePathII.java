package com.mrglint.algorithm.dp;

/**
 * @author luhuancheng
 * @since 2019-12-03 21:33
 */
public class UniquePathII {

    /**
     * [
     *   [0,0,0],
     *   [0,1,1],
     *   [0,0,0],
     *   [0,0,0]
     * ]
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];

        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        if (dp[0] == 0) {
            return 0;
        }
        // 遍历每一行数据
        for (int[] rowData : obstacleGrid) {
            for (int i = 0; i < cols; i++) {
                if (rowData[i] == 1) {
                    // 如果存在障碍物，路径数为0
                    dp[i] = 0;
                } else if (i > 0){
                    // 如果不是第一列的坐标。该坐标的路径数为：该坐标左边的坐标的路径数 + 该坐标上边的坐标的路径数。
                    dp[i] = dp[i] + dp[i - 1];
                }
            }
        }
        return dp[cols - 1];
    }
}
