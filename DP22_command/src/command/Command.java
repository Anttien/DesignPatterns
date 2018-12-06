package command;

/**
 * Abstract class for the concrete command classes. Has a default implementation
 * for the addCommand method that is used only in composite (macro) commands.
 * @author Antti Nieminen
 */
public abstract class Command {

    protected Light light;
    
    public abstract void execute();
    public void addCommand(Command cmd) {
        System.out.println("Can't add command to a non-macro command");
    }

}
