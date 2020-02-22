package com.mrglint.structure.segmenttree.leetcode.solution303;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @author luhuancheng
 * @since 2020-02-22 21:23
 */
public class NumArray {

    int[] sum;
    public NumArray(int[] nums) {
        // 保存前i个元素的和
        sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    /**
     * 求 [i, j] 区间之和
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        // sum[j + 1] 包含 j
        // sum[i] 不包含 i
        return sum[j + 1] - sum[i];
    }
}
