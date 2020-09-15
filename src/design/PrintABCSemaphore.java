package design;

import java.util.concurrent.Semaphore;

/**
 * @author chenglee
 * @date 2020/8/26 19:41
 * @description
 */
public class PrintABCSemaphore {
    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        while (true){
            new Thread(() -> {
                try{
                    semaphoreA.acquire();
                    System.out.print("A");
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "A").start();
            new Thread(() -> {
                try{
                    semaphoreB.acquire();
                    System.out.print("B");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "B").start();
            new Thread(() -> {
                try{
                    semaphoreC.acquire();
                    System.out.print("C");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "C").start();
        }
    }
}
