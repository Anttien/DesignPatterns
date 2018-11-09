package decorator;

public class CaesarCipherFileWriter extends CipheredFileWriterDecorator {
    
    /**
     * How much character shift is applied.
     */
    private final int shift = 2;

    public CaesarCipherFileWriter(CipheredFileWriter CaesarCipherFileWriterToDecorate) {
        super(CaesarCipherFileWriterToDecorate);
    }

    @Override
    public void write(String string) {
        String encryptedString = encrypt(string);
        super.write(encryptedString);
    }

    @Override
    public String read() {
        String str = super.read();
        String decryptedString = decrypt(str);
        return decryptedString;
    }

    public String encrypt(String str) {
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = (char) (strArray[i] - shift);
        }
        str = new String(strArray);
        return str;
    }

    public String decrypt(String str) {
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = (char) (strArray[i] + shift);
        }
        str = new String(strArray);
        return str;
    }
}
