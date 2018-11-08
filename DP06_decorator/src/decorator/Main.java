package decorator;

public class Main {
    
    public static void main(String[] args) {
        CipheredFileWriter cipheredFileWriter = new CaesarCipherDecorator(new SimpleFileWriter());
        cipheredFileWriter.write("Moro");
        System.out.println(cipheredFileWriter.read());
    }

}
