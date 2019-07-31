import java.util.concurrent.Semaphore;

public class SemaphoreDrainPermits {
    public static void main(String[] args) {
        try{
            Semaphore semaphore = new Semaphore(10);
            // availablePermits()返回此Semaphore对象中当前可用的permits个数
            // drainPermits()获取并返回立即可用的所有permits个数，并将可用permits置为0
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
