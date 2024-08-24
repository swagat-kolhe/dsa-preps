package com.leetcode.solutions;

public class MyCircularQueue {

    private final int[] circluarQueue;
    private int head;
    private int tail;
    private int k;

    public MyCircularQueue(int k) {
        this.k = k;
        circluarQueue = new int[k];
        head = -1;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % k;
        circluarQueue[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % k;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return circluarQueue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return circluarQueue[tail];
    }

    public boolean isEmpty() {
        if (head == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return ((tail + 1) % k) == head;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(6);
        System.out.println(myCircularQueue.enQueue(6)); // return True
        System.out.println(myCircularQueue.Rear()); // return 6
        System.out.println(myCircularQueue.Rear()); // return 6
        System.out.println(myCircularQueue.deQueue()); // return True
        System.out.println(myCircularQueue.enQueue(5)); // return True
        System.out.println(myCircularQueue.Rear()); // return 5
        System.out.println(myCircularQueue.deQueue()); // return True
        System.out.println(myCircularQueue.Front()); // return -1
        System.out.println(myCircularQueue.deQueue()); // return False
        System.out.println(myCircularQueue.deQueue()); // return False
        System.out.println(myCircularQueue.deQueue()); // return False
    }
}