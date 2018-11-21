package adapter;

public class LegacyRecorderAdapter implements GuitarRecorder {

    private UnbalancedMonoCable guitarIn;
    private BalancedStereoCable headphonesOut;
    private XLRCable unbalancedMonoToXLRConverter;
    private LegacyRecorder legacyRecorder;
    private Headphones headphones;

    public LegacyRecorderAdapter(LegacyRecorder legacyRecorder) {
        this.legacyRecorder = legacyRecorder;
    }

    @Override
    public void plugInGuitar(UnbalancedMonoCable guitarIn) {
        this.guitarIn = guitarIn;
        unbalancedMonoToXLRConverter = new XLRCable();
        legacyRecorder.plugInXLR1(unbalancedMonoToXLRConverter);
    }

    @Override
    public void plugInHeadphones(Headphones headphones) {
        this.headphones = headphones;
    }

    @Override
    public BalancedStereoCable headphonesOut() {
        UnbalancedMonoCable legacyMonoOutL = legacyRecorder.monitorMonoOutL();
        UnbalancedMonoCable legacyMonoOutR = legacyRecorder.monitorMonoOutR();
        headphonesOut = new BalancedStereoCable();
        headphonesOut.signalIn(legacyMonoOutL.signalOut(), legacyMonoOutR.signalOut());
        return headphonesOut;
    }

    @Override
    public void record(String signalIn) {
        guitarIn.signalIn(signalIn);
        unbalancedMonoToXLRConverter.signalIn(guitarIn.signalOut());
        headphones.signalIn(headphonesOut());
    }

}
