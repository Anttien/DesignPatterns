package composite;

public class expensivePowerSupply extends PowerSupply {

    private String name;

    private double price;

    public expensivePowerSupply() {
        this.name = "Corsair TX650M 650W";
        this.price = 92.42;
    }
    
    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
