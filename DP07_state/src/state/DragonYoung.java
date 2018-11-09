package state;

/**
 *
 * @author Antti Nieminen
 */
public class DragonYoung implements DragonState {

    @Override
    public void move() {
        System.out.println("The young dragon jumps around.");
    }

    @Override
    public void claw() {
        System.out.println("The young dragon attacks with it's claws.");
    }

    @Override
    public void breathe() {
        System.out.println("The young dragon breathes warm air.");
    }

    @Override
    public DragonState grow() {
        System.out.println("The young dragon grows bigger!");
        return new DragonAdult();
    }
}
