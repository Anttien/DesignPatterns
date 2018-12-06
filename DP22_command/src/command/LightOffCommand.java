package command;

/**
 * A concrete command. Turns off a light.
 * @author Antti Nieminen
 */
public class LightOffCommand extends Command {

    public LightOffCommand(Light light) {
        super();
        this.light = light;
    }
    
    public void execute() {
        this.light.turnOff();
    }

}
