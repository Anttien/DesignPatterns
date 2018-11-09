
package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Updates whenever a second passes in the clock.
 * 
 * In contrast to {@link Clock} class, this class implements the "pull" model
 * Observer pattern.
 * 
 * @author Antti Nieminen
 */
public class PointerSecond implements Observer {

    @Override
    public void update(Observable o, Object time) {
        ClockTimer timer = (ClockTimer) o;
        System.out.println("Second: " + timer.getSecond());
    }

}
