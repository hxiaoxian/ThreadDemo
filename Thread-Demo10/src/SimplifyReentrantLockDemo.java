import java.util.concurrent.locks.Condition;

public class SimplifyReentrantLockDemo {

    public static void main(String[] args) {
        SimplifyReentrantLock lock = new SimplifyReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("进入等待!");
                condition.await();
                System.out.println("接收到通知！继续执行！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "conditionAwaitThread").start();
        new Thread(() -> {
            try {
                System.out.println("模拟3秒后发送通知过！");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("发送通知！");
            condition.signal();
            lock.unlock();
        }, "conditionSignalThread").start();
    }
}
