package com.mrglint.leetcode.review.binarytree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-12-14 21:47
 */
public class PopulateNextRightPointSolution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prevNode = null;
            while (size-- > 0) {
                Node queueHead = queue.poll();

                if (prevNode != null) {
                    if (size == 0) {
                        prevNode.next = queueHead;
                        queueHead.next = null;
                    } else {
                        prevNode.next = queueHead;
                    }
                }

                if (queueHead.left != null) {
                    queue.offer(queueHead.left);
                }
                if (queueHead.right != null) {
                    queue.offer(queueHead.right);
                }
                prevNode = queueHead;

            }
        }
        return root;
    }
}
