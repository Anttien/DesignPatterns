package abstractfactory;

/**
 *
 * @author Antti Nieminen
 */
public class BossClothesFactory implements ClothesFactory {

    @Override
    public Shoes createShoes() {
        return new BossShoes();
    }

    @Override
    public Pants createPants() {
        return new BossPants();
    }

    @Override
    public Shirt createShirt() {
        return new BossShirt();
    }

    @Override
    public Headwear createHeadwear() {
        return new BossHeadwear();
    }

}
