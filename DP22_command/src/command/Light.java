package command;

/**
 * Interface for the concrete receivers. Models a light, that can be switched on/off.
 * @author Antti Nieminen
 */
public interface Light {
    enum LightState{ON, OFF};
    public void turnOn();
    public void turnOff();
}
