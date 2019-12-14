package com.mrglint.algorithm.dp;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-12-02 22:07
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 一共有 0 ~ amount种金额
        int[] amounts = new int[amount + 1];
        // 假设所有硬币都为1面值，那么最多的硬币个数为amount，这里将硬币个数设置为不可能的个数，即amount + 1个。方便后续比较大小
        Arrays.fill(amounts, amount + 1);
        // 金额0，所需的最小硬币个数为0
        amounts[0] = 0;

        // 对每一种金额进行递推，计算出凑齐该金额的最小硬币个数
        for (int i = 0; i <= amount; i++) {
            // 分别使用每种面值进行计算
            for (int coin : coins) {
                // 金额过小，不足以使用该面值进行拼凑
                if (i - coin < 0) {
                    continue;
                }
                // amounts[i] 当前金额的硬币个数
                // 1 + amounts[i - coin] 当前面值的硬币1个 + (当前金额 - 当前面值)所得的金额的硬币个数
                amounts[i] = Math.min(amounts[i], 1 + amounts[i - coin]);
            }
        }
        return amounts[amount] == amount + 1 ? -1 : amounts[amount];
    }

}
