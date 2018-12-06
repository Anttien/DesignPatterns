package command;

/**
 * Interface for the concrete receivers.
 * @author Antti Nieminen
 */
public interface Light {
    enum LightState{ON, OFF};
    public void turnOn();
    public void turnOff();
}
