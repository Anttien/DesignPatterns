package singleton;

public class Main {

    public static void main(String[] args) {
        SpaceBeeHiveFactory beehiveFactory= new SpaceBeeHiveFactory();
        new Thread(beehiveFactory.createSpaceBeeHive()).start();
        new Thread(beehiveFactory.createSpaceBeeHive()).start();
        new Thread(beehiveFactory.createSpaceBeeHive()).start();
        
    }

}
