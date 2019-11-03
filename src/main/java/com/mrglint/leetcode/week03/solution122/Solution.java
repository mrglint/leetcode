package com.mrglint.leetcode.week03.solution122;

/**
 * @author luhuancheng
 * @since 2019-11-03 22:08
 */
public class Solution {

    /**
     * 当后一天的价格高于当天价格，买入，在后一天卖出。每一次涨幅都转化为利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                max += (prices[i] - prices[i - 1]);
            }
        }
        return max;
    }
}
