package composite;

public class expensiveGraphicsCard extends GraphicsCard {

    private String name;

    private double price;

    public expensiveGraphicsCard() {
        this.name = "Nvidia GeForce GTX 1070 Ti";
        this.price = 359.99;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
