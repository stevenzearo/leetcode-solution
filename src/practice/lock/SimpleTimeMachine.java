package practice.lock;

import java.time.ZonedDateTime;

/**
 * @author Steve Zou
 */
public final class SimpleTimeMachine extends AbstractTimeMachine {

    private ZonedDateTime currentTime;

    @Override
    public synchronized void travel(String traveler, ZonedDateTime timeToTravel) {
        currentTime = timeToTravel;
        System.out.println(traveler + ", TimeTraveledTo:" + currentTime);
    }

    public ZonedDateTime getCurrentTime() {
        return currentTime;
    }
}
