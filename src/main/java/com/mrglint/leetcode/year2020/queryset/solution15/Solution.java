package com.mrglint.leetcode.year2020.queryset.solution15;

import java.util.*;

/**
 * 难点在于去重：每个结果不能重复。比如[-1, -1, 2] 和 [-1, 2, -1] 就是重复结果
 *
 * @author luhuancheng
 * @since 2020-03-11 07:55
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }

        if (counter.getOrDefault(0, 0) >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }

        // 构造一个已去重的列表
        List<Integer> list = new ArrayList<>(counter.keySet());
        Collections.sort(list, Comparator.comparingInt(o -> o));

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                // 分三种情况讨论
                if (2 * list.get(i) + list.get(j) == 0 && counter.get(list.get(i)) >= 2) {
                    result.add(Arrays.asList(list.get(i), list.get(i), list.get(j)));
                }
                if (list.get(i) + 2 * list.get(j) == 0 && counter.get(list.get(j)) >= 2) {
                    result.add(Arrays.asList(list.get(i), list.get(j), list.get(j)));
                }

                int c = 0 - list.get(i) - list.get(j);
                if (c > list.get(j) && counter.containsKey(c)) {
                    result.add(Arrays.asList(list.get(i), list.get(j), c));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
