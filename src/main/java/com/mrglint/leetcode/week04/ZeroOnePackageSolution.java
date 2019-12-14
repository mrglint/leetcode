package com.mrglint.leetcode.week04;

/**
 * 0-1背包问题，给定一组物品，从中选定n个物品出来放进背包，且背包的最大重量为w。
 * 选取出来的n个物品组成的最大容量是多少。
 *
 * @author luhuancheng
 * @since 2019-11-06 13:37
 */
public class ZeroOnePackageSolution {

    private int result = Integer.MIN_VALUE;

    public int pack(int[] weights, int maxWeight, int maxCount) {
        pack(weights, maxWeight, maxCount, 0, 0);
        return result;
    }

    private void pack(int[] weights, int maxWeight, int maxCount, int count, int weight) {
        if (count == maxCount || weight == maxWeight) {
            result = Math.max(result, weight);
            return;
        }
        // 不选择当前物品
        pack(weights, maxWeight, maxCount, count + 1, weight);
        // 执行到此处时，就是回溯
        if (weight + weights[count] <= maxWeight) {
            // 如果重量不超限制，选择当前物品
            pack(weights, maxWeight, maxCount, count + 1, weight + weights[count]);
        }
    }

    public static void main(String[] args) {
        ZeroOnePackageSolution solution = new ZeroOnePackageSolution();
        int[] weights = new int[]{2, 2, 4, 6, 3};
        int maxCount = 5;
        int maxWeight = 9;
        int w = solution.pack(weights, maxWeight, maxCount);
        System.out.println(w);
    }

}
