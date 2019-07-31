package chapter4;

import java.util.concurrent.TimeUnit;

/**
 * // 加锁当前线程对象
 * public final synchronized void join() throws InterruptedException {
 * // 条件不满足，继续等待
 * while (isAlive()) {
 * wait(0);
 * }
 * // 条件符合，方法返回
 * }
 */

/**
 * 如果一个线程A执行了thread.join()语句，其含义是：当前线程A等待thread线程终止之后才
 * 从thread.join()返回。线程Thread除了提供join()方法之外，还提供了join(long millis)和join(long
 * millis,int nanos)两个具备超时特性的方法。这两个超时方法表示，如果线程thread在给定的超时
 * 时间里没有终止，那么将会从该超时方法中返回。
 */
public class Join {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}