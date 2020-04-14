package linkedlist;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private int capacity;
    private DoubleListNode head, tail;
    private HashMap<Integer,DoubleListNode> map = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;

        head = new DoubleListNode(0,0);
        tail = new DoubleListNode(0,0);
        head.pre = null;
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }
    public void put(int key, int value){
        if(map.containsKey(key)){
            DoubleListNode node = map.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        }else{
            if(map.size() == capacity){
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            DoubleListNode node = new DoubleListNode(key,value);
            map.put(key,node);
            addToHead(node);
        }
    }
    public int get(int key){
        int res = -1;
        if(map.containsKey(key)){
            DoubleListNode node = map.get(key);
            res = node.value;
            remove(node);
            addToHead(node);
        }
        return res;
    }
    public void addToHead(DoubleListNode node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    public void remove(DoubleListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    class DoubleListNode{
        int key, value;
        DoubleListNode pre, next;
        DoubleListNode(int x, int y){
            this.key = x;
            this.value = y;
        }
    }
}
