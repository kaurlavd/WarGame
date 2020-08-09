
package wargame;

/**
 *Creating an abstract class card
 * @author lavdeep kaur,Inderdeep Singh, Simarjit kaur, Gurjot Kaur
 */
public abstract class Card {
       
    protected SUIT suit;  //craeting protected enum suit
    protected VALUE value; //Creating protected enum value
    
    /**
     * The method that will give us value of suit and value of card
     * @param s
     * @param v 
     */
    public Card( SUIT s , VALUE v ){
        suit = s ;
        value = v ;
    }

    /**
     * Method to return value of suit
     * @return value of suit
     */
    @Override
    public String toString(){
        return  value.valueOf() + " of " + suit;
    }       

    /**
     * @return the suit
     */
    public String getSuit() {
        return suit.name();
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(SUIT suit) {
        this.suit = suit;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value.toString();
    }
    
    public int getRank(){
        return value.valueOf();
    }

    /**
     * @param value the value to set
     */
    public void setValue(VALUE value) {
        this.value = value;
    }
}
