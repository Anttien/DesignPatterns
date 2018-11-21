package adapter;

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
