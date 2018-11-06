package singleton;

import java.util.Random;

public class SpaceBee implements Runnable {

    private static int beeIDcounter = 0;
    private int id;
    private SpaceBeeHive hive;

    public SpaceBee(SpaceBeeHive hive) {
        beeIDcounter++;
        id = beeIDcounter;
        this.hive = hive;
        Logger.getInstance().logNewBee(hive, this);
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(2000 + r.nextInt(2000));
            } catch (InterruptedException ex) {
            }
            hive.addSpacePollenToHive(r.nextDouble() * 100, this);
        }
    }

    public int getId() {
        return id;
    }    

}
