
package dp13_visitor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antti Nieminen
 */
public class BonusVisitorDiamondDealer implements BonusVisitor {

    @Override
    public int visit(DragonYoung dragonYoung) {
        System.out.println("A young dragon was visited by the diamond dealer.");
        return 10;
    }

    @Override
    public int visit(DragonAdult dragonAdult) {
        System.out.println("An adult dragon was visited by the diamond dealer.");
        return 50;
    }

    @Override
    public int visit(DragonElder dragonElder) {
        System.out.println("An elder dragon was visited by the diamond dealer.");
        return 100;
    }

    @Override
    public int visit(FrogYoung frogYoung) {
        System.out.println("A young frog was visited by the diamond dealer.");
        return 5;
    }

    @Override
    public int visit(FrogAdult frogAdult) {
        System.out.println("An adult frog was visited by the diamond dealer.");
        return 35;
    }

    @Override
    public int visit(FrogElder frogElder) {
        System.out.println("An elder frog was visited by the diamond dealer.");
        return 75;
    }

}
