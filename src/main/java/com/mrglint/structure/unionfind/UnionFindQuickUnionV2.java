package com.mrglint.structure.unionfind;

/**
 * Quick Union 1.1
 *
 * @author luhuancheng
 * @since 2020-02-23 11:31
 */
public class UnionFindQuickUnionV2 implements UF {

    private int[] parent;

    public UnionFindQuickUnionV2(int capacity) {
        parent = new int[capacity];
        // 初始状态下，所有节点不相连
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
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

        parent[pRoot] = qRoot;
    }

    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
