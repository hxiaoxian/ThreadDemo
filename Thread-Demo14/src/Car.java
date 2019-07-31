public class Car extends Thread {
    private Driver driver;

    public Car(Driver driver) {
        super();
        this.driver = driver;
    }

    @Override
    public void run() {
        driver.driveCar();
    }

}
