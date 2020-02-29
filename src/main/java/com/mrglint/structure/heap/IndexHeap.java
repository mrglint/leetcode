package com.mrglint.structure.heap;

import java.util.Arrays;

/**
 * 索引堆，增加一层索引数组，比较大小后，移动的是索引值
 *
 * 1.避免频繁移动堆中数据
 * 2.通过索引减少遍历堆来检索数据
 *
 * 索引堆优化：反向索引
 *
 * @author luhuancheng
 * @since 2020-02-29 10:01
 */
public class IndexHeap<E extends Comparable<E>> {

    private E[] data;
    private int[] indexes;
    private int[] reverses;
    private int size;
    private int capacity;

    public IndexHeap(int capacity) {
        this.capacity = capacity + 1;
        this.size = 0;
        data = (E[]) new Object[capacity + 1];
        indexes = new int[capacity + 1];
        // 默认值为0，0表示不存在
        reverses = new int[capacity + 1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int i, E e) {
        // 需要扩容
        if (size == getCapacity() + 1) {
            resize(getCapacity() * 2);
        }
        // 对于用户来说，索引从0开始
        i += 1;

        data[i] = e;
        // 存储索引
        indexes[size + 1] = i;
        reverses[i] = size + 1;

        size++;
        shiftUp(size);
    }

    public E extractMax() {
        E ret = data[indexes[1]];
        swap(indexes, 1, size);
        reverses[indexes[1]] = 1;
        reverses[indexes[size]] = 0;

        size--;
        shiftDown(1);

        return ret;
    }

    public int extractMaxIndex() {
        int ret = indexes[1] - 1;

        swap(indexes, 1, size);
        reverses[indexes[1]] = 1;
        reverses[indexes[size]] = 0;

        size--;
        shiftDown(1);

        return ret;
    }

    public E getItem(int index) {
        return data[index + 1];
    }

    public void change(int i, E item) {
        i += 1;
        data[i] = item;

//        for (int j = 1; j <= size; j++) {
//            if (indexes[j] == i) {
//                shiftDown(j);
//                shiftUp(j);
//                return;
//            }
//        }
        int j = reverses[i];
        shiftUp(j);
        shiftDown(j);
    }

    private void shiftDown(int k) {

        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j += 1;
            }

            // 子节点小于父节点
            if (data[indexes[j]].compareTo(data[indexes[k]]) < 0) {
                break;
            }

            swap(indexes, k, j);
            reverses[indexes[k]] = k;
            reverses[indexes[j]] = j;
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            // 交换索引位置
            swap(indexes, indexes[k / 2], indexes[k]);
            reverses[indexes[k / 2]] = k / 2;
            reverses[indexes[k]] = k;

            k /= 2;
        }
    }

    private int getCapacity() {
        return capacity - 1;
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity + 1);
        indexes = Arrays.copyOf(indexes, newCapacity + 1);
        reverses = Arrays.copyOf(reverses, newCapacity + 1);
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
