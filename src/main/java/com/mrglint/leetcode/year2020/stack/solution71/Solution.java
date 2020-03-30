package com.mrglint.leetcode.year2020.stack.solution71;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-03-30 07:50
 */
public class Solution {
    public String simplifyPath(String path) {
        Set<String> set = new HashSet<>(Arrays.asList(".", "..", ""));

        Deque<String> deque = new LinkedList<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (!set.contains(s)) {
                deque.push(s);
            } else if (s.equals("..") && !deque.isEmpty()){
                deque.pop();
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append("/");
            res.append(deque.pollLast());
        }
        return res.toString();
    }
}
