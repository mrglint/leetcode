package com.mrglint.leetcode.year2022.solution370;

/**
 * 差分数组
 *
 * @author luhuancheng
 * @since 2022/2/16 10:36 PM
 */
public class Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] update : updates) {
            increment(res, update[0], update[1], update[2]);
        }

        return rebuild(res);
    }

    private int[] rebuild(int[] diff) {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        return res;
    }

    private void increment(int[] inputArray, int i, int j, int increment) {
        inputArray[i] = inputArray[i] + increment;
        if (j + 1 < inputArray.length) {
            inputArray[j + 1] = inputArray[j + 1] - increment;
        }
    }
}
