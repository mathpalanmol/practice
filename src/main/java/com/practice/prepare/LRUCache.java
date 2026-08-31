package com.practice.prepare;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache (LeetCode #146)
 *
 * <p>Design a data structure that follows the constraints of a
 * <b>Least Recently Used (LRU) cache</b>.
 *
 * <p>Implement {@link LRUCache} with:
 * <ul>
 *   <li>{@code LRUCache(int capacity)} — initialize with positive capacity</li>
 *   <li>{@code int get(int key)} — return value if present, else {@code -1}</li>
 *   <li>{@code void put(int key, int value)} — insert or update; evict LRU item if over capacity</li>
 * </ul>
 *
 * <p>Both {@code get} and {@code put} must run in <b>O(1)</b> average time.
 *
 * <p>Example:
 * <pre>
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 1);   // cache: {1=1}
 * cache.put(2, 2);   // cache: {1=1, 2=2}
 * cache.get(1);      // returns 1
 * cache.put(3, 3);   // evicts key 2 → {1=1, 3=3}
 * cache.get(2);      // returns -1 (not found)
 * cache.put(4, 4);   // evicts key 1 → {3=3, 4=4}
 * cache.get(1);      // returns -1
 * cache.get(3);      // returns 3
 * cache.get(4);      // returns 4
 * </pre>
 *
 * <p><b>Solution:</b> HashMap + doubly linked list.
 * <ul>
 *   <li>Map: key → node for O(1) lookup</li>
 *   <li>List: head = most recent, tail = least recent</li>
 *   <li>{@code get/put}: move accessed node to head; evict tail when over capacity</li>
 * </ul>
 * Time: O(1) per operation, Space: O(capacity).
 */
public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        addToHead(node);

        if (map.size() > capacity) {
            Node lru = removeTail();
            map.remove(lru.key);
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node lru = tail;
        removeNode(lru);
        return lru;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));  // 1
        cache.put(3, 3);                 // evicts key 2
        System.out.println(cache.get(2));  // -1
        cache.put(4, 4);                 // evicts key 1
        System.out.println(cache.get(1));  // -1
        System.out.println(cache.get(3));  // 3
        System.out.println(cache.get(4));  // 4
    }
}
