package prototype;

/**
 * This program implements the Prototype design pattern. It utilizes the clone()
 * function of the {@link Cloneable} interface. Two clocks are made, from which
 * the latter is a clone. To prove that it is actually a deep copy, the hashes of
 * the objects are printed to the console.
 * @author Antti Nieminen
 */
public class PrototypeDemo {

    public static void main(String[] args) {
        Clock clock = new Clock((PointerHour) PointerFactory.getPointer("hour"),
                (PointerMinute) PointerFactory.getPointer("minute"),
                (PointerSecond) PointerFactory.getPointer("second"));
        clock.setHour(23);
        clock.setMinute(59);
        clock.setSecond(23);
        Thread t = new Thread(clock);
        t.start();

        Clock clock2 = (Clock) clock.clone();
        clock2.setHour(4);
        clock2.setMinute(20);
        clock2.setSecond(0);
        Thread t2 = new Thread(clock2);
        t2.start();
        
        System.out.println(clock.getHashCodes());
        System.out.println(clock2.getHashCodes());
    }

}
