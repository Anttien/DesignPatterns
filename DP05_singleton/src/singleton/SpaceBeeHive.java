package singleton;

/**
 * A spacebeehive has a stock of pollen that is collected by spacebees. It keeps
 * a log of the pollen, and labels the log entries by the amount of pollen a bee
 * brings.
 *
 * @author Antti Nieminen
 */
public class SpaceBeeHive {

    private static int hiveIDCounter = 0;
    private double spacePollen;
    private final int id;

    public SpaceBeeHive() {
        hiveIDCounter++;
        id = hiveIDCounter;
        String string = String.format("New space bee hive created! ID: %d", id);
        Logger.getInstance().log(Logger.level.INFO, string);
        createBees(6);
    }

    public void addSpacePollenToHive(double amount, SpaceBee bee) {
        spacePollen += amount;
        String string = String.format("Hive %d got %.2f kg of new spacepollen from bee %d. Total amount now: %.2f",
                getId(), amount, bee.getId(), getSpacePollen());
        if (amount < 10) {
            Logger.getInstance().log(Logger.level.WARNING, string);
        } else if (amount > 90) {
            Logger.getInstance().log(Logger.level.SUPER, string);
        } else {
            Logger.getInstance().log(Logger.level.FINE, string);
        }
    }

    public void createBees(int amount) {
        SpaceBeeFactory beefactory = new SpaceBeeFactory();
        for (int i = 0; i < amount; i++) {
            new Thread(beefactory.createSpaceBee(this)).start();
        }
    }

    public int getId() {
        return id;
    }

    public double getSpacePollen() {
        return spacePollen;
    }

}
