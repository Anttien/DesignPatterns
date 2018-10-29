package composite;

public class expensiveComputerFactory implements ComputerFactory {

	public Motherboard createMotherboard() {
		return new expensiveMotherboard();
	}

	public Case createCase() {
		return new expensiveCase();
	}

	public CPU createCPU() {
		return new expensiveCPU();
	}

	public RAM createRAM() {
		return new expensiveRAM();
	}

	public SSD createSSD() {
		return new expensiveSSD();
	}

	public PowerSupply createPowerSupply() {
		return new expensivePowerSupply();
	}

	public GraphicsCard createGraphicsCard() {
		return new expensiveGraphicsCard();
	}

	public HDD createHDD() {
		return new expensiveHDD();
	}

}
