package com.mrglint.leetcode.week08.solution122;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author luhuancheng
 * @since 2019-12-08 10:41
 */
public class Solution {

    public int maxProfit(int[] prices) {
        // dp[-1][0] = 0
        int dp0 = 0;
        // dp[-1][1] = Integer.MIN_VALUE
        int dp1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            // 前一天的利润
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            // temp - prices[i] 当天买入后的利润
            dp1 = Math.max(dp1, temp - prices[i]);
        }
        return dp0;
    }
}
