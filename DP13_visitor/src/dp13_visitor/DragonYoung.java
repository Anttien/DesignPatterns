package dp13_visitor;

/**
 * A state object for the {@link Dragon} character/context.
 * 
 * @author Antti Nieminen
 */
public class DragonYoung implements CharacterState {

    @Override
    public void move() {
        System.out.println("The young dragon waddles.");
    }

    @Override
    public void breathe() {
        System.out.println("The young dragon coughes and some steam comes out of it's mouth.");
    }

    @Override
    public CharacterState grow() {
        System.out.println("The young dragon grows bigger!");
        return new DragonAdult();
    }

   @Override
    public void accept(BonusVisitor bonusVisitor, Character character) {
        bonusVisitor.visit(this, character);
    }

}
