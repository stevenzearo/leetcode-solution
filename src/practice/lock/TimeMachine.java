package practice.lock;

import java.time.ZonedDateTime;

/**
 * @author Steve Zou
 */
public interface TimeMachine {
    void travel(String traveler, ZonedDateTime timeToTravel);
}
