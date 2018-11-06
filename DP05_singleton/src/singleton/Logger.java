package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logger class that logs beehive information to a file.
 *
 * Implements the Initialization-on-demand holder design pattern, that is a
 * lazy-loaded Singleton. It has a nested static {@link loggerHolder} class,
 * which is loaded only once after the {@link getInstance} is called for the
 * first time. This makes sure that only one Logger class is initialized even in
 * a multi-threaded environment.
 *
 * @author Antti Nieminen
 */
public class Logger {

    private Logger logger;
    private final String logFile = "beehive_log.txt";
    private PrintWriter writer;

    private Logger() {
        try {
            FileWriter filewriter = new FileWriter(logFile);
            writer = new PrintWriter(filewriter, true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static class loggerHolder {

        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return loggerHolder.INSTANCE;
    }

    public void logCollectSpacePollen(SpaceBeeHive hive, double amountOfNewPollen, SpaceBee bee) {
        System.out.printf("Hive %d got %.2f kg of new spacepollen from bee %d. Total amount now: %.2f\n",
                hive.getId(), amountOfNewPollen, bee.getId(), hive.getSpacePollen());
        writer.printf("Hive %d got %.2f kg of new spacepollen from bee %d. Total amount now: %.2f",
                hive.getId(), amountOfNewPollen, bee.getId(), hive.getSpacePollen());
        writer.println();
    }

    public void logNewHive(SpaceBeeHive hive) {
        System.out.printf("New space bee hive created! ID: %d\n", hive.getId());
        writer.printf("New space bee hive created! ID: %d", hive.getId());
        writer.println();
    }

    public void logNewBee(SpaceBeeHive hive, SpaceBee bee) {
        System.out.printf("Hive %d created a new space bee! ID: %d\n", hive.getId(), bee.getId());
        writer.printf("Hive %d created a new space bee! ID: %d", hive.getId(), bee.getId());
        writer.println();
    }

}
