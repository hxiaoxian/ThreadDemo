package chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;


public class MultiThread {
    public static void main(String[] args) {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }


        // [6] Monitor Ctrl-Break
        // [5] Attach Listener      负责接收外部命令，对该命令进行执行并且把结果返回给发送者
        // [4] Signal Dispatcher    分发处理发送给JVM信号的线程
        // [3] Finalizer            调用对象finalize方法的线程
        // [2] Reference Handler    清除Reference的线程
        // [1] main                 main线程，用户程序入口
    }
}
