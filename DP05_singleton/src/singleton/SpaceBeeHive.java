package singleton;

public class SpaceBeeHive implements Runnable {

    private static int hiveIDCounter = 0;
    private double spacePollen;
    private int id;

    public SpaceBeeHive() {
        hiveIDCounter++;
        id = hiveIDCounter;
        Logger.getInstance().logNewHive(this);
    }

    public void addSpacePollenToHive(double amount, SpaceBee bee) {
        spacePollen += amount;
        Logger.getInstance().logCollectSpacePollen(this, amount, bee);
    }

    @Override
    public void run() {
        SpaceBeeFactory beefactory = new SpaceBeeFactory();
        new Thread(beefactory.createSpaceBee(this)).start();
        new Thread(beefactory.createSpaceBee(this)).start();
        new Thread(beefactory.createSpaceBee(this)).start();        
    }

    public int getId() {
        return id;
    }

    public double getSpacePollen() {
        return spacePollen;
    }

}
