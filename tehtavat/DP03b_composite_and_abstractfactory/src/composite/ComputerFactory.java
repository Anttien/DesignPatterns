package composite;

public interface ComputerFactory {

	public abstract Case createCase();

	public abstract Motherboard createMotherboard();

	public abstract CPU createCPU();

	public abstract GraphicsCard createGraphicsCard();

	public abstract RAM createRAM();

	public abstract SSD createSSD();

	public abstract PowerSupply createPowerSupply();

	public abstract HDD createHDD();

}
