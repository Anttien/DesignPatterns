package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public class FrogElder implements CharacterState {

    @Override
    public void move() {
        System.out.println("The elder frog teleports to another lily pod.");
    }

    @Override
    public void breathe() {
        System.out.println("The elder frog breathes fireballs.");
    }

    @Override
    public CharacterState grow() {
        System.out.println("The frog is fully grown.");
        return this;
    }

    @Override
    public int accept(BonusVisitor bonusVisitor) {
        return bonusVisitor.visit(this);
    }
}
