package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    private final int capacity;

    private final Map<Integer, DoubleListNode> map;

    private final DoubleListNode head;

    private final DoubleListNode tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, LruCache.DoubleListNode>(capacity);
        this.head = new DoubleListNode(0, 0);
        this.tail = new DoubleListNode(0, 0);

        this.head.prev = null;
        this.head.next = this.tail;

        this.tail.prev = this.head;
        this.tail.next = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleListNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    private void removeNode(DoubleListNode node) {
        DoubleListNode prevNode = node.prev;
        DoubleListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToHead(DoubleListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DoubleListNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DoubleListNode node = new DoubleListNode(key, value);
            map.put(key, node);
            addToHead(node);
            if (map.size() > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
    }

    public static class DoubleListNode {

        private final int key;

        private int value;

        private DoubleListNode prev;

        private DoubleListNode next;

        public DoubleListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
