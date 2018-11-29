package prototype;

/**
 * Keeps track of the minutes.
 * @author Antti Nieminen
 */
public class PointerMinute implements Pointer {

    private int pointer = 0;

    public void setPointer(int pointer) {
        if (pointer > 59) {
            this.pointer = 0;
        } else {
            this.pointer = pointer;
        }
    }

    public int getPointer() {
        return pointer;
    }

    public void tick() {
        setPointer(pointer + 1);
    }

    @Override
    public String toString() {
        return Integer.toString(pointer);
    }

    @Override
    public Pointer clone() {
        PointerMinute pointerClone = null;
        try {
            pointerClone = (PointerMinute) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return pointerClone;
    }
}
