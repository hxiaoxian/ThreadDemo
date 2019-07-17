
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class FixPoolDemo {

    private static Logger logger = Logger.getLogger(String.valueOf(FixPoolDemo.class));
    private static Runnable getThread(final int i){
        return new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };
    }


    public static void printStackTrace(Class cls) {
        StackTraceElement[] elements = (new Throwable()).getStackTrace();
        StringBuffer buf = new StringBuffer();
        buf.append("Stack for " + cls.getName() + ":");
        for (int i = 0; i < elements.length; i++) {
            buf.append("/n "
                    + elements[i].getClassName()
                    + "."
                    +  elements[i].getMethodName()
                    + "("
                    + elements[i].getFileName()
                    + ":"
                    + elements[i].getLineNumber()
                    + ")");
        }
        System.out.println(buf.toString());
    }



    public  static void main(String []args){
        Long startTime = System.currentTimeMillis();
        ExecutorService fixPool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++){
            fixPool.execute(getThread(i));
           printStackTrace(FixPoolDemo.class);
        }
        fixPool.shutdown();
        Long endTime = System.currentTimeMillis();
        Long time = endTime-startTime;
        System.out.println("任务执行耗费时间："+time);
    }



}
