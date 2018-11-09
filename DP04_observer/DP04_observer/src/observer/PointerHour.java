package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Updates only when an hour passes in the clock.
 * 
 * In contrast to {@link Clock} class, this class implements the "pull" model
 * Observer pattern.
 * 
 * @author Antti Nieminen
 */
public class PointerHour implements Observer {
    
    private int hour = -1; // Negative so the first update will print the current hour

    @Override
    public void update(Observable o, Object time) {
        ClockTimer timer = (ClockTimer) o;
        if (timer.getHour() != this.hour) {
            this.hour = timer.getHour();
            System.out.println("Hour: " + this.hour);
        }  
    }
}
