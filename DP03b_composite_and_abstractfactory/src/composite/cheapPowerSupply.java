package composite;

public class cheapPowerSupply extends PowerSupply {

    private String name;

    private double price;

    public cheapPowerSupply() {
        this.name = "EVGA 450 BT";
        this.price = 33.69;
    }
    
    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
