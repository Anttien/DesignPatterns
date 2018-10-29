package composite;

/**
 *
 * @author Antti Nieminen
 */
public class CPU extends ComponentAbstract {

    private String name;
    private double price;

    public CPU(String name, double price) {
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
