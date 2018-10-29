package composite;

public class cheapCPU extends CPU {

    private String name;

    private double price;

    public cheapCPU() {
        this.name = "Intel Core i3-8100";
        this.price = 112.99;
    }
    
    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
