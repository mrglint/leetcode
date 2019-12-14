package com.mrglint.leetcode.week06.solution547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-11-20 07:25
 */
public class BFSSolution {

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        // 所有人的编号为0 ~ M.length - 1。
        // 遍历所有人
        for (int i = 0; i < M.length; i++) {
            // 没被遍历过
            if (visited[i] == 0) {
                queue.offer(i);

                while (!queue.isEmpty()) {
                    Integer queueHead = queue.poll();
                    // 标记为已遍历
                    visited[queueHead] = 1;
                    // 看一下当前遍历的人，有哪些朋友（M[queueHead[j])。放入待遍历队列：广度优先搜索
                    for (int j = 0; j < M.length; j++) {
                        if (M[queueHead][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        BFSSolution solution = new BFSSolution();
        // 1 0 0 1
        // 0 1 1 0
        // 0 1 1 1
        // 1 0 1 1
        int circleNum = solution.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
        System.out.println(circleNum);
    }
}
