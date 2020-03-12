package com.mrglint.leetcode.year2020.queryset.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序 + 双指针
 *
 * @author luhuancheng
 * @since 2020-03-12 07:47
 */
public class TwoPointSolution {

    public List<List<Integer>> threeSum(int[] nums) {
        // 升序排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0) {
                break;
            }

            int bIndex = index + 1;
            int cIndex = nums.length - 1;

            while (bIndex < cIndex) {
                if (nums[bIndex] + nums[cIndex] == -nums[index]) {
                    res.add(Arrays.asList(nums[index], nums[bIndex], nums[cIndex]));
                    bIndex = nextIndex(nums, bIndex);
                    cIndex = preIndex(nums, cIndex);
                } else if (nums[bIndex] + nums[cIndex] < -nums[index]) {
                    bIndex = nextIndex(nums, bIndex);
                } else {
                    cIndex = preIndex(nums, cIndex);
                }
            }

            index = nextIndex(nums, index);
        }
        return res;
    }

    private int preIndex(int[] nums, int cIndex) {
        for (int i = cIndex - 1; i >= 0 ; i--) {
            if (nums[i] != nums[cIndex]) {
                return i;
            }
        }
        return -1;
    }

    private int nextIndex(int[] nums, int bIndex) {
        for (int i = bIndex + 1; i < nums.length; i++) {
            if (nums[i] != nums[bIndex]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        TwoPointSolution solution = new TwoPointSolution();
        List<List<Integer>> lists = solution.threeSum(new int[]{0, 0, 0});
        System.out.println(lists);

    }

}
