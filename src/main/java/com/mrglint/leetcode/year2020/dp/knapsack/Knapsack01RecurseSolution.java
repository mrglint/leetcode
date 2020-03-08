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
public class Knapsack01RecurseSolution {

    public int bestValue(int[] values, int[] weight, int maxWeight) {
        return bestValue(0, values, weight, maxWeight);
    }

    /**
     * 用 [0, index]的物品，填充容积为weightLimit的背包的最大价值
     *
     */
    private int bestValue(int index, int[] values, int[] weight, int weightLimit) {
        // 全部物品考察完毕 || 背包容量达到上限
        if (index >= values.length || weightLimit <= 0) {
            return 0;
        }

        // index位置的物品，不放入背包，得到的最大价值
        int res = bestValue(index + 1, values, weight, weightLimit);
        if (weightLimit >= weight[index]) {
            res = Math.max(res, values[index] + bestValue(index + 1, values, weight, weightLimit - weight[index]));
        }
        return res;
    }

    public static void main(String[] args) {
        Knapsack01RecurseSolution knapsack01RecurseSolution = new Knapsack01RecurseSolution();
        int value = knapsack01RecurseSolution.bestValue(new int[]{3, 4, 8, 9, 6}, new int[]{2, 2, 4, 3, 6}, 12);
        System.out.println(value);
    }
}
