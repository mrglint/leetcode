package com.mrglint.structure.trie.leetcode.solution677;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/map-sum-pairs/submissions/
 *
 * @author luhuancheng
 * @since 2020-02-23 10:41
 */
public class MapSum {

    private static class Node {
        int value;
        Map<Character, Node> next;

        Node() {
            next = new TreeMap<>();
        }

        Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node(0);
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            // 找不到前缀prefix
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}
