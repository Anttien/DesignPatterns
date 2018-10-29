package composite;

import java.util.ArrayList;

/**
 *
 * @author Antti Nieminen
 */
public class Case extends ComponentAbstract {

    private String name;

    private double price;

    private ArrayList<Component> childComponents;

    public Case(String name, double price) {
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
    public ArrayList<Component> getChildComponents() {
        ArrayList<Component> allChildComponents = new ArrayList();
        allChildComponents.add(this);
        for (Component component : childComponents) {
            allChildComponents.add(component);
            allChildComponents.addAll(component.getChildComponents());
        }
        return allChildComponents;
    }

    @Override
    public void add(Component component) {
        childComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        childComponents.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

}
