package pri.jv.leetcode;

import java.util.HashMap;

class LRUCache {

    private HashMap<Integer, Node> hashMap;

    private Node head;
    private Node tail;
    private int capacity;

    class Node {
        Node next;
        Node pre;
        Integer val;
        Integer key;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    public LRUCache(int capacity) {
        hashMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return -1;
        } else {
            if (node == head || head == tail) {
                return node.val;
            }
            if (node == tail) {
                Node newTail = tail.pre;
                newTail.next = null;
                tail.next = head;
                head.pre = tail;
                tail.pre = null;
                head = tail;
                tail = newTail;
                return head.val;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node old = hashMap.get(key);
        // 存在旧值
        if (old != null) {
            old.val = value;
            if (old==head){

            } else if (old == tail) {
                Node newTail = old.pre;
                newTail.next = null;
                tail.pre = null;
                tail.next = head;
                head.pre = tail;
                head = tail;
                tail = newTail;
            } else {
                old.pre.next = old.next;
                old.next.pre = old.pre;
                old.pre = null;
                old.next = head;
                head.pre = old;
                head = old;
            }
        } else { //不存在旧值
            Node node = new Node(key, value);
            hashMap.put(key, node);
            if (head == null) {
                head = node;
                tail = node;
            } else if (head == tail) {
                head = node;
                node.next = tail;
                tail.pre = head;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }
        checkCapacity();
    }

    private void checkCapacity() {
        if (hashMap.size() > capacity) {
            int key = tail.key;
            Node newTail = tail.pre;
            newTail.next = null;
            tail.pre = null;
            tail = newTail;
            hashMap.remove(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }
}