package com.mrglint.leetcode.year2020.array.solution283;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-03-01 15:51
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        // [0, k) 非0数字区间
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                    k++;
                } else {
                    k++;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {

        // [0, k) 非0数字区间
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        List<Integer> temp = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }

        for (int i = temp.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
