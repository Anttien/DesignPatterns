package composite;

public class cheapSSD extends SSD {

    private String name;

    private double price;

    public cheapSSD() {
        this.name = "Crucial MX500 250GB ";
        this.price = 49.90;
    }
    
    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
