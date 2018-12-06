package command;

/**
 * The invoker class that simulates an on/off type switch as well as a button
 * type switch. Which type of switch is used depends on how many commands are
 * attached to the object.
 *
 * @author Antti Nieminen
 */
public class Switch {

    private Command cmd1;
    private Command cmd2;
    private Command[] switchState = new Command[1];
    private Thread continuousAction;
    private boolean stopAction;

    /**
     * A button type switch that starts/stop the action
     */
    public Switch(Command cmd) {
        this.cmd1 = cmd;
        continuousAction = new Thread() {
            public void run() {
                while (!stopAction) {
                    cmd1.execute();
                }
            }
        };
    }

    /**
     * An on/off type switch that remembers it's state
     */
    public Switch(Command cmd1, Command cmd2) {
        this.cmd1 = cmd1;
        this.cmd2 = cmd2;
        switchState[0] = cmd1;
    }

    public void push() {
        if (this.cmd2 == null) {
            pushButton();
        } else {
            pushSwitch();
        }
    }

    private void pushButton() {
        if (continuousAction.isAlive()) {
            stopAction = true;
        } else {
            stopAction = false;
            continuousAction.start();
        }
    }

    private void pushSwitch() {
        if (switchState[0] == cmd1) {
            cmd2.execute();
            switchState[0] = cmd2;
        } else if (switchState[0] == cmd2) {
            cmd1.execute();
            switchState[0] = cmd1;
        }
    }

}
