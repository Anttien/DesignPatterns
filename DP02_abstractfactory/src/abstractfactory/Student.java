package abstractfactory;

import java.util.ArrayList;

/**
 *
 * @author Antti Nieminen
 */
public class Student {
    
    private Shoes shoes = null;
    private Pants pants = null;
    private Shirt shirt = null;
    private Headwear headwear = null;

    public Student() {
    }
    
    public void clothe(ClothesFactory factory) {
        this.headwear = factory.createHeadwear();
        this.shirt = factory.createShirt();
        this.pants = factory.createPants();
        this.shoes = factory.createShoes();
    }
    
    public void listClothes() {
        System.out.println("Current clothes:");
        System.out.println("Headwear: " + headwear);
        System.out.println("Shirt: " + shirt);
        System.out.println("Pants: " + pants);
        System.out.println("Shoes: " + shoes);
        System.out.println();
    }

}
