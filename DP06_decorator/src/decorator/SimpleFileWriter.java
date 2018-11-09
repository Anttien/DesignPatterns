package decorator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleFileWriter implements CipheredFileWriter {

    private final String file = "important.info";

    @Override
    public void write(String string) {
        try {
            FileWriter filewriter = new FileWriter(file);
            PrintWriter writer = new PrintWriter(filewriter, true);
            writer.println(string);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public String read() {
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(file);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return line;
    }

}
