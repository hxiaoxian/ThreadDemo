import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingPoolDemo {
    private static Runnable getThread(final int i) {
        return new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService singPool = Executors.newSingleThreadExecutor();
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            singPool.execute(getThread(i));
        }
        singPool.shutdown();
        Thread.sleep(4000);
        Long endTime = System.currentTimeMillis();
        Long time = endTime-startTime;
        System.out.println("任务执行耗费时间："+time);
    }
}