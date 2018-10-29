package composite;

/**
 *
 * @author Antti Nieminen
 */
public class Main {

    public static void main(String[] args) {

        for (ComputerFactory computerFactory : new ComputerFactory[]{new expensiveComputerFactory(), new cheapComputerFactory()}) {
            Component computerCase = computerFactory.createCase();
            Component motherboard = computerFactory.createMotherboard();
            Component gpu = computerFactory.createGraphicsCard();
            Component cpu = computerFactory.createCPU();
            Component ram1 = computerFactory.createRAM();
            Component ram2 = computerFactory.createRAM();
            Component ssd = computerFactory.createSSD();
            Component psu = computerFactory.createPowerSupply();

            computerCase.add(motherboard);
            motherboard.add(cpu);
            motherboard.add(gpu);
            motherboard.add(ram1);
            motherboard.add(ram2);
            motherboard.add(ssd);
            motherboard.add(psu);

            System.out.println("List of components: ");
            for (Component component : computerCase.getChildComponents()) {
                System.out.printf(component.getClass().getSimpleName() + ": %s\n", component.getName());
            }
            System.out.println();
            System.out.println("Prices:");
            System.out.println("CPU: " + cpu.getPrice());
            System.out.printf("Motherboard and all included components: %.2f\n", motherboard.getPrice());
            System.out.printf("Case and all included components: %.2f\n", computerCase.getPrice());
            System.out.println();
        }
    }
}
