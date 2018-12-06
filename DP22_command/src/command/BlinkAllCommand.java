package command;

import java.util.ArrayList;

/**
 * A macro command class. Contains multiple commands that are executed in order.
 *
 * @author Antti Nieminen
 */
public class BlinkAllCommand extends Command {

    private ArrayList<Command> commands;

    public BlinkAllCommand() {
        super();
        commands = new ArrayList<>();
    }

    @Override
    public void execute() {
        if (commands.isEmpty()) {
            System.out.println("No lights flash");
        } else {
            commands.stream().forEach((command) -> {
                command.execute();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
            });

        }
    }

    @Override
    public void addCommand(Command cmd) {
        commands.add(cmd);
    }

}
