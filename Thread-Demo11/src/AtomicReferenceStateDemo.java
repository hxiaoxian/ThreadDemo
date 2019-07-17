import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceStateDemo {

    //设置默认余额为19，表示这是一个需要被充值的账户
    private static AtomicReference<Integer> money =
            new AtomicReference<Integer>(19);

    public static void main(String[] args) {

        //模拟多个线程同时为用户的账户充值
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) { //CAS模式中的死循环，保证更新成功
                        Integer m = money.get();
                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20)) {
                                System.out.println("余额小于20，充值成功，余额为："
                                        + money.get() + "元！");
                                break;
                            }
                        } else {
                            System.out.println("余额大于20，无需充值！");
                            break;
                        }
                    }
                }
            }, "chongzhi" + i).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                //模拟多次消费
                for (int i = 0; i < 10000; i++) {
                    while (true) {
                        Integer m = money.get();
                        if (m > 10) {
                            System.out.println("大于10元，可以进行消费！");
                            if (money.compareAndSet(m, m - 10)) {
                                System.out.println("消费成功，余额为：" + money.get());
                                break;
                            }
                        } else {
                            System.out.println("没有足够的余额，无法进行消费！");
                            break;
                        }
                    }
                }
            }
        }, "xiaofei").start();

    }
}
