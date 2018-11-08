package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * This class observes {@link ClockTimer} and is receiving all data at once.
 * 
 * In contrast to {@link PointerHour}, {@link PointerMinute} and {@link PointerSecond},
 * this class implements the "push" model Observer pattern. 
 * 
 * Updates every second.
 * 
 * @author Antti Nieminen
 */
public class Clock implements Observer {
    
    private int hour;
    private int minute;
    private int second;

    @Override
    public void update(Observable o, Object arg) {
        int[] time = (int[]) arg;
        this.hour = time[0];
        this.minute = time[1];
        this.second = time[2];
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Clock{" + "hour=" + hour + ", minute=" + minute + ", second=" + second + '}';
    }
    
    

}
