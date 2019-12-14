package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-12-12 07:17
 */
public class LevelorderTraversalSolution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            List<Integer> subRes = new LinkedList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode queueHead = queue.poll();
                subRes.add(queueHead.val);
                if (queueHead.left != null) {
                    queue.offer(queueHead.left);
                }
                if (queueHead.right != null) {
                    queue.offer(queueHead.right);
                }
            }
            res.add(subRes);
        }
        return res;
    }
}
