package others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author chenglee
 * @date 2020/6/25 21:23
 * @description
 */
public class LRUCacheOn {
    private int capacity;
    private LinkedList<Integer> list = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    public LRUCacheOn(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        list.remove(Integer.valueOf(key));
        list.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key,value);
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
        }else {
            if (map.size() == capacity){
                map.remove(list.getLast());
                list.removeLast();
            }
            map.put(key,value);
            list.addFirst(key);
        }
    }
}
