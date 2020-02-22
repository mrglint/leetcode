package com.mrglint.structure.segmenttree.leetcode.solution307;

import com.mrglint.structure.segmenttree.SegmentTree;

/**
 * @author luhuancheng
 * @since 2020-02-22 21:31
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length != 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{0, 9, 5, 7, 3});
        System.out.println(array.sumRange(4, 4));
        System.out.println(array.sumRange(2, 4));
    }

}
