package observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Antti Nieminen
 */
public class Main {

    public static void main(String[] args) {
        // Create observers
        Observer clock = new Clock();
        Observer pointerHour = new PointerHour();
        Observer pointerMinute = new PointerMinute();
        Observer pointerSecond = new PointerSecond();

        // Create subject / observable
        Observable clocktimer = new ClockTimer(11, 59, 45);

        // Attach observers to subject  
        clocktimer.addObserver(pointerSecond);
        clocktimer.addObserver(pointerMinute);
        clocktimer.addObserver(pointerHour);
        clocktimer.addObserver(clock);

        // Start the clock
        new Thread((Runnable) clocktimer).start();
    }

}
