package composite;

public class expensiveSSD extends SSD {

    private String name;

    private double price;

    public expensiveSSD() {
        this.name = "Samsung 970 Evo 500GB M.2 SSD";
        this.price = 127.88;
    }
    
    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
