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
public class Main {

    public static void main(String[] args) {
        System.out.println("Giving birth to a dragon.");
        Dragon dragon = new Dragon(new DragonBaby());
        for (int i = 0; i < 4; i++) {
            dragon.breathe();
            dragon.move();
            dragon.claw();
            dragon.grow();
        }

    }

}
