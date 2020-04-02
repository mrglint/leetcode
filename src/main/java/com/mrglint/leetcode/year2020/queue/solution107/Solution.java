package com.mrglint.leetcode.year2020.queue.solution107;

import com.mrglint.leetcode.TreeNode;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-04-02 22:48
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subRes = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node)) {
                    subRes.add(node.val);
                    if (Objects.nonNull(node.left)) {
                        queue.offer(node.left);
                    }
                    if (Objects.nonNull(node.right)) {
                        queue.offer(node.right);
                    }
                }
            }

            res.add(0, subRes);
        }
        return res;
    }
}
