package com.mrglint.leetcode.year2020.queue.solution279;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2020-04-06 18:27
 */
public class Solution {

    public int numSquares(int n) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer queueHead = queue.poll();
                for (int i = 1;;i++) {
                    int subtract = queueHead - i * i;
                    if (subtract < 0) {
                        break;
                    }
                    if (subtract == 0) {
                        return res + 1;
                    }
                    queue.offer(subtract);
                }
            }
            res++;
        }
        // 无法将n分解为1, 4, 9 ... 的和
        return -1;
    }
}
