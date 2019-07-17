import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest1 {
    //private static Set<String> set = new HashSet<String>();
    private static Set<String> set = new CopyOnWriteArraySet<String>();
    public static void main(String[] args) {

        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value = null;
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            int i = 0;
            while (i++ < 2) {
                String val = Thread.currentThread().getName() + "-" + i;
                set.add(val);
                printAll();
            }
        }
    }
}