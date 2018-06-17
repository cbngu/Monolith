package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.TimeUtils;
import gg.warcraft.monolith.api.util.Timer;

import java.util.HashSet;
import java.util.Set;

public class SimpleTimer implements Timer {
    private final int timerInSeconds;
    private final boolean repeat;

    final Set<Observer> observers;

    int minutesRemaining;
    int secondsRemaining;

    public SimpleTimer(int timerInSeconds, boolean repeat) {
        this.timerInSeconds = timerInSeconds;
        this.observers = new HashSet<>();
        if (timerInSeconds == 0) {
            this.repeat = false;
        } else {
            this.repeat = repeat;
            reset();
        }
    }

    @Override
    public int getSecondsRemaining() {
        return secondsRemaining + minutesRemaining * 60;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void reset() {
        minutesRemaining = timerInSeconds / TimeUtils.SECONDS_PER_MINUTE;
        secondsRemaining = timerInSeconds - minutesRemaining * TimeUtils.SECONDS_PER_MINUTE;
    }

    @Override
    public void run() {
        secondsRemaining -= 1;
        if (secondsRemaining < 0) {
            minutesRemaining -= 1;
            if (minutesRemaining < 0) {
                minutesRemaining = 0;
                secondsRemaining = 0;
                if (repeat) {
                    reset();
                    run();
                }
            } else {
                secondsRemaining = 59;
            }
        }
    }

    @Override
    public String toString() {
        return (minutesRemaining < 10 ? "0" + minutesRemaining : "" + minutesRemaining) + ":" +
                (secondsRemaining < 10 ? "0" + secondsRemaining : "" + secondsRemaining);
    }
}
