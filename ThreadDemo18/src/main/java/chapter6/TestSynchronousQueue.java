package chapter6;

import java.util.concurrent.SynchronousQueue;

public class TestSynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);

        new Thread(() -> {
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Thread.sleep(500);
        System.out.println(queue.take());
    }
}
