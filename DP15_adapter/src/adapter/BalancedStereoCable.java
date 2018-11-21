package adapter;

public class BalancedStereoCable {

    private StringBuilder signalOut;

    public BalancedStereoCable() {
        signalOut = new StringBuilder();
    }

    public String signalOut() {
        return signalOut.toString();
    }

    public void signalIn(String signalL, String signalR) {
        signalOut = new StringBuilder();
        signalOut.append("Stereo signal L+R:")
                .append("\n     L-> ")
                .append(signalL)
                .append("\n     R-> ")
                .append(signalR)
                .append("\n");
    }

}
