package practice.lock;

import java.time.ZonedDateTime;

/**
 * @author Steve Zou
 */
public class ConcurrentTimeMachine extends AbstractTimeMachine {
    private volatile ZonedDateTime currentTime;
    @Override
    public void travel(String traveler, ZonedDateTime timeToTravel) {

    }
}
