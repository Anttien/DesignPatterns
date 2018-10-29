package composite;

import java.util.ArrayList;

public class expensiveMotherboard extends Motherboard {

    private String name;

    private double price;

    private ArrayList<Component> childComponents;

    public expensiveMotherboard() {
        this.name = "Gigabyte Z370P D3";
        this.price = 96.99;
        childComponents = new ArrayList();
    }

    @Override
    public ArrayList<Component> getChildComponents() {
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

    @Override
    public double getPrice() {
        double totalPrice = price;
        for (Component component : childComponents) {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    public String getName() {
        return name;
    }

}
