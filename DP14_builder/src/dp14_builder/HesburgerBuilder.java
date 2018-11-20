package dp14_builder;

public abstract class HesburgerBuilder {

    protected StringBuilder burger;

    public StringBuilder getBurger() {
        return burger;
    }

    public void createNewBurger() {
        burger = new StringBuilder();
    }

    public abstract void buildBottomBun();

    public abstract void buildSalad();

    public abstract void buildPatty();

    public abstract void buildCheese();

    public abstract void buildTopping();

    public abstract void buildTopBun();

}
