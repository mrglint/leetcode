package com.mrglint.structure.heap;

import com.mrglint.structure.array.Array;

import java.util.Random;

/**
 * @author luhuancheng
 * @since 2020-02-22 11:40
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] array) {
        data = new Array<>(array);

        // Heapify时间复杂度为O(n)，比直接将数组元素依次添加到空堆的复杂度要低(O(nlogn))
        for (int i = parentIndex(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
        // 维护堆的性质
        siftUp(data.getSize() - 1);
    }

    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        while (leftChildIndex(k) < data.getSize()) {
            int j = leftChildIndex(k);

            // 存在右节点，且右节点 > 左节点
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChildIndex(k);
            }

            // data[j] 已经大于其左右两个子节点，不需要再下沉
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("MaxHeap is empty");
        }
        return data.get(0);
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftUp(0);
        return ret;
    }

    // heapify

    private void siftUp(int k) {
        while (k > 0 && data.get(parentIndex(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parentIndex(k));
            k = parentIndex(k);
        }
    }

    private int parentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 have no parent");
        }
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.add(random.nextInt(100));
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMax());
        }
    }

}
