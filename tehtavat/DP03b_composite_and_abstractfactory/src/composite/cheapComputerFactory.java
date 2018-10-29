package composite;

public class cheapComputerFactory implements ComputerFactory {

	public Motherboard createMotherboard() {
		return new cheapMotherboard();
	}

	public Case createCase() {
		return new cheapCase();
	}

	public CPU createCPU() {
		return new cheapCPU();
	}

	public RAM createRAM() {
		return new cheapRAM();
	}

	public SSD createSSD() {
		return new cheapSSD();
	}

	public PowerSupply createPowerSupply() {
		return new cheapPowerSupply();
	}

	public GraphicsCard createGraphicsCard() {
		return new cheapGraphicsCard();
	}

	public HDD createHDD() {
		return new cheapHDD();
	}

}
