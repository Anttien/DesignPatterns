package singleton;

public class Main {

    public static void main(String[] args) {
        SpaceBeeHiveFactory beehiveFactory= new SpaceBeeHiveFactory();
        beehiveFactory.createSpaceBeeHive();
        beehiveFactory.createSpaceBeeHive();
        beehiveFactory.createSpaceBeeHive();
       
    }

}
