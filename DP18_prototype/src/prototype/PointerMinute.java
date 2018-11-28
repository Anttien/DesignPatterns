package prototype;

public class PointerMinute implements Cloneable {

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
    public Object clone() {
        PointerMinute pointerClone = null;
        try {
            pointerClone = (PointerMinute) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return pointerClone;
    }
}
