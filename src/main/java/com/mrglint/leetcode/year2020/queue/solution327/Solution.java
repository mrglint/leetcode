package com.mrglint.leetcode.year2020.queue.solution327;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author luhuancheng
 * @since 2020-04-06 19:38
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        // 统计频次
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 放入优先队列
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            queue.offer(entry);
        }

        while (k-- > 0) {
            res.add(queue.poll().getKey());
        }
        return res;
    }
}