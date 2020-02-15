package com.mrglint.leetcode.review.recursionii;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2894/
 *
 * @author luhuancheng
 * @since 2020-01-20 09:57
 */
public class SameTreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!checkSameNode(p, q)) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty()) {
            TreeNode queueHeadP = queueP.poll();
            TreeNode queueHeadQ = queueQ.poll();
            if (!checkSameNode(queueHeadP, queueHeadQ)) {
                return false;
            }

            if (Objects.nonNull(queueHeadP)) {
                if (!checkSameNode(queueHeadP.left, queueHeadQ.left)) {
                    return false;
                }
                queueP.offer(queueHeadP.left);
                queueQ.offer(queueHeadQ.left);

                if (!checkSameNode(queueHeadP.right, queueHeadQ.right)) {
                    return false;
                }
                queueP.offer(queueHeadP.right);
                queueQ.offer(queueHeadQ.right);
            }
        }
        return true;
    }

    private Boolean checkSameNode(TreeNode p, TreeNode q) {
        // 两个空树 ：一致
        if (p == null && q == null) {
            return true;
        }
        // 其中一个为空树 ：不一致
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }
}
