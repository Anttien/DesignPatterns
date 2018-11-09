package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

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
        Timer timer = new Timer();
        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                tick();
                setChanged();
                int[] time = new int[]{hour, minute, second};
                notifyObservers(time); 
            }
        };
        
        // Do the task every second
        timer.scheduleAtFixedRate(timertask, 0, 1000);
        
        // Cancel the task after about 10 seconds
        try {
            Thread.sleep(10000);
            timer.cancel();
        } catch (InterruptedException ex) {
            System.out.println(ex);
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
