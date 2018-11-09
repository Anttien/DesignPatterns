package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * A simple implementation of a clock that is observable.
 * Keeps track of seconds, minutes and hours.
 * 
 * @author Antti Nieminen
 */
public class ClockTimer extends Observable implements Runnable {
    
    private int hour;
    private int minute;
    private int second;
    private List<Observer> observers;
    
    public ClockTimer(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.observers = new ArrayList();
    }
    
    @Override
    public void run() {
        int counter = 0;
        long startMs = System.currentTimeMillis();
        while (counter < 100) {
            if (System.currentTimeMillis() - startMs >= 1000) {
                startMs = System.currentTimeMillis();
                tick();
                counter++;
                
                setChanged();
                int[] time = new int[]{hour, minute, second};
                notifyObservers(time);
            }
        }
    }
    
    public int getHour() {
        return hour;
    }
    
    public int getMinute() {
        return minute;
    }
    
    public int getSecond() {
        return second;
    }

    // This is done to make the observer push model possible
    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
        super.addObserver(o);
    }
    
    public void tick() {
        if (second == 59) {
            second = 0;
            if (minute == 59) {
                minute = 0;
                if (hour == 23) {
                    hour = 0;
                } else {
                    hour++;
                }
            } else {
                minute++;
            }
        } else {
            second++;
        }
    }
    
}
