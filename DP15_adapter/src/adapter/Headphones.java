package adapter;

/**
 * Represents the headphones. The guitar player can use this class to hear the
 * outcome of his playing. This is the ending point of the signal chain.
 *
 * @author Antti Nieminen
 */
public class Headphones {

    private BalancedStereoCable signalOut;

    public Headphones() {
        this.signalOut = null;
    }

    /**
     * Returns the outcome of the signal chain.
     *
     * @return the combined signal that the headphones has received.
     */
    public String listen() {
        String signal = signalOut.signalOut();
        // Reset the signal so that it can be heard only once as in real life situation
        signalOut.signalIn("Some 60hz hum", "Some 60hz hum");
        return signal;
    }

    public void signalIn(BalancedStereoCable signalIn) {
        this.signalOut = signalIn;
    }

}
