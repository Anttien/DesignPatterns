package dp13_visitor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antti Nieminen
 */
public class DragonYoung implements CharacterState {

    @Override
    public void move() {
        System.out.println("The baby dragon waddles.");
    }

    @Override
    public void breathe() {
        System.out.println("The baby dragon coughes and some steam comes out of it's mouth.");
    }

    @Override
    public CharacterState grow() {
        System.out.println("The baby dragon grows bigger!");
        return new DragonAdult();
    }

    @Override
    public int accept(BonusVisitor bonusVisitor) {
        return bonusVisitor.visit(this);
    }

}
