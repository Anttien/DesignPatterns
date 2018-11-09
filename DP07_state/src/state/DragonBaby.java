package state;

/**
 *
 * @author Antti Nieminen
 */
public class DragonBaby implements DragonState {

    @Override
    public void move() {
        System.out.println("The baby dragon waddles.");
    }

    @Override
    public void claw() {
        System.out.println("The baby dragon attacks with it's soft claws but stumbles.");
    }

    @Override
    public void breathe() {
        System.out.println("The baby dragon coughes and some steam comes out of it's mouth.");
    }

    @Override
    public DragonState grow() {
        System.out.println("The baby dragon grows bigger!");
        return new DragonYoung();
    }

}
