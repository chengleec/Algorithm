package others;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheO1 {

    private int capacity;
    private DoubleListNode head, tail;
    private HashMap<Integer,DoubleListNode> map = new HashMap<>();

    public LRUCacheO1(int capacity){
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
        if(!map.containsKey(key))
            return -1;
        DoubleListNode node = map.get(key);
        remove(node);
        addToHead(node);
        return node.value;
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
        public DoubleListNode(int x, int y){
            this.key = x;
            this.value = y;
        }
    }
}
