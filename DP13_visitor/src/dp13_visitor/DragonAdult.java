package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public class DragonAdult implements CharacterState {

    @Override
    public void move() {
        System.out.println("The large dragon flies.");
    }

    @Override
    public void breathe() {
        System.out.println("The large dragon breathes burning rays of fire.");
    }

    @Override
    public CharacterState grow() {
        System.out.println("The large dragon grows bigger!");
        return new DragonElder();
    }

    @Override
    public int accept(BonusVisitor bonusVisitor) {
        return bonusVisitor.visit(this);
    }

}
