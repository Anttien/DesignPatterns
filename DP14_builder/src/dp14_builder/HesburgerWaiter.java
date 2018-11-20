package dp14_builder;

/**
 * The director of the build design pattern specialized for building
 * HesburgerBurgers.
 *
 * @author Antti Nieminen
 */
public class HesburgerWaiter {

    private final HesburgerBuilder burgerBuilder;

    public HesburgerWaiter(HesburgerBuilder burgerBuilder) {
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

    public StringBuilder getBurger() {
        return burgerBuilder.getBurger();
    }

}
