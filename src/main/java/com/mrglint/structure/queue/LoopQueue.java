package com.mrglint.structure.queue;

/**
 * 循环队列
 * 1. 出队时，不需要挪动数据，降低时间复杂度
 *
 * @author luhuancheng
 * @since 2020-02-18 13:40
 */
public class LoopQueue<E> implements Queue<E> {
    
    private E[] array;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % array.length == front) {
            resize(getCapacity() * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[(i + front) % array.length];
        }
        array = newArray;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        E res = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        return array[front];
    }

    @Override
    public int getSize() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 循环队列中，使用 (tail + 1) % array.length == front 来判断队列是否已满，浪费了一个空间
     * 
     * @return
     */
    public int getCapacity() {
        return array.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("LoopQueue: front [");
        for (int i = front; i != tail; i = (i + 1) % array.length) {
            res.append(array[i]);
            res.append(",");
        }
        res.append("] tail ");
        res.append("capacity: ").append(getCapacity());
        res.append(" size: ").append(size);
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("After dequeue" + queue);
            }
        }
        System.out.println(queue);
    }
}
