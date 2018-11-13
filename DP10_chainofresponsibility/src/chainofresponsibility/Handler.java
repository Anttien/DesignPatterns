package chainofresponsibility;

public abstract class Handler {

    protected Handler successor;
    
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handleRaiseRequest(double percent) {
        if (successor != null) {
            successor.handleRaiseRequest(percent);
        } else {
            System.out.println("The raise request is too high and cannot be accepted. ");
        }
    }

}
