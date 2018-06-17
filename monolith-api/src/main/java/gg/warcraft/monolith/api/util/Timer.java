package gg.warcraft.monolith.api.util;

public interface Timer extends Runnable {

    int getSecondsRemaining();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void reset();

    String toString();

    interface Observer {
        void onExpired(Timer timer);
    }
}
