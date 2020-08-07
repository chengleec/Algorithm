package others;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenglee
 * @date 2020/8/7 11:19
 * @description
 */
public class BlockingQueue {
    private int capacity;
    private Deque<Integer> q = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try{
            while (q.size() == capacity){
                full.await();
            }
            q.addFirst(element);
            empty.signal();
        }finally{
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try{
            while (q.size() == 0){
                empty.await();
            }
            int res = q.removeLast();
            full.signal();
            return res;
        }finally{
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try{
            return q.size();
        }finally{
            lock.unlock();
        }

    }
}
