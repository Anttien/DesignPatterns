package decorator;

public class Main {
    
    public static void main(String[] args) {
        CipheredFileWriter cipheredFileWriter = new CaesarCipherDecorator(new SimpleFileWriter());
        cipheredFileWriter.write("The fault, dear Brutus, is not in our stars, but in ourselves.");
        System.out.println(cipheredFileWriter.read());
    }

}
