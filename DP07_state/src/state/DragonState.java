/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author Antti Nieminen
 */
public interface DragonState {

    public void move();

    public void claw();

    public void breathe();
    
    public DragonState grow();

}
