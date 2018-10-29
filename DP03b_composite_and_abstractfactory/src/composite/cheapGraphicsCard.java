package composite;

public class cheapGraphicsCard extends GraphicsCard {

    private String name;

    private double price;

    public cheapGraphicsCard() {
        this.name = "GeForce GTX 1060 6GB";
        this.price = 287.25;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
