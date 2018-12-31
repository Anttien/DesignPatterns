package dp21_facade;

import java.util.HashMap;
import java.util.Random;

/**
 * This program implements the facade design pattern. It is an example taken
 * from
 * <a href="https://en.wikipedia.org/wiki/Facade_pattern">Wikipedia</a> and is
 * "<i>...an abstract example of how a client [...] interacts with a facade (the
 * "computer") to a complex system (internal computer parts, like CPU and
 * HardDrive)</i>".
 * 
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
        processor.jump(BOOT_ADDRESS, ram);
        processor.execute();

    }

    /* Complex parts */
    class CPU {

        private long position;
        private Memory ram;

        public void freeze() {
            System.out.println("CPU: freeze");
        }

        public void jump(long position, Memory ram) {
            System.out.println("CPU: jump to " + position);
            this.position = position;
            this.ram = ram;
        }

        public void execute() {
            System.out.println("CPU: execute");
            byte[] data = ram.read(position);
            for (byte b : data) {
                System.out.println(b);
            }
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

        byte[] memory = new byte[16000000]; // 16 mb of ram

        public void load(long position, byte[] data) {
            System.out.println("Memory: load into position " + position);
            for (byte b : data) {
                memory[(int) position] = b;
                position++;
            }
        }

        public byte[] read(long position) {
            System.out.println("Memory: read from position " + position);
            byte[] bytes = new byte[512];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = memory[((int) position + i)];
            }
            return bytes;
        }
    }

}
