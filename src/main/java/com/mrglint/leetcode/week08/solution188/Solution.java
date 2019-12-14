package com.mrglint.leetcode.week08.solution188;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author luhuancheng
 * @since 2019-12-09 22:32
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        // 最多可交易2次
        int maxK = k;
        // 由于一次交易需要当天买入、另外一天卖出；有效的限制 k 应该不超过 prices.length / 2, 如果超过可以认为是无限次交易次数。跟「股票买卖问题II」同一个解法
        if (maxK > prices.length / 2) {
            return maxProfit(prices);
        }

        // dp[i][k][0 or 1] i:第i天；k:交易数；
        int[][][] dp = new int[prices.length][maxK + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int kk = maxK; kk >= 1; kk--) {
                // 基本状态
                if (i - 1 == -1) {
                    // 第一天不持股，利润为0
                    dp[i][kk][0] = 0;
                    // 第一天持股, 利润为 -prices[0] 即第一天买入股票的成本
                    dp[i][kk][1] = -prices[0];
                    continue;
                }
                dp[i][kk][0] = Math.max(dp[i - 1][kk][0], dp[i - 1][kk][1] + prices[i]);
                dp[i][kk][1] = Math.max(dp[i - 1][kk][1], dp[i - 1][kk - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][maxK][0];
    }

    /**
     * 允许无数次交易
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices) {
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
