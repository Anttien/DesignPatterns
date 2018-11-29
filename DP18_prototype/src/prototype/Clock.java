package prototype;

/**
 * This class simulates a clock that updates it's state each second. It is made
 * up of three different {@link Pointer} class objects, that each keeps track of
 * either hours, minutes or seconds.
 *
 * The {@link #getHashCodes()} provides the hashes of the Clock object and all
 * of it's Pointer objects to prove that the clone() method actually generates a
 * deep copy of the object.
 *
 * @author Antti Nieminen
 */
public class Clock implements Runnable, Cloneable {

    private PointerHour pointerHour;
    private PointerMinute pointerMinute;
    private PointerSecond pointerSecond;

    public Clock(PointerHour pointerHour, PointerMinute pointerMinute, PointerSecond pointerSecond) {
        this.pointerHour = pointerHour;
        this.pointerMinute = pointerMinute;
        this.pointerSecond = pointerSecond;
    }

    public void setHour(int hour) {
        this.pointerHour.setPointer(hour);
    }

    public void setMinute(int minute) {
        this.pointerMinute.setPointer(minute);
    }

    public void setSecond(int second) {
        this.pointerSecond.setPointer(second);
    }

    public void tick() {
        this.pointerSecond.tick();
        if (this.pointerSecond.getPointer() == 0) {
            this.pointerMinute.tick();
            if (this.pointerMinute.getPointer() == 0) {
                this.pointerHour.tick();
            }
        }
        System.out.println(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            tick();
        }
    }

    @Override
    public String toString() {
        return pointerHour + ":" + pointerMinute + ":" + pointerSecond;
    }

    public String getHashCodes() {
        return " (Clock hash: " + hashCode() + ", pointer hashes: " + pointerHour.hashCode() + " : " + pointerMinute.hashCode() + " : " + pointerSecond.hashCode() + ")";
    }

    @Override
    public Object clone() {
        Clock clockClone = null;
        try {
            clockClone = (Clock) super.clone();
            clockClone.pointerHour = (PointerHour) PointerFactory.getPointer("hour");
            clockClone.pointerMinute = (PointerMinute) PointerFactory.getPointer("minute");
            clockClone.pointerSecond = (PointerSecond) PointerFactory.getPointer("second");
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return clockClone;
    }

}
