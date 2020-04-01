package com.mrglint.leetcode.year2020.queue.solution102;

import com.mrglint.leetcode.TreeNode;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-04-02 07:43
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(subRes);
        }
        return res;
    }
}
