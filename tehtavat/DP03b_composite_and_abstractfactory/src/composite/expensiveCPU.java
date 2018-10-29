package composite;

public class expensiveCPU extends CPU {

    private String name;

    private double price;

    public expensiveCPU() {
        this.name = "Intel Core i5-8400";
        this.price = 246.17;
    }
    
    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
