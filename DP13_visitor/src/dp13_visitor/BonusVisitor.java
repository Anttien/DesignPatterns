package dp13_visitor;

/**
 * The `Visitor` of the visitor design pattern. It has to have unique visit
 * methods for each class it needs to visit.
 *
 * @author Antti Nieminen
 */
public interface BonusVisitor {

    void visit(DragonYoung dragonYoung, Object context);

    void visit(DragonAdult dragonAdult, Object context);

    void visit(DragonElder dragonElder, Object context);

    void visit(FrogYoung frogYoung, Object context);

    void visit(FrogAdult frogAdult, Object context);

    void visit(FrogElder frogElder, Object context);
}
