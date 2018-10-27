package composite;

import java.util.ArrayList;

/**
 *
 * @author Antti Nieminen
 */
public interface Component {

    public abstract double getPrice();

    public abstract String getName();

    public abstract ArrayList getChildComponents();

    public abstract void add(Component component);

    public abstract void remove(Component component);

}
