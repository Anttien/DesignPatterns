package dp14_builder;

import java.util.ArrayList;

/**
 * The Director of the build design pattern specialized for building
 * SoiSoiBurgers.
 *
 * @author Antti Nieminen
 */
public class SoiSoiWaiter {

    private final SoiSoiBuilder burgerBuilder;

    public SoiSoiWaiter(SoiSoiBuilder burgerBuilder) {
        this.burgerBuilder = burgerBuilder;
    }

    public void constructBurger() {
        burgerBuilder.createNewBurger();
        burgerBuilder.buildBottomBun();
        burgerBuilder.buildSalad();
        burgerBuilder.buildPatty();
        burgerBuilder.buildCheese();
        burgerBuilder.buildTopping();
        burgerBuilder.buildTopBun();
    }

    public ArrayList<SoiSoiBurgerComponent> getBurger() {
        return burgerBuilder.getBurger();
    }

}
