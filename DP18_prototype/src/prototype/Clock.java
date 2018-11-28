package prototype;

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
        String hash = Integer.toString(System.identityHashCode(this));
        return  pointerHour + ":" + pointerMinute + ":" + pointerSecond + " (Clock hash: " + hash + ")";
    }
    
    @Override
    public Object clone() {
        Clock clockClone = null;
        try {
            clockClone = (Clock)super.clone();
            clockClone.pointerHour = (PointerHour)PointerFactory.getPointer("hour");
            clockClone.pointerMinute = (PointerMinute)PointerFactory.getPointer("minute");
            clockClone.pointerSecond = (PointerSecond)PointerFactory.getPointer("second");
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return clockClone;
    }

}
