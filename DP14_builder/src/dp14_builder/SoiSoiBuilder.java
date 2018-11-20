package dp14_builder;

import java.util.ArrayList;

public abstract class SoiSoiBuilder {

    protected ArrayList<SoiSoiBurgerComponent> burger;

    public ArrayList<SoiSoiBurgerComponent> getBurger() {
        return burger;
    }

    public void createNewBurger() {
        burger = new ArrayList();
    }

    public abstract void buildBottomBun();

    public abstract void buildSalad();

    public abstract void buildPatty();

    public abstract void buildCheese();

    public abstract void buildTopping();

    public abstract void buildTopBun();

}
