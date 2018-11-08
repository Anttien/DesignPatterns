package decorator;

public abstract class CipheredFileWriterDecorator implements CipheredFileWriter {

    protected CipheredFileWriter CaesarCipherFileWriterToDecorate;

    public CipheredFileWriterDecorator(CipheredFileWriter CaesarCipherFileWriterToDecorate) {
        this.CaesarCipherFileWriterToDecorate = CaesarCipherFileWriterToDecorate;
    }

    @Override
    public void write(String string) {
        CaesarCipherFileWriterToDecorate.write(string);
    }

    @Override
    public String read() {
        return CaesarCipherFileWriterToDecorate.read();
    }

}
