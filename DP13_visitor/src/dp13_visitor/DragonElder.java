package dp13_visitor;

/**
 * A state object for the {@link Dragon} character/context.
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
    public void accept(BonusVisitor bonusVisitor, Character character) {
        bonusVisitor.visit(this, character);
    }

}
