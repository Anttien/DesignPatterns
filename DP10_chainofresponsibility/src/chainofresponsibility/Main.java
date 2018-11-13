package chainofresponsibility;

public class Main {

    public static void main(String[] args) {
        Handler manager = new Manager();
        Handler director = new Director();
        Handler president = new President();
        Handler ceo = new Ceo();
        
        manager.setSuccessor(director);
        director.setSuccessor(president);
        president.setSuccessor(ceo);
        
        manager.handleRaiseRequest(1);
        manager.handleRaiseRequest(3);
        manager.handleRaiseRequest(8);
        manager.handleRaiseRequest(15);
        manager.handleRaiseRequest(22);
    }

}
