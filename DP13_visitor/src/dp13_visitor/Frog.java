package dp13_visitor;

/**
 * This is a element part of the visitor design pattern as well as the context 
 * part of the state design pattern.
 *
 * @author Antti Nieminen
 */
public class Frog implements Character {

    private CharacterState state;
    private int diamonds;

    public Frog(CharacterState state) {
        this.state = state;
    }

    public void move() {
        state.move();
    }

    public void breathe() {
        state.breathe();
    }

    public void grow() {
        this.state = state.grow();
    }

    public void accept(BonusVisitor bonusVisitor) {
        this.state.accept(bonusVisitor, this);
    }

    public int getDiamonds() {
        return this.diamonds;
    }

    public void addDiamonds(int diamonds) {
        this.diamonds += diamonds;
    }

}
