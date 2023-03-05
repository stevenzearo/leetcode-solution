package practice.lock;

import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.concurrent.locks.Lock;

/**
 * @author Steve Zou
 */
public class LockDemo {
    public static void main(String[] args) {
        SimpleTimeMachine simpleTimeMachine = new SimpleTimeMachine();
        int threadCount = 100;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            String threadName = "t->" + i;
            threads[i] = new Thread(() -> {
                ZonedDateTime timeToTravel = ZonedDateTime.now().minusHours(finalI);
                System.out.println(threadName + ": start travel, timeToTravel:" + timeToTravel);
                simpleTimeMachine.travel(threadName, timeToTravel);
                for (int j = 0; j < 10; j++) {
                    System.out.println(threadName + ": CurrentTime:" + simpleTimeMachine.getCurrentTime());
                }
            }, threadName);
        }
        for (Thread t: threads) {
            t.start();
        }
    }

    void test() {

    }

}
