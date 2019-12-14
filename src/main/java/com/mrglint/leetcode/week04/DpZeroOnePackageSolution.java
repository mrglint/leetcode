package com.mrglint.leetcode.week04;

/**
 * 把问题分为多个阶段，每个阶段对应一个决策。
 * 记录每个阶段可达的状态集合（去掉重复的），然后通过当前阶段的状态集合，来推导下一个阶段的状态集合，动态往前推进
 *
 * @author luhuancheng
 * @since 2019-11-08 07:27
 */
public class DpZeroOnePackageSolution {
    public int knapsack(int[] weight, int n, int w) {
        // 0 ~ w中重量结果
        boolean[][] states = new boolean[n][w + 1];

        // 第一个物品的决策
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }

        // 考察 第1 ~ n - 1 个物品
        for (int i = 1; i < n; i++) {
            // 0 ~ w 种重量结果
            for (int j = 0; j <= w; j++) {
                // 不装第i个物品，决策时重量保持原有重量状态
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // j <= w - weight[i] 约束最大重量（即 j + weight[i] <= w)
            for (int j = 0; j <= w - weight[i]; j++) {
                // 装第i个物品，决策时重量 = 原有重量状态 + 第i个物品重量
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        // 从最后的状态中，取最接近w的值
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    public int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1];

        // 第一个物品的决策
        // 不放入第一个物品
        states[0] = true;
        // 放入第一个物品
        if (items[0] <= w) {
            states[items[0]] = true;
        }

        // 分别考察第 1 ~ n - 1个物品
        for (int i = 1; i < n; i++) {
            // for循环的意义：
            // 1.假设了第i个物品已经放入背包，从符合限定的所有重量可能中查找（第i个物品重量 + x <= w，即 x <= w - 第i个物品重量)，
            // 如果「可能的重量」存在，那么背包的重量 = 「可能的重量」 + 第i个物品重量；继续考察下一个「可能的重量」直到所有可能考察完毕；
            // 2. 采用「由大到小」的顺序来考察「可能的重量」的原因是：如果「从小到大」来考察，那么可能会导致在「第i个物品」的考察过程中，重复计算，
            // 因为「第i个物品」+ 「可能的重量」会 "创造出"一个在「第i个物品」放入背包前的「可能重量」
            for (int j = w - items[i]; j >= 0; j--) {
                if (states[j]) {
                    System.out.println("states[" + j + "] " + "->" + " state[" + (j + items[i]) + "] = true");
                    states[j + items[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }

    public int knapsack3(int[] weight, int[] value, int n, int w) {
        // n个物品  w + 1种重量
        int[][] states = new int[n][w + 1];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        // 特殊处理
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        // 考察第1 ~ n - 1个物品
        for (int i = 1; i < n; i++) {
            // 不放入第i个物品
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // 在重量符合限制的情况下，放入第i个物品
            for (int j = 0; j <= w - weight[i]; j++) {
                // states[i - 1][j] 即为上一次步骤的状态
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[j];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 从记录的状态值中，找出最大值
        int maxValue = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > maxValue) {
                maxValue = states[n - 1][j];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        DpZeroOnePackageSolution solution = new DpZeroOnePackageSolution();
        int i = solution.knapsack2(new int[]{2, 2, 4, 3, 6}, 5, 9);
        System.out.println(i);
    }
}
