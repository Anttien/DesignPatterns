package command;

/**
 * A receiver class.
 * @author Antti Nieminen
 */
public class LightRed implements Light {

    private LightState state;

    public LightRed() {
        this.state = LightState.OFF;
    }

    public void turnOn() {
        if (this.state == LightState.ON) {
            System.out.println("Red light already on!");
        } else {
            this.state = LightState.ON;
            System.out.println("Red light turns on.");
        }
    }

    public void turnOff() {
        if (this.state == LightState.OFF) {
            System.out.println("Red light already off!");
        } else {
            this.state = LightState.OFF;
            System.out.println("Red light turns off.");
        }
    }

}
