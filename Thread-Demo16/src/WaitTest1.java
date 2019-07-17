public class WaitTest1 {
    public static void main(String[] args) {
        ThreadA t = new ThreadA("t");
        synchronized(t) { // 通过synchronized(t)获取“对象t的同步锁”
            try {
                System.out.println(Thread.currentThread().getName()+" start t");
                t.start();

                System.out.println(Thread.currentThread().getName()+" block");
                // 主线程等待
                t.wait();

                System.out.println(Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread{
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (this) { // 通过synchronized(this)获取“当前对象的同步锁”
                System.out.println(Thread.currentThread().getName()+" wake up ");
                notify();    // 唤醒“当前对象上的等待线程”
            }
        }
    }
}