package chainofresponsibility;

public class Director extends Handler {
    
    private final double raiseAcceptThreshold = 5.0;
    
    @Override
    public void handleRaiseRequest(double percent) {
        if (percent <= raiseAcceptThreshold) {
            System.out.println("The " + this.getClass().getSimpleName().toLowerCase() + " accepts the " + percent + "% raise request.");
        } else {
            System.out.println("The " + this.getClass().getSimpleName().toLowerCase() + " cannot accept the " + percent + "% raise request. ");
            super.handleRaiseRequest(percent);
        }
    }
}
