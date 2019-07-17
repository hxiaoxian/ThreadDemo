import java.util.concurrent.Semaphore;

public class SemaphoreAvaliablePermits {
    public static void main(String[] args) {
        try{
            //查看现在可用的信号量
            Semaphore semaphore = new Semaphore(10);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.acquire(2);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.acquire(3);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.acquire(4);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.release();
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.release(2);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.release(3);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.release(4);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
