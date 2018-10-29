package composite;

/**
 *
 * @author Antti Nieminen
 */
public class Main {

    public static void main(String[] args) {
        Component computerCase = new Case("Phanteks Eclipse P400", 61.99);
        Component motherboard = new Motherboard("Gigabyte Z370P D3", 96.99);
        Component gpu = new GraphicsCard("Nvidia GeForce GTX 1070 Ti", 359.99);
        Component cpu = new CPU("Intel Core i5-8400", 246.17);
        Component ram1 = new RAM("16GB (2x8GB) DDR4-2400", 104.99);
        Component ram2 = new RAM("16GB (2x8GB) DDR4-2400", 104.99);
        Component ssd = new SSD("Samsung 970 Evo 500GB M.2 SSD", 127.88);
        Component psu = new PowerSupply("Corsair TX650M 650W", 92.42);

        computerCase.add(motherboard);
        motherboard.add(cpu);
        motherboard.add(gpu);
        motherboard.add(ram1);
        motherboard.add(ram2);
        motherboard.add(ssd);
        motherboard.add(psu);

        System.out.println("Prices:");
        System.out.println("CPU: " + cpu.getPrice());
        System.out.printf("Motherboard and all included components: %.2f\n", motherboard.getPrice());
        System.out.printf("Case and all included components: %.2f\n", computerCase.getPrice());
        System.out.println();
        System.out.println("List of components: ");
        for (Component component : computerCase.getChildComponents()) {
            System.out.printf(component.getClass().getSimpleName() + ": %s\n", component.getName());
        }

    }
}
