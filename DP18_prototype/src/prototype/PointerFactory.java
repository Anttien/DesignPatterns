package prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory is often used with the prototype design pattern to produce the clones.
 * This class produces clones of the {@link Pointer} objects.
 * @author Antti Nieminen
 */
public class PointerFactory {

    private static final Map<String, Pointer> pointerMap = new HashMap<String, Pointer>();

    static {
        pointerMap.put("hour", new PointerHour());
        pointerMap.put("minute", new PointerMinute());
        pointerMap.put("second", new PointerSecond());
    }

    public static Pointer getPointer(String pointerName) {
        return (Pointer) pointerMap.get(pointerName).clone();
    }

}
