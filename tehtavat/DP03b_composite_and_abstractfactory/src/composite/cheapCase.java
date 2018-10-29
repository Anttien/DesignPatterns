package composite;

import java.util.ArrayList;

public class cheapCase extends Case {

    private String name;

    private double price;

    private ArrayList<Component> childComponents;

    public cheapCase() {
        this.name = "Fractal Design Focus G";
        this.price = 42.99;
        childComponents = new ArrayList();
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
