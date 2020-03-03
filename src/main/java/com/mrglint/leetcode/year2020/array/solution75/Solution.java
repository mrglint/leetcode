package com.mrglint.leetcode.year2020.array.solution75;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2020-03-03 22:23
 */
public class Solution {

    /**
     * 三路快排
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two;) {
            if (nums[i] == 0) {
                int temp = nums[zero + 1];
                nums[zero + 1] = nums[i];
                nums[i] = temp;
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[two - 1];
                nums[two - 1] = nums[i];
                nums[i] = temp;
                two--;
            }
        }
    }

    /**
     * 计数排序.
     * @param nums
     */
    public void sortColors1(int[] nums) {
        // 去重后元素个数
        int length = 3;

        // 计数
        int[] sorted = new int[length];
        for (int i = 0; i < nums.length; i++) {
            sorted[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < sorted[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{2,0,2,1,1,0};
        solution.sortColors(data);
        System.out.println(Arrays.toString(data));
    }

}
