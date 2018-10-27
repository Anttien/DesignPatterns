package composite;

/**
 *
 * @author Antti Nieminen
 */
public class SSD extends ComponentAbstract {

    private String name;
    private double price;

    public SSD(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
