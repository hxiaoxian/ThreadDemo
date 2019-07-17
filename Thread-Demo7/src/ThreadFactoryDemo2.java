import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryDemo2 {

    public static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("正在执行：Thread ID" + Thread.currentThread().getId() + " is execute " + this.name);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10)) {

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println(t.getId() + "准备执行 " + ((MyTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println(((MyTask) r).name + " 执行完毕");
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }

        };
        for (int i = 0; i < 2; i++) {
            MyTask task = new MyTask("task" + i);
            pool.execute(task);
            Thread.sleep(10);
        }
        pool.shutdown();
    }
}