import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest1 {
    //private static List<String> list = new ArrayList<String>();
    private static List<String> list = new CopyOnWriteArrayList<String>();
    public static void main(String []args){
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value = null;
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }
    private static class MyThread extends  Thread{
        MyThread(String name){
            super(name);
        }
        @Override
        public void run(){
            int i = 0;
            while(i++ < 2){
                String val = Thread.currentThread().getName()+"-"+i;
                list.add(val);
                printAll();
            }
        }
    }
}
