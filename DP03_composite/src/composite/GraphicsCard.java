package composite;

/**
 *
 * @author Antti Nieminen
 */
public class GraphicsCard extends ComponentAbstract {

    private String name;

    private double price;

    public GraphicsCard(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
