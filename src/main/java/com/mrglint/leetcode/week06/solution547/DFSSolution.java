package com.mrglint.leetcode.week06.solution547;

/**
 * 1. DFS、BFS
 * 2. 并查集
 * @author luhuancheng
 * @since 2019-11-19 09:16
 */
public class DFSSolution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;

        // 所有人的编号为0 ~ M.length - 1。
        // 遍历所有人
        for (int i = 0; i < M.length; i++) {
            // 没被遍历过
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        // 看一下当前遍历的人，有哪些朋友（M[i[j])
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                // 看一下「当前遍历的人的朋友」，有哪些朋友（M[j][0 - n]。即深度优先搜索
                dfs(M, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        DFSSolution solution = new DFSSolution();
        // 1 0 0 1
        // 0 1 1 0
        // 0 1 1 1
        // 1 0 1 1
        int circleNum = solution.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
        System.out.println(circleNum);
    }
}
