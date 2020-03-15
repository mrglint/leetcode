package com.mrglint.leetcode.year2020.queryset.solution220;

import java.util.Objects;
import java.util.TreeSet;

/**
 * 给定一个数组nums, 判断是否存在索引 i，j 满足：abs(nums[i] - nums[j]) <= t 并且 abs(i - j) <= k
 *
 * @author luhuancheng
 * @since 2020-03-15 21:33
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 1, 2, 3, 1
        TreeSet<Long> set = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 维持选择的范围，以保证选出来的索引符合 abs(i - j) <= k
            if (i - j > k) {
                set.remove((long) nums[j]);
                j++;
            }
            if (!set.isEmpty()) {
                Long lower = set.ceiling((long) nums[i] - (long) t);
                if (Objects.nonNull(lower) && Math.abs((long) nums[i] - lower) <= t) {
                    return true;
                }
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean a = solution.containsNearbyAlmostDuplicate(new int[]{-2147483648, -2147483647}, 3, 3);
        System.out.println(a);

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(100);
        set.add(8);

        Integer floor = set.higher(1);
        System.out.println(floor);
    }
}
