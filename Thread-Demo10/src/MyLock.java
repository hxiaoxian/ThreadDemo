import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {
    Helper helper = new Helper();

    private class Helper extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            //如果第一个线程进来，拿到锁，返回TRUE

            //如果第二个线程进来，返回FALSE，拿不到锁
            Thread t = Thread.currentThread();
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (getExclusiveOwnerThread() == t) {
                setState(state + arg);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            //锁的获取和释放需要11对应，那么调用这个方法的线程，一定是当前线程让。
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }
            int state = getState() - arg;
            setState(state);
            if (state == 0) {
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;

        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }
}
