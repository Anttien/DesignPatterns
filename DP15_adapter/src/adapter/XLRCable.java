package adapter;

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
