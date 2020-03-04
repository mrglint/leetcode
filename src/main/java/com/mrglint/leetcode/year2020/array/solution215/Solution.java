package com.mrglint.leetcode.year2020.array.solution215;

import java.util.Random;

/**
 * @author luhuancheng
 * @since 2020-03-04 07:39
 */
public class Solution {

    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int lo, int hi, int k) {
        // 随机化标定点
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        int temp = nums[randomIndex];
        nums[randomIndex] = nums[lo];
        nums[lo] = temp;

        // 标定点值
        int value = nums[lo];
        // [lo + 1, j] > value
        // [j + 1, i) <= value
        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] > value) {
                swap(nums, j + 1, i);
                j++;
            }
        }
        swap(nums, lo, j);

        if (j == k) {
            return nums[j];
        } else if (j < k) {
            return findKthLargest(nums, j + 1, hi, k);
        } else {
            return findKthLargest(nums, lo, j - 1, k);
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{3, 2, 1, 5, 6, 4};
        int kthLargest = solution.findKthLargest(data, 2);
        System.out.println(kthLargest);
    }
}
