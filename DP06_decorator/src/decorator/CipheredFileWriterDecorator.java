package decorator;

public abstract class CipheredFileWriterDecorator implements CipheredFileWriter {

    protected CipheredFileWriter FileWriterToDecorate;

    public CipheredFileWriterDecorator(CipheredFileWriter CaesarCipherFileWriterToDecorate) {
        this.FileWriterToDecorate = CaesarCipherFileWriterToDecorate;
    }

    @Override
    public void write(String string) {
        FileWriterToDecorate.write(string);
    }

    @Override
    public String read() {
        return FileWriterToDecorate.read();
    }

}
