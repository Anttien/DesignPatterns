package command;

/**
 * A receiver class. Models a green light, that can be switched on/off.
 * @author Antti Nieminen
 */
public class LightGreen implements Light {
    
    private LightState state;

    public LightGreen() {
        this.state = LightState.OFF;
    }
    
    public void turnOn() {
        if (this.state == LightState.ON) {
            System.out.println("Green light already on!");
        } else {
            this.state = LightState.ON;
            System.out.println("Green light turns on.");
        }
    }

    public void turnOff() {
        if (this.state == LightState.OFF) {
            System.out.println("Green light already off!");
        } else {
            this.state = LightState.OFF;
            System.out.println("Green light turns off.");
        }
    }

}
