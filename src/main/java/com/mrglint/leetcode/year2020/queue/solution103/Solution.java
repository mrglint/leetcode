package com.mrglint.leetcode.year2020.queue.solution103;

import com.mrglint.leetcode.TreeNode;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-04-03 07:53
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subRes = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node)) {
                    if (zigzag) {
                        subRes.add(0, node.val);
                    } else {
                        subRes.add(node.val);
                    }

                    if (Objects.nonNull(node.left)) {
                        queue.offer(node.left);
                    }

                    if (Objects.nonNull(node.right)) {
                        queue.offer(node.right);
                    }
                }
            }
            zigzag = !zigzag;
            res.add(subRes);
        }
        return res;
    }
}
