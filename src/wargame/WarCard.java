
package wargame;

/**
 * Method to create WarCard Class that extends card class
 * @author lavdeep kaur,Inderdeep Singh, Gurjot KAur, Simarjit KAur
 */
public class WarCard extends Card{
    
    private final SUIT[] suits= { SUIT.Spades , SUIT.Hearts , SUIT.Clubs , SUIT.Diamonds }; //Creating array of Suits
    private final VALUE[] values= {VALUE.ACE , VALUE.TWO, VALUE.THREE , VALUE.FOUR, VALUE.FIVE, VALUE.SIX, VALUE.SEVEN , VALUE.EIGHT, VALUE.NINE, VALUE.TEN, VALUE.JACK , VALUE.QUEEN , VALUE.KING};//Creating array of value
    /**
     * constructor that takes suit nd value
     * @param s
     * @param v 
     */
    public WarCard(SUIT s, VALUE v) {
        super(s, v);
    }
    
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return  getValue() + " of " + suit.name();
        
    }

    /**
     * @return the suits length
     */
    public int getSuitsSize() {
        return suits.length ;
    }
    /**
     * @return the values
     */
    public int getValuesSize() {
        return values.length ;
    }

    /**
     * Method to get Suit
     * @param i
     * @return 
     */
    public SUIT getSuit( int i){
        return suits[i];
    }
    
    /**
     * Method to get value
     * @param i
     * @return 
     */
    public VALUE getValue( int i){
        return values[i];
    }
    
    /**
     * Method to get rank
     * @param i
     * @return 
     */
    public int getRank(int i){
        return value.valueOf();
    }
    
}
