import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

    private static int[] value = new int[]{1, 2, 3, 4, 5};

    private static AtomicIntegerArray atomic = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        atomic.getAndSet(2, 100);
        System.out.println(atomic.get(2));
    }
}
