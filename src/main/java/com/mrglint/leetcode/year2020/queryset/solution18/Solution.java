package com.mrglint.leetcode.year2020.queryset.solution18;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-03-13 07:46
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 3; i = nextIndex(nums, i)) {
            for (int j = i + 1; j < n - 2; j = nextIndex(nums, j)) {

                // 先确定两个数，nums[i] 和 nums[j]
                int t = target - nums[i] - nums[j];

                // nums[j + 1] + nums[j + 2] 另外两个数的最小值都大于目标和
                // nums[n - 1] + nums[n - 2] < t 另外两个数的最大值都小于目标和
                if (nums[j + 1] + nums[j + 2] > t || nums[n - 1] + nums[n - 2] < t) {
                    continue;
                }

                int p1 = j + 1;
                int p2 = n - 1;
                if (p1 >= p2) {
                    break;
                }

                System.out.println(nums[i] + ", " + nums[j] + ", " + nums[p1] + ", " + nums[p2]);

                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == t) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p1], nums[p2]));
                        p1 = nextIndex(nums, p1);
                        p2 = preIndex(nums, p2);
                    } else if (nums[p1] + nums[p2] < t) {
                        p1 = nextIndex(nums, p1);
                    } else {
                        p2 = preIndex(nums, p2);
                    }
                }
            }
        }
        return res;
    }

    private int preIndex(int[] nums, int cIndex) {
        for (int i = cIndex - 1; i >= 0; i--) {
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
        Solution solution = new Solution();
        solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
    }
}
