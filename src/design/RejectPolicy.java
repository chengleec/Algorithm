package design;

/**
 * @author chenglee
 * @date 2020/9/15 10:00
 * @description
 */
@FunctionalInterface
interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}
