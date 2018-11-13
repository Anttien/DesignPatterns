package chainofresponsibility;

/**
 * This class implements the Chain of Command design pattern. If one of it's
 * subclasses cannot accept a pay raise request, it will forward the request to
 * it's successor.
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // If a succeossor is not appointed, it is the last object in the chain and 
    // cannot be handled any further.
    public void handleRaiseRequest(double percent) {
        if (successor != null) {
            successor.handleRaiseRequest(percent);
        } else {
            System.out.println("The raise request is too high and cannot be accepted. ");
        }
    }

}
