/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp13_visitor;

/**
 *
 * @author Antti Nieminen
 */
public interface CharacterState {
    
    public int accept(BonusVisitor bonusVisitor);

    public void move();

    public void breathe();
    
    public CharacterState grow();

}
