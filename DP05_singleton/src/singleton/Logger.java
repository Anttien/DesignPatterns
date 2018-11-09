package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

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

    public static enum level {
        ERROR,
        WARNING,
        INFO,
        FINE,
        SUPER        
    }

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

    public void log(level level, String message) {
        System.out.println(Instant.now() + " - " + level + " - " + message);
        writer.print(Instant.now() + " - " + level + " - " + message);
        writer.println();
    }
}
