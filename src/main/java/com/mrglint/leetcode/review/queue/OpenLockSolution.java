package com.mrglint.leetcode.review.queue;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-12-19 07:36
 */
public class OpenLockSolution {

    /**
     * 定义起点 String start = "0000", 遍历该字符串，每个数字都可以 +1 或者 -1；
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendsSet.contains(target)) {
            return -1;
        }
        if (deadendsSet.contains("0000")) {
            return -1;
        }

        String start = "0000";
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String queueHead = queue.poll();
                if (Objects.equals(queueHead, target)) {
                    return res;
                }
                for (String newStart : getSuccessors(queueHead)) {
                    if (!deadendsSet.contains(newStart)) {
                        if (!visited.contains(newStart)) {
                            queue.offer(newStart);
                            visited.add(newStart);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> getSuccessors(String originalStart) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < originalStart.length(); i++) {
            res.add(originalStart.substring(0, i) + (originalStart.charAt(i) == '0' ? 9 : originalStart.charAt(i) - '0' - 1) + originalStart.substring(i + 1));
            res.add(originalStart.substring(0, i) + (originalStart.charAt(i) == '9' ? 0 : originalStart.charAt(i) - '0' + 1) + originalStart.substring(i + 1));
        }
        return res;
    }

}
