package abstractfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antti Nieminen
 */
public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("__Before graduation__");
        clotheStudent(student, "Adidas");
        student.listClothes();
        System.out.println("__After graduation__");
        clotheStudent(student, "Boss");
        student.listClothes();
    }

    public static void clotheStudent(Student student, String brand) {
        ClothesFactory factory = null;
        Properties properties = new Properties();
        Class c = null;
        try {
            properties.load(new FileInputStream("src/abstractfactory/clothesfactory.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            c = Class.forName(properties.getProperty(brand));
            factory = (ClothesFactory) c.newInstance();
            student.clothe(factory);
            
        } catch (NullPointerException npe) {
            System.out.println("Brand not found!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
