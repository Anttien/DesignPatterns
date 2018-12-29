package adapter;

/**
 * Represents a modern recorder. The guitarist can plug his guitar and
 * headphones straight to the device. It doesn't actually save the recording
 * anywhere; it can be only listened.
 *
 * @author Antti Nieminen
 */
public class ModernRecorder implements GuitarRecorder {

    private UnbalancedMonoCable guitarIn;
    private BalancedStereoCable headphonesOut;
    private Headphones headphones;

    @Override
    public void plugInGuitar(UnbalancedMonoCable guitarIn) {
        this.guitarIn = guitarIn;
    }

    @Override
    public void plugInHeadphones(Headphones headphones) {
        this.headphones = headphones;
    }

    @Override
    public BalancedStereoCable headphonesOut() {
        headphonesOut = new BalancedStereoCable();
        headphonesOut.signalIn(guitarIn.signalOut(), guitarIn.signalOut());
        return headphonesOut;
    }

    @Override
    public void record(String signalIn) {
        guitarIn.signalIn(signalIn);
        headphones.signalIn(headphonesOut());
    }

}
