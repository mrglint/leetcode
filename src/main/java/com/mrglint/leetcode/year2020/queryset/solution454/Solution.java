package com.mrglint.leetcode.year2020.queryset.solution454;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2020-03-14 08:25
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                res += map.getOrDefault(-A[i]-B[j], 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1});
    }
}
