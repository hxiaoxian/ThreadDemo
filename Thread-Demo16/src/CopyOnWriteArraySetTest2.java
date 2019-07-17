import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest2 {
    private static Set<String> set = new CopyOnWriteArraySet<String>();

    public  static void main(String []args){
        int i = 0;
        for (i = 1; i <=10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(1, 4));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
