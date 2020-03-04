package com.mrglint.leetcode.year2020.array.solution167;

/**
 * @author luhuancheng
 * @since 2020-03-04 22:26
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            }
        }
        throw new IllegalArgumentException("参数有误");
    }
}
