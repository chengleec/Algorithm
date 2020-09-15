package design;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenglee
 * @date 2020/8/26 19:36
 * @description
 */
public class PrintABCLock {
    public static String id = "A";
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        while (true){
            new Thread(() -> {
                lock.lock();
                try{
                    while (!id.equals("A")){
                        conditionA.await();
                    }
                    System.out.print("A");
                    id = "B";
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "A").start();
            new Thread(() -> {
                lock.lock();
                try{
                    while (!id.equals("B")){
                        conditionB.await();
                    }
                    System.out.print("B");
                    id = "C";
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "B").start();
            new Thread(() -> {
                lock.lock();
                try{
                    while (!id.equals("C")){
                        conditionC.await();
                    }
                    System.out.print("C");
                    id = "A";
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "C").start();
        }
    }
}
