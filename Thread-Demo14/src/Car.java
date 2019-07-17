public class Car extends Thread {
    private Driver driver;

    public Car(Driver driver) {
        super();
        this.driver = driver;
    }

    public void run() {
        driver.driveCar();
    }

}
