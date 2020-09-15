package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglee
 * @date 2020/8/7 11:19
 * @description
 */
public class LFUCache {
    private int capacity, size, min;
    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Map<Integer, DoubleLinkedList> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            update(node);
            return;
        }
        if (size == capacity){
            DoubleLinkedList minFreq = freqMap.get(min);
            nodeMap.remove(minFreq.tail.pre.key);
            minFreq.remove(minFreq.tail.pre);
            size --;
        }
        Node node = new Node(key, value);
        nodeMap.put(key, node);
        DoubleLinkedList list = freqMap.getOrDefault(1, new DoubleLinkedList());
        list.add(node);
        freqMap.put(1, list);
        size ++;
        min = 1;
    }

    public void update(Node node){
        DoubleLinkedList oldList = freqMap.get(node.freq);
        oldList.remove(node);
        if (node.freq == min && oldList.head.next == oldList.tail) min ++;
        node.freq ++;
        DoubleLinkedList newList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }

    class Node {
        int key, value, freq = 1;
        Node pre, next;
        public Node(){}
        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        Node head = new Node();
        Node tail = new Node();
        public DoubleLinkedList (){
            head.next = tail;
            tail.pre = head;
        }
        public void add(Node node){
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }
        public void remove(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
}
