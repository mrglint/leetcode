package com.mrglint.algorithm.dp;

/**
 * @author luhuancheng
 * @since 2019-12-05 22:00
 */
public class ClimbingStairI {

    /**
     *
     * @param n 一共多少级台阶
     * @param steps 一次可以走的阶数
     * @return
     */
    public int climbingStair(int n, int[] steps) {
        // 定义状态：0 ~ n 个台阶，每次可以走i步(i ∈ steps)，对应的不同方法
        int[] dp = new int[n + 1];

        // 0个台阶，有一种走法：不走。。
        dp[0] = 1;

        // 递推每一种台阶总数的走法
        for (int i = 1; i <= n; i++) {
            // 尝试走 step 步
            for (int step : steps) {
                // 如果台阶数不够步数
                if (i - step < 0) {
                    continue;
                }
                // dp[i] = dp[i - step1] + dp[i - step2] + ... + dp[i - stepn]
                dp[i] += dp[i - step];
            }
        }
        return dp[n];
    }
}
