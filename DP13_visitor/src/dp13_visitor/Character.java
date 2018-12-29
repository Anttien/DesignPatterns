package dp13_visitor;

/**
 * Determines the interface for the context objects of the state design pattern.
 * @author Antti Nieminen
 */
public interface Character {

    public void move();

    public void breathe();

    public void grow();

    public void accept(BonusVisitor bonusVisitor);

    public int getDiamonds();

    public void addDiamonds(int diamonds);

}
