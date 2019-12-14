package com.mrglint.leetcode.week07.solution146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2019-11-27 22:58
 */
public class LRUCacheLibImplementation extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCacheLibImplementation(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity = initialCapacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
