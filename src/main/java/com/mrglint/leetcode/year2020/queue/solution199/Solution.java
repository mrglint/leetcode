package com.mrglint.leetcode.year2020.queue.solution199;

import com.mrglint.leetcode.TreeNode;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-04-04 07:59
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node)) {
                    if (size == 0) {
                        res.add(node.val);
                    }
                    if (Objects.nonNull(node.left)) {
                        queue.offer(node.left);
                    }
                    if (Objects.nonNull(node.right)) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return res;
    }
}
