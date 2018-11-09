package singleton;

import java.util.Random;

/**
 * A spacebee collects pollen from undisclosed places for a certain hive. The
 * flight takes about 2-4 seconds of time.
 *
 * @author Antti Nieminen
 */
public class SpaceBee implements Runnable {

    private static int beeIDcounter = 0;
    private final int id;
    private final SpaceBeeHive hive;

    public SpaceBee(SpaceBeeHive hive) {
        beeIDcounter++;
        id = beeIDcounter;
        this.hive = hive;
        String string = String.format("Hive %d created a new space bee! ID: %d", hive.getId(), id);
        Logger.getInstance().log(Logger.level.INFO, string);
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(2000 + r.nextInt(2000));
            } catch (InterruptedException ex) {
                Logger.getInstance().log(Logger.level.ERROR, ex.toString());
            }
            hive.addSpacePollenToHive(r.nextDouble() * 100, this);
        }
    }

    public int getId() {
        return id;
    }

}
