package abstractfactory;

/**
 *
 * @author Antti Nieminen
 */
public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        ClothesFactory factory;
        student.listClothes();
        factory = new AdidasClothesFactory();
        student.clothe(factory);
        student.listClothes();
        factory = new BossClothesFactory();
        student.clothe(factory);
        student.listClothes();
    }
}
