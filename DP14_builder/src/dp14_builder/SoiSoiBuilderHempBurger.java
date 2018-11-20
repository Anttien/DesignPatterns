package dp14_builder;

/**
 * A concrete builder. Builds burgers that consist of objects.
 *
 * @author Antti Nieminen
 */
public class SoiSoiBuilderHempBurger extends SoiSoiBuilder {

    @Override
    public void buildBottomBun() {
        burger.add(new SoiSoiBurgerComponent("A half of a whole wheat bun"));
    }

    @Override
    public void buildSalad() {
        burger.add(new SoiSoiBurgerComponent("Some spinach"));
    }

    @Override
    public void buildPatty() {
        burger.add(new SoiSoiBurgerComponent("A hemp patty"));
    }

    @Override
    public void buildCheese() {
        burger.add(new SoiSoiBurgerComponent("A slice of caramelized goat cheese"));
    }

    @Override
    public void buildTopping() {
        burger.add(new SoiSoiBurgerComponent("Some onions"));
        burger.add(new SoiSoiBurgerComponent("Some pickels"));
    }

    @Override
    public void buildTopBun() {
        burger.add(new SoiSoiBurgerComponent("A half of a whole wheat bun with some sesame seeds\n"));
    }

}
