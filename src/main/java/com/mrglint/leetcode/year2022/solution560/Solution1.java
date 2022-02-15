package com.mrglint.leetcode.year2022.solution560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2022/2/15 7:53 AM
 */
public class Solution1 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();

        // [0, ..., i] - k = 0 的情况
        preSum.put(0, 1);

        int res = 0;
        int sum0Toi = 0;
        for (int num : nums) {
            sum0Toi += num;
            int sum0Toj = sum0Toi - k;

            if (preSum.containsKey(sum0Toj)) {
                res += preSum.get(sum0Toj);
            }
            preSum.put(sum0Toi, preSum.getOrDefault(sum0Toi, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.subarraySum(nums, 2));
    }
}
