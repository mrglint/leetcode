package com.mrglint.leetcode.review.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-12-20 08:06
 */
public class NumSquareSolution {

    public int numSquares(int n) {
        int res = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Integer queueHead = queue.poll();
                for (int i = 1;; i++) {
                    int subtraction = queueHead - i * i;
                    if (subtraction < 0) {
                        break;
                    }
                    if (subtraction == 0) {
                        return res + 1;
                    }
                    queue.offer(subtraction);
                }
            }
            res++;
        }
        return -1;
    }
}
