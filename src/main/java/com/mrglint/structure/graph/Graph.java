package com.mrglint.structure.graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 基于TreeSet优化的「邻接表」实现的图
 *
 * @author luhuancheng
 * @since 2020-03-01 10:36
 */
public class Graph {

    private int v;
    private int e;
    private TreeSet<Integer>[] treeSet;

    public Graph(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            // 初始化图
            int v = scanner.nextInt();
            this.v = v;
            if (v < 0) {
                throw new IllegalArgumentException("顶点数必须大于0");
            }
            treeSet = new TreeSet[v];
            for (int i = 0; i < v; i++) {
                treeSet[i] = new TreeSet<>();
            }
            int e = scanner.nextInt();
            this.e = e;

            // 构造图
            for (int i = 0; i < e; i++) {
                int a = scanner.nextInt();
                validateVertrix(a);
                int b = scanner.nextInt();
                validateVertrix(b);
                if (a == b) {
                    throw new IllegalArgumentException("不支持自环边");
                }
                if (treeSet[a].contains(b)) {
                    throw new IllegalArgumentException("不支持平行边");
                }
                treeSet[a].add(b);
                treeSet[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 顶点数
     *
     * @return
     */
    public int v() {
        return v;
    }

    /**
     * 边数
     * @return
     */
    public int e() {
        return e;
    }

    public boolean hasEdge(int v, int w) {
        validateVertrix(v);
        validateVertrix(w);
        return treeSet[v].contains(w);
    }

    public Iterable<Integer> adj(int v) {
        validateVertrix(v);
        return treeSet[v];
    }

    public int dgree(int v) {
        validateVertrix(v);
        return treeSet[v].size();
    }

    private void validateVertrix(int n) {
        if (n < 0 || n >= v) {
            throw new IllegalArgumentException(String.format("顶点%s不存在", n));
        }
    }
}
