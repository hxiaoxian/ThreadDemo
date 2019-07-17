import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {
    private static CountDownLatch doneSignal;

    public static void main(String[] args) {

        try {
            doneSignal = new CountDownLatch(5);
            // 新建5个任务
            for(int i = 0; i < 5; i++)
                new InnerThread().start();
            System.out.println("main线程开始等待");
            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();
            System.out.println("main线程等待完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}