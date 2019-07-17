import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("线程等待");
            condition.await();
            System.out.println("Thread is going on");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test2 t = new Test2();
        Thread thread = new Thread(t);
        thread.start();
        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        System.out.println("线程唤醒");
        lock.unlock();
    }
}
