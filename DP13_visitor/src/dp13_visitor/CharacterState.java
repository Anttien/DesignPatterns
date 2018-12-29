package dp13_visitor;

/**
 * Determines the interface for state objects of the {@link Character} 
 * context objects. 
 * 
 * @author Antti Nieminen
 */
public interface CharacterState {
    
    public void accept(BonusVisitor bonusVisitor, Character character);

    public void move();

    public void breathe();
    
    public CharacterState grow();

}
