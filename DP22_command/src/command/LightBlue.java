package command;

/**
 * A receiver class. Models a blue light, that can be switched on/off.
 * @author Antti Nieminen
 */
public class LightBlue implements Light {
    
    private LightState state;

    public LightBlue() {
        this.state = LightState.OFF;
    }

    public void turnOn() {
        if (this.state == LightState.ON) {
            System.out.println("Blue light already on!");
        } else {
            this.state = LightState.ON;
            System.out.println("Blue light turns on.");
        }
    }

    public void turnOff() {
        if (this.state == LightState.OFF) {
            System.out.println("Blue light already off!");
        } else {
            this.state = LightState.OFF;
            System.out.println("Blue light turns off.");
        }
    }

}
