
package wargame;

/**
 *creating an abstract class GroupOf Cards
 * @author lavdeep kaur,InderdeepSingh, Gurjot Kaur, Simarjit Kaur
 */
public abstract class GroupOfCards {
    
     WarCard c1 = new WarCard( SUIT.Spades , VALUE.ACE); //creating instance for warCardclass
    protected int size;                              //declsring protected int
    protected WarCard[] grOfCards;                  //creating an array of grpOfCards
    private boolean shuffled = false;               //creating protected boolean shuffled
    
    
    /**
     * Creating an empty constructor GRoupOfCards
     */
    public GroupOfCards(){
    }
    
    
    /*
    Creating an constructor
    */
    public GroupOfCards(int size){
        this.size = size;
        grOfCards = new WarCard[size];  
        System.out.println(" main pile Constructed");
    }
    
    /**
     * Creating a method to fill the cards in pile
     */
    public void fill(){
        int x =0;
        while(x < size){
            for (int i = 0; i< c1.getSuitsSize() ; i++){
                for (int j = 0 ; j < c1.getValuesSize(); j++){
                        grOfCards[x]= new WarCard( c1.getSuit(i) , c1.getValue(j) );
                        x++;
                        }                      
                }
        }
        System.out.println("The deck has been created.");
    }
       
    /**
     * Creating a method to shuffle the pile of cards
     */
    public void shuffle(){
        setShuffled(true);
        for(int i = 0; i < getSize() ; i++){
            int random = (int)(Math.random()* getSize() );
            WarCard temp = getGrOfCards()[i];
            getGrOfCards()[i] = getGrOfCards()[random];
            getGrOfCards()[random] = temp;
        }
        if(shuffled)
        System.out.println("The deck has been shuffled.");
    }

    /**
     * method to get size of pile
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the grOfCards
     */
    public WarCard[] getGrOfCards() {
        return grOfCards;
    }

    /**
     *
     * @param i
     * @return
     */
    public WarCard getCard(int i ){
        return grOfCards[i];
    }
    

    /**
     * @param grOfCards the grOfCards to set
     */
    public void setGrOfCards(WarCard[] grOfCards) {
        this.grOfCards = grOfCards;
    }

    /**
     * @return the shuffled
     */
    public boolean isShuffled() {
        return shuffled;
    }

    /**
     * @param shuffled the shuffled to set
     */
    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }
    
    @Override
    public String toString(){
        String s = "";
        for( int i = 0; i < size ; i ++ ){
            WarCard c = grOfCards[i];
            s += c.toString() + "\n" ;
        }
        return s;
    }
}
    
    

