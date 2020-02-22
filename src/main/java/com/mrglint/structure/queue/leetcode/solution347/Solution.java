package com.mrglint.structure.queue.leetcode.solution347;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-02-22 15:53
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 统计频次
        Map<Integer, Integer> freqenceMap = new TreeMap<>();
        for (int i : nums) {
            if (freqenceMap.containsKey(i)) {
                freqenceMap.put(i, freqenceMap.get(i) + 1);
            } else {
                freqenceMap.put(i, 1);
            }
        }

        // java内置的优先队列，底层是最小堆。此处我们需要保证堆顶是最小值
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(freqenceMap::get));

        // 维护优先队列中的元素个数为 k 个
        for (int key : freqenceMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (freqenceMap.get(key) > freqenceMap.get(priorityQueue.peek())){
                // 堆顶元素对应的频次小于当前key的频次
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.remove());
        }
        return res;
    }
}
