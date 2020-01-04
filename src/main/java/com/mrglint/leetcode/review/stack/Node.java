package com.mrglint.leetcode.review.stack;

import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-12-25 08:21
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int value, List<Node> neighbors) {
        val = value;
        this.neighbors = neighbors;
    }
}
