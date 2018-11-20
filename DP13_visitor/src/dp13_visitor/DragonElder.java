package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public class DragonElder implements CharacterState {

    @Override
    public void move() {
        System.out.println("The elder dragon teleports.");
    }

    @Override
    public void breathe() {
        System.out.println("The elder dragon breathes fireballs.");
    }

    @Override
    public CharacterState grow() {
        System.out.println("The dragon is fully grown.");
        return this;
    }

    @Override
    public int accept(BonusVisitor bonusVisitor) {
        return bonusVisitor.visit(this);
    }

}
