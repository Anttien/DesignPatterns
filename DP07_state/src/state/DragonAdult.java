package state;

/**
 *
 * @author Antti Nieminen
 */
public class DragonAdult implements DragonState {

    @Override
    public void move() {
        System.out.println("The large dragon flies.");
    }

    @Override
    public void claw() {
        System.out.println("The large dragon attacks with it's mighty claws.");
    }

    @Override
    public void breathe() {
        System.out.println("The large dragon breathes burning rays of fire.");
    }

    @Override
    public DragonState grow() {
        System.out.println("The large dragon grows bigger!");
        return new DragonElder();
    }
}
