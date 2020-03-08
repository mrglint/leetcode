package com.mrglint.leetcode.year2020.dp.knapsack;

/**
 * 背包问题：
 * 有一个背包，它的容量为C（capacity）。现在有n种不同的物品，编号为0 ~ n - 1，其中每一件物品的重量为w(i)，价值为v(i)。问可以向这个背包中放入哪些物品，使得
 * 在不超过背包容量的基础上，物品的总价值最大？
 *
 * 状态定义： f(n, c) 考虑将n个物品放进容量为C的背包，使得价值最大
 * 状态转移：f(i, c) = max( f(i - 1, c), v(i) + f(i - 1, c - w(i)) )
 *
 * @author luhuancheng
 * @since 2020-03-07 22:11
 */
public class Knapsack01DpSolution {

    public int bestValue(int[] values, int[] weight, int maxWeight) {

        int n = values.length;
        if (n == 0) {
            return 0;
        }

        // 状态定义: 将n个物品放进容量为maxWeight的背包中，使得价值最大
        int[][] dp = new int[n][maxWeight + 1];

        // 初始状态
        for (int j = 0; j <= maxWeight; j++) {
            dp[0][j] = j >= weight[0] ? values[0] : 0;
        }

        // 状态递推：分两种情况，放入第 i 个物品；不放入第 i 个物品
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                // 不放入第 i 个物品
                dp[i][j] = dp[i - 1][j];
                // 背包容量足够放入第 i 个物品
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + values[i]);
                }
            }
        }
        return dp[n - 1][maxWeight];
    }

    public static void main(String[] args) {
        Knapsack01DpSolution knapsack01 = new Knapsack01DpSolution();
        int value = knapsack01.bestValue(new int[]{3, 4, 8, 9, 6}, new int[]{2, 2, 4, 3, 6}, 12);
        System.out.println(value);
    }
}
