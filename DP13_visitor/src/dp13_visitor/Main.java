package dp13_visitor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antti Nieminen
 */
public class Main {

    public static void main(String[] args) {



        BonusVisitor diamondDealer = new BonusVisitorDiamondDealer();
        Dragon dragon = new Dragon(new DragonYoung());
        for (int i = 0; i < 3; i++) {
            dragon.breathe();
            dragon.move();
            dragon.accept(diamondDealer);
            System.out.println("It has " + dragon.getDiamonds() + " diamonds.");
            dragon.grow();

        }
        Frog frog = new Frog(new FrogYoung());
        for (int i = 0; i < 3; i++) {
            frog.breathe();
            frog.move();
            frog.accept(diamondDealer);
            System.out.println("It has " + frog.getDiamonds() + " diamonds.");
            frog.grow();
        }

    }

}
