import java.util.concurrent.Semaphore;

public class SemaphoreDrainPermits {
    public static void main(String[] args) {
        try{
            Semaphore semaphore = new Semaphore(10);
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            System.out.println("Semaphore drain permits" + semaphore.drainPermits());
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
            System.out.println("Semaphore drain permits" + semaphore.drainPermits());
            System.out.println("Semaphore available permits: " + semaphore.availablePermits());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
