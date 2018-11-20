package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public interface BonusVisitor {   
    int visit(DragonYoung dragonYoung);
    int visit(DragonAdult dragonAdult);
    int visit(DragonElder dragonElder);
    int visit(FrogYoung frogYoung);
    int visit(FrogAdult frogAdult);
    int visit(FrogElder frogElder);
}
