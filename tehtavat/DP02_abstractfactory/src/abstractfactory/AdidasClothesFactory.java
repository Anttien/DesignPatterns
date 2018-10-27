package abstractfactory;

/**
 *
 * @author Antti Nieminen
 */
public class AdidasClothesFactory implements ClothesFactory {

    @Override
    public Shoes createShoes() {
        return new AdidasShoes();
    }

    @Override
    public Pants createPants() {
        return new AdidasPants();
    }

    @Override
    public Shirt createShirt() {
        return new AdidasShirt();
    }

    @Override
    public Headwear createHeadwear() {
        return new AdidasHeadwear();
    }

}
