package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public class FrogYoung implements CharacterState {

    @Override
    public void move() {
        System.out.println("The tadpole swims.");
    }

    @Override
    public void breathe() {
        System.out.println("The tadpole breathes and the water bubbles.");
    }

    @Override
    public CharacterState grow() {
        System.out.println("The tadpole grows bigger!");
        return new FrogAdult();
    }

    @Override
    public int accept(BonusVisitor bonusVisitor) {
        return bonusVisitor.visit(this);
    }

}
