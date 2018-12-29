package adapter;

/**
 * A class that represents an XLR cable. Transmits the audio signal as a String.
 *
 * @author Antti Nieminen
 */
public class XLRCable {

    private String signalOut;

    public XLRCable() {
        this.signalOut = "";
    }

    public String signalOut() {
        return signalOut;
    }

    public void signalIn(String signalIn) {
        this.signalOut = signalIn;
    }

}
