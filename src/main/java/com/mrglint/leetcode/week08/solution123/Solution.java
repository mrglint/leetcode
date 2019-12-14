package com.mrglint.leetcode.week08.solution123;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author luhuancheng
 * @since 2019-12-09 22:32
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        // 穷举出k = 1；k = 2的状态
        // dp[i][2][0] = max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i])
        // dp[i][2][1] = max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i])
        // dp[i][1][0] = max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i])
        // dp[i][1][1] = max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]) = max(dp[i - 1][1][1], -prices[i])

        int dpi10 = 0;
        int dpi11 = Integer.MIN_VALUE;
        int dpi20 = 0;
        int dpi21 = Integer.MIN_VALUE;

        for (int price : prices) {
            dpi20 = Math.max(dpi20, dpi21 + price);
            dpi21 = Math.max(dpi21, dpi10 - price);
            dpi10 = Math.max(dpi10, dpi11 + price);
            dpi11 = Math.max(dpi11, -price);
        }
        return dpi20;
    }
}
