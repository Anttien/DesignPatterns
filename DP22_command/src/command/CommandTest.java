package command;

/**
 * This project simulates a system of 3 Christmas lights, that are controller by
 * switches that can turn each lights on/off or have them all blink in a
 * sequence. The project implements the command design pattern by decoupling the
 * operation invoking object from the object that performs the operation.
 *
 * @author Antti Nieminen
 */
public class CommandTest {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the receivers
        Light blue = new LightBlue();
        Light red = new LightRed();
        Light green = new LightGreen();

        // Initialize the commands and attach receivers to them
        Command blueOn = new LightOnCommand(blue);
        Command blueOff = new LightOffCommand(blue);
        Command redOn = new LightOnCommand(red);
        Command redOff = new LightOffCommand(red);
        Command greenOn = new LightOnCommand(green);
        Command greenOff = new LightOffCommand(green);

        Command blinkAll = new BlinkAllCommand();
        blinkAll.addCommand(blueOn);
        blinkAll.addCommand(redOn);
        blinkAll.addCommand(greenOn);
        blinkAll.addCommand(greenOff);
        blinkAll.addCommand(redOff);
        blinkAll.addCommand(blueOff);

        // Initializing invokers and attaching commands to them
        Switch switchBlue = new Switch(blueOff, blueOn);
        Switch switchRed = new Switch(redOff, redOn);
        Switch switchGreen = new Switch(greenOff, greenOn);
        Switch switchBlink = new Switch(blinkAll);

        // Push the switches and see the lights turn on and off
        System.out.println("***Switch lights on/off one at a time***");
        switchBlue.push();
        switchBlue.push();
        switchRed.push();
        switchRed.push();
        switchGreen.push();
        switchGreen.push();
        System.out.println("***Push the blink button to start blinking ***");
        switchBlink.push();
        Thread.sleep(5000);
        System.out.println("***Push the blink button to stop blinking ***");
        switchBlink.push();
    }
}
