package adapter;

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
