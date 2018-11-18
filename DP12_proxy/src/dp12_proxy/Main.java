package dp12_proxy;

import java.util.ArrayList;

/**
 *
 * @see @see <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy Pattern
 * in Wikipedia</a>
 */
class Main {

    /**
     * Test method
     */
    public static void main(final String[] arguments) {
        final Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        final Image image2 = new ProxyImage("HiRes_10MB_Photo2");

        Album album = new Album();
        album.addImage(image1);
        album.addImage(image2);

        ArrayList<Image> images;
        images = album.getImages();
        System.out.println("Showing the content of the album: ");
        images.forEach((image) -> {
            image.showData();
        });
        
        image1.displayImage(); // loading necessary
        image1.displayImage(); // loading unnecessary
        image2.displayImage(); // loading necessary
        image2.displayImage(); // loading unnecessary
        image1.displayImage(); // loading unnecessary
    }
}
