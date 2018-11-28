package prototype;

public class PointerSecond implements Cloneable {

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
        PointerSecond pointerClone = null;
        try {
            pointerClone = (PointerSecond) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return pointerClone;
    }

}
