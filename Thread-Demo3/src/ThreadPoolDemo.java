
import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newFixedThreadPool(4);

        // ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 0L,
        //                TimeUnit.MILLISECONDS,
        //                new LinkedBlockingQueue<>(10),
        //                Executors.defaultThreadFactory(),
        //                new ThreadPoolExecutor.AbortPolicy());

         //ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
         //               new LinkedBlockingQueue<>(10),
         //               new ThreadFactory() { //自定义ThreadFactory
         //                   @Override
         //                   public Thread newThread(Runnable r) {
         //                       Thread thread = new Thread(r);
         //                       thread.setName(r.getClass().getName());
         //                       return thread;
         //                   }
         //               },
         //               new ThreadPoolExecutor.AbortPolicy()); //自定义线程拒绝策略


        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());


        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> System.out.println("i:" + index + "executorService"));
        }
        executorService.shutdown();
    }
}
