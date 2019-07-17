public class SyncDubbo {

    static class Main {
        public int i = 5;

        public synchronized void operationSup() {
            i--;
            System.out.println("Main print i =" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main {
        public synchronized void operationSub() {
            System.out.println("在子类中取得的值 i = " + i);
            while (i > 0) {
                i--;
                System.out.println("Sub print i = " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Sub sub = new Sub();
                sub.operationSub();
            }
        }).start();
    }
}