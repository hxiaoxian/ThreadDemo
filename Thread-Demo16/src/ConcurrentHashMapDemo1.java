import java.util.*;
import java.util.concurrent.*;

public class ConcurrentHashMapDemo1 {

    //private static Map<String, String> map = new HashMap<String, String>();
    private static Map<String, String> map = new ConcurrentHashMap<String, String>();
    public static void main(String[] args) {

        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String key, value;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            key = (String)entry.getKey();
            value = (String)entry.getValue();
            System.out.print(key+" - "+value+", ");
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
                String val = Thread.currentThread().getName()+i;
                map.put(String.valueOf(i), val);
                printAll();
            }
        }
    }
}