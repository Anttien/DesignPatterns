package dp21_facade;

import java.util.HashMap;
import java.util.Random;

/**
 * This project implements the Facade design pattern. It is a completed example
 * taken from <a href="https://en.wikipedia.org/wiki/Facade_pattern">Wikipedia</a> that is
 * "<i>...an abstract example of how a client [...] interacts with a facade (the
 * "computer") to a complex system (internal computer parts, like CPU and
 * HardDrive)</i>".
 *
 * @author Antti Nieminen
 */
public class FacadeTest {

    /* Client */
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}

/* Facade */
class ComputerFacade {

    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        int SECTOR_SIZE = 512; // 512 bytes
        long BOOT_SECTOR = 0;
        long BOOT_ADDRESS = 31744; // 7C00 in decimal
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
        byte[] data = ram.read(31744);
        for (byte b : data) {
            System.out.println(b);
        }
    }

    /* Complex parts */
    class CPU {

        public void freeze() {
            System.out.println("CPU: freeze");
        }

        public void jump(long position) {
            System.out.println("CPU: jump to " + position);
        }

        public void execute() {
            System.out.println("CPU: execute");
        }
    }

    class HardDrive {

        public byte[] read(long lba, int size) {
            System.out.println("Harddrive: read from sector " + lba);
            byte[] data = new byte[size];
            Random rnd = new Random();
            rnd.nextBytes(data);
            return data;
        }
    }

    class Memory {

        HashMap<Long, byte[]> memory = new HashMap();

        public void load(long position, byte[] data) {
            System.out.println("Memory: load into position " + position);
            memory.put(position, data);
        }

        public byte[] read(long position) {
            System.out.println("Memory: read from position " + position);
            return memory.get(position);
        }
    }

}
