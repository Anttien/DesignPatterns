package dp14_builder;

/**
 * A concrete builder. Builds StringBuilder type burgers.
 *
 * @author Antti Nieminen
 */
public class HesburgerBuilderSeitanBurger extends HesburgerBuilder {

    @Override
    public void buildBottomBun() {
        burger.append("A half of a wheat bun\n");
    }

    @Override
    public void buildSalad() {
        burger.append("Some fresh salad\n");
    }

    @Override
    public void buildPatty() {
        burger.append("A seitan patty\n");
    }

    @Override
    public void buildCheese() {
        burger.append("A slice of cheddar\n");
    }

    @Override
    public void buildTopping() {
        burger.append("Some caramelized red onions\n");
        burger.append("Some pickels\n");
    }

    @Override
    public void buildTopBun() {
        burger.append("A half of a wheat bun with some sesame seeds\n");
    }

}
