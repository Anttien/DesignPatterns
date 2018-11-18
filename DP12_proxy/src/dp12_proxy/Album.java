
package dp12_proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An album contains Images.
 * @author Antti Nieminen
 */
public class Album {
    
    private List<Image> album;

    public Album() {
        this.album = new ArrayList();
    }
    
    public void addImage(Image image){
        album.add(image);
    }
    
    public ArrayList<Image> getImages() {
        return (ArrayList)album;
    }

 
    
    
    
    

}
