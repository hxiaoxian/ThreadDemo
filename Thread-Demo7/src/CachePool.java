import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachePool {
    private static Runnable getThread(final int i){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

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
    public static  void main(String args[]){
        ExecutorService cachePool = Executors.newCachedThreadPool();
        Long startTime = System.currentTimeMillis();
        for (int i=1;i<=2;i++){
            cachePool.execute(getThread(i));
            printStackTrace(CachePool.class);
        }
        Long endTime = System.currentTimeMillis();
        Long time = endTime-startTime;
        System.out.println("任务执行耗费时间："+time);
    }
}