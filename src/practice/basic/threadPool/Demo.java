package practice.basic.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Steve Zou
 */
public class Demo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 5, TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        Demo demo = new Demo();
        demo.workQueueTest();
    }

    public void workQueueTest() {
        LinkedBlockingQueue<Integer> workQueue = new LinkedBlockingQueue<>(10);
        while (true) {
            boolean res = workQueue.offer(1);
            System.out.println(res);
        }

    }
}
