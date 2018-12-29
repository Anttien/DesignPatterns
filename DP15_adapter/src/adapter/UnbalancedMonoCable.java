package adapter;

/**
 * A class that represents an unbalanced mono cable. Transmits the audio signal
 * as a String.
 *
 * @author Antti Nieminen
 */
public class UnbalancedMonoCable {

    private String signalOut;

    public UnbalancedMonoCable() {
        this.signalOut = "";
    }

    public void signalIn(String signalIn) {
        signalOut = signalIn;
    }

    public String signalOut() {
        return signalOut;
    }

}
