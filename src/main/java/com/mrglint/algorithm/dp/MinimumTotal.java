package com.mrglint.algorithm.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-12-06 21:56
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        // 定义状态
        int[] dp = new int[triangle.size() + 1];

        // dp方程（row为第几行，col为第几列）：dp[col] = min(dp[col], dp[col + 1]) + triangle.get(row).get(col)
        /*
        [
             [2],
            [3,4],
           [6,5,7],
          [4,1,8,3]
        ]
         */
        for (int row = triangle.size() - 1; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // dp[col]当前层的第col列的最小步数
                // Math.min(dp[col], dp[col + 1]) 当前层的左右两边的最小步数
                // triangle.get(row).get(col) 当前层当前列的值
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        int i = minimumTotal.minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)));
        System.out.println(i);
    }


}
