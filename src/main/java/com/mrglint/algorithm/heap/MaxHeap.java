package com.mrglint.algorithm.heap;

import com.mrglint.algorithm.sort.SortUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 性质：
 * 1. 完全二叉树
 * 2. 任意一个节点不能大于父节点
 *
 * @author luhuancheng
 * @since 2019-12-01 20:46
 */
public class MaxHeap {

    private int capacity;
    private int[] data;
    private int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        data = new int[capacity + 1];
    }

    public MaxHeap(int[] data) {
        this.data = new int[data.length + 1];
        size = data.length;
        capacity = data.length;
        System.arraycopy(data, 0, this.data, 1, data.length);
        // 进行heapify操作
        for (int i = size / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int n) {
        if (size + 1 > capacity) {
            throw new IllegalStateException("堆已满");
        }
        data[size + 1] = n;
        size++;
        shiftUp(size);
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("堆为空");
        }
        int res = data[1];
        SortUtils.swap(data, 1, size);
        size--;
        shiftDown(1);
        return res;
    }

    private void shiftDown(int index) {
        // 2 * index 为index所在节点的左孩子
        // 如果 2 * index <= size, 说明左孩子存在
        while (2 * index <= size) {
            int j = 2 * index;
            if (j + 1 <= size && data[j] < data[j + 1]) {
                j++;
            }
            // 当父节点 >= 两个子节点，不进行操作
            if (data[index] >= data[j]) {
                break;
            }
            // 将index所在元素和j进行交换
            SortUtils.swap(data, index, j);
            index = j;
        }
    }

    private void shiftUp(int index) {
        while (index > 1 && data[index] > data[index / 2]) {
            SortUtils.swap(data, index, index / 2);
            index = index / 2;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        MaxHeap heap = new MaxHeap(10);
        for (int i = 0; i < 10; i++) {
            heap.insert(random.nextInt(10));
        }
        System.out.println(Arrays.toString(heap.data));
        while (!heap.isEmpty()) {
            System.out.println(heap.extractMax());
        }
    }
}
