package composite;

/**
 *
 * @author Antti Nieminen
 */
public class PowerSupply extends ComponentAbstract {

    private String name;
    private double price;

    public PowerSupply(String name, double price) {
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
