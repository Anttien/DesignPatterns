package command;

/**
 * A concrete command. Turns on a light.
 * @author Antti Nieminen
 */
public class LightOnCommand extends Command {

    public LightOnCommand(Light light) {
        super();
        this.light = light;
    }
    
    public void execute() {
        this.light.turnOn();
    }
}
