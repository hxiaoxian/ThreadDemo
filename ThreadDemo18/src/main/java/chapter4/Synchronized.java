package chapter4;

    /**
     * 任意一个对象都拥有自己的监视器，当这个对象由同步块或者这个对象的同步方法调用
     * 时，执行方法的线程必须先获取到该对象的监视器才能进入同步块或者同步方法，而没有获
     * 取到监视器（执行该方法）的线程将会被阻塞在同步块和同步方法的入口处，进入BLOCKED
     * 状态。
     */
    public class Synchronized {
        public static void main(String[] args) {
            // 对Synchronized Class对象进行加锁
            synchronized (Synchronized.class) {
            }
            // 静态同步方法，对Synchronized Class对象进行加锁
            m();
        }

        public static synchronized void m() {
        }
}