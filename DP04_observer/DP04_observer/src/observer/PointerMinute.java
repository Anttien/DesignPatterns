package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Updates only when a minute passes in the clock.
 * 
 * In contrast to {@link Clock} class, this class implements the "pull" model
 * Observer pattern.
 * 
 * @author Antti Nieminen
 */
public class PointerMinute implements Observer {

    private int minute = -1; // Negative so the first update will print the current minute

    @Override
    public void update(Observable o, Object time) {
        ClockTimer timer = (ClockTimer) o;
        if (timer.getMinute()!= this.minute) {
            this.minute = timer.getMinute();
            System.out.println("Minute: " + timer.getMinute());
        }
    }

}
