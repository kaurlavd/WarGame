
package wargame;

/**
 *creating enum class SUIT
 * @author lavdeep kaur,Inderdeep Singh,Gurjot Kaur, Simarjit Kaur
 */
public enum SUIT {
	Spades,
	Diamonds,
	Clubs,
	Hearts;
        
    private int suitSize = 4;

    /**
     * @return the suit
     */
    public int getSuitSize() {
        return suitSize;
    }
        
        
}
