package composite;

public class expensiveRAM extends RAM {

    private String name;

    private double price;

    public expensiveRAM() {
        this.name = "16GB (2x8GB) DDR4-2400";
        this.price = 104.99;
    }
    
    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
