public class Run {
    public static void main(String []args){
        Driver driver = new Driver();
        for(int i = 0 ; i < 5; i++){
            (new Car(driver)).start();
        }
    }
}
