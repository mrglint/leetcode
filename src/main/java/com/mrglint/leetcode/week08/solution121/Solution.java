package com.mrglint.leetcode.week08.solution121;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
 *
 * @author luhuancheng
 * @since 2019-12-08 10:41
 */
public class Solution {

    public int maxProfit(int[] prices) {

        // 初始状态：dp[-1][0] = 0
        int dp0 = 0;
        // 初始状态: dp[-1][1] = 未开始就持股，用负无穷标记不存在该「状态」
        int dp1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp0 = Math.max(dp0, dp1 + prices[i]);
            // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }
}
