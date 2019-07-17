


import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
    //建立一个阻塞队列
    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(10);

    public ProducerConsumer() {

    }

    public void start() {
        new Producer().start();
        new Consumer().start();
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumer s = new ProducerConsumer();
        s.start();
    }


    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Object o = new Object();
                    queue.put(o);
                    System.out.println("生产" + o);
                } catch (InterruptedException e) {
                    System.out.println("Producer is interrupted!");
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Object o = queue.take();
                    System.out.println("消费" + o);
                } catch (InterruptedException e) {
                    System.out.println("Producer is interrupted");
                }
            }
        }
    }
}
