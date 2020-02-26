package com.mrglint.structure.unionfind;

/**
 * Quick Union 1.3
 * 基于rank的优化，通过rank来决定合并时节点的指向
 *
 * @author luhuancheng
 * @since 2020-02-23 11:31
 */
public class UnionFindQuickUnionV4 implements UF {

    private int[] parent;
    private int[] rank;

    public UnionFindQuickUnionV4(int capacity) {
        parent = new int[capacity];
        rank = new int[capacity];
        // 初始状态下，所有节点不相连
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * O(h)
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * O(h)
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        // 根据树的高度来决定指向
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
