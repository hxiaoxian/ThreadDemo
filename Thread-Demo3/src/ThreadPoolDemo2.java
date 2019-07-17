import java.util.concurrent.*;

public class ThreadPoolDemo2 {


    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                4,
                4,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10));

        for (int i = 0; i < 5; i++) {
            int index = i;
            Future future = executorService.submit(() -> divTask(200, index));
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();

    }

    private static void divTask(int a, int b) {
        double result = a / b;
        System.out.println(result);
    }
}
