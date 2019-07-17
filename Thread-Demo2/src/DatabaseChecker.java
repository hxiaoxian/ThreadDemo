import java.util.concurrent.CountDownLatch;

public class DatabaseChecker extends BaseHealthChecker {
    public DatabaseChecker(CountDownLatch latch) {
        super("Database Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
