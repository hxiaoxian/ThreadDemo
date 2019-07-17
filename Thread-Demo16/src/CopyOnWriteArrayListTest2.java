import java.util.List;

import java.util.Random;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest2 {
    private static  List<String> list = new CopyOnWriteArrayList<String>();
    public  static void main(String []args){
           int i = 0;
        for (i = 1; i <=2; i++) {
            new Thread(() -> {
                list.add(String.valueOf(new Random(1000)));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
