package adapter;

/**
 * Represents an old analog recording device / mixer that has 4 XLR inputs and 2
 * unbalanced mono outputs. Adds a little 60's grit to the signal. It doesn't
 * actually save the recording anywhere; it can be only listened.
 *
 * This is the adaptee of the adapter design pattern.
 *
 * @author Antti Nieminen
 */
public class LegacyRecorder {

    private XLRCable in1XLR;
    private XLRCable in2XLR;
    private XLRCable in3XLR;
    private XLRCable in4XLR;
    private UnbalancedMonoCable outLPlug;
    private UnbalancedMonoCable outRPlug;

    public void plugInXLR1(XLRCable xlr) {
        this.in1XLR = xlr;
    }

    public void plugInXLR2(XLRCable xlr) {
        this.in2XLR = xlr;
    }

    public void plugInXLR3(XLRCable xlr) {
        this.in3XLR = xlr;
    }

    public void plugInXLR4(XLRCable xlr) {
        this.in4XLR = xlr;
    }

    public UnbalancedMonoCable monitorMonoOutL() {
        String summedSignal = sumXLRSignalsToMonoSignal() + "(with a slight tasty analog distortion)";
        this.outLPlug = new UnbalancedMonoCable();
        this.outLPlug.signalIn(summedSignal);
        return outLPlug;
    }

    public UnbalancedMonoCable monitorMonoOutR() {
        String summedSignal = sumXLRSignalsToMonoSignal() + "(with a slight tasty analog distortion)";
        this.outRPlug = new UnbalancedMonoCable();
        this.outRPlug.signalIn(summedSignal);
        return outRPlug;
    }

    private String sumXLRSignalsToMonoSignal() {
        StringBuilder signalBuilder = new StringBuilder();
        if (in1XLR != null) {
            signalBuilder.
                    append(in1XLR.signalOut()).
                    append(" ");
        }
        if (in2XLR != null) {
            signalBuilder.
                    append(in2XLR.signalOut()).
                    append(" ");
        }
        if (in3XLR != null) {
            signalBuilder.
                    append(in3XLR.signalOut()).
                    append(" ");
        }
        if (in4XLR != null) {
            signalBuilder.
                    append(in4XLR.signalOut()).
                    append(" ");
        }
        return signalBuilder.toString();
    }

}
