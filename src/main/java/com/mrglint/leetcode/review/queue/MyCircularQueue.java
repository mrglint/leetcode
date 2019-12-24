package com.mrglint.leetcode.review.queue;

/**
 * @author luhuancheng
 * @since 2019-12-16 08:07
 */
public class MyCircularQueue {

    private int[] storage;
    private int length;
    private int head, tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        storage = new int[k + 1];
        length = k + 1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        storage[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return storage[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        // tail指向的是当前可放入元素的队尾指针。
        // 当tail = 0时，队尾元素所在索引为数组最后一个索引位置(即length - 1)，此处技术处理为(tail + length - 1) = (0 + length - 1)
        // 该技术处理对于其他tail取值也使用。因为 (tail - 1 + length) % length 依旧等于 tail - 1
        return storage[(tail + length - 1) % length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % length == head;
    }

}
