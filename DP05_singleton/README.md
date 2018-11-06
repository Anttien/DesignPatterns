An implementation of a lazy-loaded Singleton design pattern, or more spesifically an initialization-on-demand holder idiom.

One of the more meaningful situations to use Singletons are with loggers. This project implements a logger that keeps track of the amount of spacepollen in multiple spacebeehives. Spacebees collect the pollen, and the hives uses the logger to write their pollen stock amount to a logfile. The beehives and bees are created by factories and are both implementing the `Runnable` interface. To make the `Logger` class thread-safe, it utilizes the initialization-on-demand holder idiom, which makes sure that only one instance of the class is created. This is done by creating a nested static `LoggerHolder` class that is called by the `getInstance()` method. The `LoggerHolder` returns a static instance of the `Logger` class and is only executed when the `getInstance()` method is called, since the JVM won't initialize static nested classes at the initialization phase of execution, but only when they are needed. The class initialization phase is guaranteed to be sequential, so no further synchronization is required.

The bees collect the pollen in a random fashion.

To see the resulting log of a run, see the file [beehive_log.txt](beehive_log.txt).

![alt text](UML%2005%20Singleton.png)
