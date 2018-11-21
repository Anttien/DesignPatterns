package adapter;

public class Headphones {

    private BalancedStereoCable signalOut;

    public Headphones() {
        this.signalOut = null;
    }

    public String listen() {
        String signal = signalOut.signalOut();
        signalOut.signalIn("Some 60hz hum", "Some 60hz hum");
        return signal;
    }

    public void signalIn(BalancedStereoCable signalIn) {
        this.signalOut = signalIn;
    }

}
