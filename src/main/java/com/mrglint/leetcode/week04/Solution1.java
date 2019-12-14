package com.mrglint.leetcode.week04;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-11-10 20:47
 */
public class Solution1 {

    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode queueHead = queue.poll();
                if (Objects.nonNull(queueHead) && Objects.nonNull(queueHead.left)) {
                    queue.offer(queueHead.left);
                }
                if (Objects.nonNull(queueHead) && Objects.nonNull(queueHead.right)) {
                    queue.offer(queueHead.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
