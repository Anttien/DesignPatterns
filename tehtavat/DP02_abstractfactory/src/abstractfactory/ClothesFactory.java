package abstractfactory;

/**
 *
 * @author Antti Nieminen
 */
public interface ClothesFactory {

    public abstract Shoes createShoes();

    public abstract Pants createPants();

    public abstract Shirt createShirt();

    public abstract Headwear createHeadwear();
}
