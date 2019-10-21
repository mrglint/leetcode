package com.mrglint.leetcode.solution239;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-10-21 07:55
 */
public class Solution {

    // 暴力解法
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i; j < k + i; j++) {
                max = Math.max(nums[j], max);
            }
            result[i] = max;
        }
        return result;
    }

    ArrayDeque<Integer> deq = new ArrayDeque<>();
    int[] nums;

    public void cleanQueue(int i, int k) {
        // 维持队列长度为3, i - deq.getFirst() == k可以理解为：
        // (i - deq.getFirst() + 1) 为队列长度，为保持队列长度为k，那么 (i - deq.getFirst() + 1) = k + 1时，需要移除队首元素
        while (!deq.isEmpty() && i - deq.getFirst() == k) {
            deq.removeFirst();
        }

        while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 数组为0，或者窗口为0
        if (nums.length * k == 0) {
            return new int[0];
        }
        // 如果窗口为1，那么结果为原数组
        if (k == 1) {
            return nums;
        }
        this.nums = nums;
        for (int i = 0; i < k; i++) {
            // 维持入队的元素符合窗口大小，而且窗口中最大的值为队首元素
            cleanQueue(i, k);
            deq.addLast(i);
        }
        // nums.length - k 为最后一个窗口中的第一个元素索引，由于索引从0开始，那么共有nums.length - k + 1个窗口
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deq.getFirst()];

        for (int i = k; i < nums.length; i++) {
            cleanQueue(i, k);
            deq.addLast(i);
            // i - x + 1 = k 其中x为窗口第一个元素，推断出x = i - k + 1, 那么结果集中索引为(i - k + 1)存放结果
            result[i - k + 1] = nums[deq.getFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));
    }

}
