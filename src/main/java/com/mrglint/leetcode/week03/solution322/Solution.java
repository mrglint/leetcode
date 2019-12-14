package com.mrglint.leetcode.week03.solution322;

import java.util.HashMap;
import java.util.Map;

/**
 * 贪心法无法求解该问题
 *
 * @author luhuancheng
 * @since 2019-11-03 16:40
 */
public class Solution {
    /**
     * 分治、回溯角度思考：假设硬币为[10, 9, 1]，兑换总额为18，那么问题可以转换为f(18) = min(f(18 - 10), f(18 - 9), f(18 - 1)) 直到硬币兑换成功
     * 傻递归，leetcode 超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            // 分解为子问题
            int subProb = coinChange1(coins, amount - coin);
            // 子问题无解，回溯上层
            if (subProb == -1) {
                continue;
            }
            count = Math.min(count, subProb + 1);
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    /**
     * 动态规划解法: 原问题的解由子问题的最优解构成
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeDp(int[] coins, int amount) {
        int[] dpTable = new int[amount + 1];
        // 初始化
        for (int i = 0; i < dpTable.length; i++) {
            dpTable[i] = amount + 1;
        }
        // 特殊处理，选择0个硬币时的总额为0
        dpTable[0] = 0;

        // 考察1 ~ amount种可能的总额
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dpTable[i] = Math.min(dpTable[i], dpTable[i - coin] + 1);
                }
            }
        }
        return dpTable[amount] > amount ? -1 : dpTable[amount];
    }

    /**
     * 加缓存递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> cache = new HashMap<>();
        return coinChange(coins, amount, cache);
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (amount == 0) {
            return 0;
        }
        // 从缓存中获取结果
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }
        // 计算f(amount) : 将问题转换为f(amount) = min(f(amount - coin1), f(amount - coin2))
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int subProb = coinChange(coins, amount - coin, cache);
            if (subProb == -1) {
                continue;
            }
            count = Math.min(count, subProb + 1);
        }
        // 计算结果放入缓存
        cache.put(amount, count == Integer.MAX_VALUE ? - 1 : count);
        return cache.get(amount);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.coinChangeDp(new int[]{10, 9, 1}, 18);
        System.out.println(i);
    }

}
