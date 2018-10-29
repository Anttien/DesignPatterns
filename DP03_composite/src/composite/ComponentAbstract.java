package composite;

import java.util.ArrayList;

/**
 *
 * @author Antti Nieminen
 */
public abstract class ComponentAbstract implements Component {

    private String name;
    private double price;

    @Override
    public ArrayList<Component> getChildComponents() {
        return null;
    }

    @Override
    public void add(Component component) {
        throw new RuntimeException("Component can't have child components");

    }

    @Override
    public void remove(Component component) {
        throw new RuntimeException("Component can't have child components");

    }

}
