package com.mrglint.leetcode.review.stack;

import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-29 15:56
 */
public class CanVisitAllRoomSolution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 存储是否已进入房间
        boolean[] seen = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        // 第一个房间默认开启
        seen[0] = true;
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer openRoom = stack.pop();
            for (int key : rooms.get(openRoom)) {
                if (!seen[key]) {
                    // 打开了一个房间
                    seen[key] = true;
                    // 用于获取房间内存放的钥匙
                    stack.push(key);
                }
            }
        }

        // 检查是否所有房间都开启
        for (boolean b : seen) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
