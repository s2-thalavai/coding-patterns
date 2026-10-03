package com.leetcode.patterns.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern 31a: LRU Cache. LC 146.
 *
 * <p>HashMap (O(1) lookup) + doubly linked list (O(1) reorder/evict), with sentinels.
 * Most recently used sits right after {@code head}; LRU sits right before {@code tail}.
 */
public class LRUCache {

    private static final class Node {
        private final int key;
        private int val;
        private Node prev;
        private Node next;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        unlink(node);
        addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            unlink(node);
            addFirst(node);
            return;
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;
            unlink(lru);
            map.remove(lru.key);                 // why Node stores its key
        }
        node = new Node(key, value);
        map.put(key, node);
        addFirst(node);
    }

    public int size() {
        return map.size();
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
