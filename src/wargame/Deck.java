
package wargame;

/**
 *Creating class deck that extends GroupofCards class
 * @author lavdeep kaur,Inderdeep singh, gurjot kaur, Simarjit Kaur
 */
public class Deck extends GroupOfCards{
      /*
       * @param size 
       */
    public Deck( int size){
        super(size);
    }
    /**
     * @return the size
     */
    @Override
    public int getSize() {
        return size;
    }
  
}