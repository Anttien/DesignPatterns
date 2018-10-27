package composite;

import java.util.ArrayList;

/**
 *
 * @author Antti Nieminen
 */
public class Motherboard extends ComponentAbstract {

    private String name;

    private double price;

    private ArrayList<Component> childComponents;

    public Motherboard(String name, double price) {
        this.name = name;
        this.price = price;
        childComponents = new ArrayList();
    }

    @Override
    public double getPrice() {
        double totalPrice = price;
        for (Component component : childComponents) {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    @Override
    public ArrayList getChildComponents() {
        return childComponents;
    }

    @Override
    public void add(Component component) {
        childComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        childComponents.remove(component);
    }

}
