package com.mrglint.leetcode.review.stack;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-12-25 08:20
 */
public class CloneGraphSolution {

    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        map.put(node, new Node(node.val, new ArrayList<>()));
        stack.push(node);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            for (Node neighbor : curNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // 克隆邻接节点
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    stack.push(neighbor);
                }
                // 建立邻接节点与当前节点的关系
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
