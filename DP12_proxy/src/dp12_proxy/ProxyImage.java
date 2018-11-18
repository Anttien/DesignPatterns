package dp12_proxy;

/**
 * This is a proxy object which the client uses to gain access to the
 * {@link RealImage} object.
 */
public class ProxyImage implements Image {

    private RealImage image = null;
    private String filename = null;

    /**
     * Constructor
     *
     * @param filename
     */
    public ProxyImage(final String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.displayImage();
    }

    /**
     * Prints the filename
     */
    public String showData() {
        return filename;
    }

}
