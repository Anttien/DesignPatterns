package state;

/**
 *
 * @author Antti Nieminen
 */
public class DragonElder implements DragonState {

    @Override
    public void move() {
        System.out.println("The elder dragon teleports.");
    }

    @Override
    public void claw() {
        System.out.println("The elder dragon attacks with it's mighty claws.");
    }

    @Override
    public void breathe() {
        System.out.println("The elder dragon breathes fireballs.");
    }

    @Override
    public DragonState grow() {
        System.out.println("The dragon is fully grown.");
        return this;
    }
}
