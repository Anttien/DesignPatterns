package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public class Dragon {

    private CharacterState state;
    private int diamonds;
    
    public Dragon(CharacterState state) {
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
        this.diamonds += this.state.accept(bonusVisitor);
    }
    
    public int getDiamonds() {
        return this.diamonds;
    }

}
