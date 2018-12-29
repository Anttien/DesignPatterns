package dp13_visitor;

/**
 * The object responsible of giving diamonds to each character. The amount of
 * diamonds are unique for every {@link CharacterState} object.
 * 
 * @author Antti Nieminen
 */
public class BonusVisitorDiamondDealer implements BonusVisitor {

    @Override
    public void visit(DragonYoung dragonYoung, Object context) {
        System.out.println("A young dragon was visited by the diamond dealer.");
        Dragon dragon = (Dragon) context;
        dragon.addDiamonds(10);
    }

    @Override
    public void visit(DragonAdult dragonAdult, Object context) {
        System.out.println("An adult dragon was visited by the diamond dealer.");
        Dragon dragon = (Dragon) context;
        dragon.addDiamonds(50);
    }

    @Override
    public void visit(DragonElder dragonElder, Object context) {
        System.out.println("An elder dragon was visited by the diamond dealer.");
        Dragon dragon = (Dragon) context;
        dragon.addDiamonds(100);
    }

    @Override
    public void visit(FrogYoung frogYoung, Object context) {
        System.out.println("A young frog was visited by the diamond dealer.");
        Frog frog = (Frog) context;
        frog.addDiamonds(5);
    }

    @Override
    public void visit(FrogAdult frogAdult, Object context) {
        System.out.println("An adult frog was visited by the diamond dealer.");
        Frog frog = (Frog) context;
        frog.addDiamonds(35);
    }

    @Override
    public void visit(FrogElder frogElder, Object context) {
        System.out.println("An elder frog was visited by the diamond dealer.");
        Frog frog = (Frog) context;
        frog.addDiamonds(75);
    }

}
