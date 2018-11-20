package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public class FrogAdult implements CharacterState {

    @Override
    public void move() {
        System.out.println("The large frog jumps around.");
    }

    @Override
    public void breathe() {
        System.out.println("The large frog breathes out a beam of fire.");
    }

    @Override
    public CharacterState grow() {
        System.out.println("The large frog grows bigger!");
        return new FrogElder();
    }

    @Override
    public int accept(BonusVisitor bonusVisitor) {
        return bonusVisitor.visit(this);
    }
}
