package com.mrglint.leetcode.week01.solution15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-10-20 08:59
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> resultSub = new ArrayList<>();
                        resultSub.add(nums[i]);
                        resultSub.add(nums[j]);
                        resultSub.add(nums[k]);
                        result.add(resultSub);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(data);
        System.out.println(lists);
    }

}
