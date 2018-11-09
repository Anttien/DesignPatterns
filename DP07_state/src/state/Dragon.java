package state;

/**
 *
 * @author Antti Nieminen
 */
public class Dragon {

    private DragonState state;

    public Dragon(DragonState state) {
        this.state = state;
    }

    public void move() {
        state.move();
    }

    public void claw() {
        state.claw();
    }

    public void breathe() {
        state.breathe();
    }
    
    public void grow() {
        this.state = state.grow();
    }

}
