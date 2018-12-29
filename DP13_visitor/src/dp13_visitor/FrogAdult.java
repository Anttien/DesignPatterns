package dp13_visitor;

/**
 * A state object for the {@link Frog} character/context.
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
    public void accept(BonusVisitor bonusVisitor, Character character) {
        bonusVisitor.visit(this, character);
    }
}
