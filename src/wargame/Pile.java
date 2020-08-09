
package wargame;

import java.util.ArrayList;

/**
 *Creating a class named Pile that extends the GroupOf cards class
 * @author lavdeep kaur,Inderdeep Singh, Simarjit KAur, gurjot Kaur
 */
public class Pile extends GroupOfCards{
    
   private int size ;        //declaring private int size
    ArrayList<WarCard> lPile;       //creating an arraylist lpile
    WarCard[] aPile;               //creating an array aPile
    
    
    /**
     * Creating a constructor
     */
    public Pile(){
        lPile = new ArrayList<>();
    }
    
    /*
    Creating a constructor
    */
    public Pile(int size){
        this.size = size;
        aPile = new WarCard[size];
    }
    
    /**
     * Creating a method to add cards in Pile
     * @param c 
     */
    public void add(WarCard c){
        lPile.add(c);
        System.out.println("Card " + c.toString() + " has been added to Pile");
    }
    
    
    /**
     * Creating method to add cards in Pile along with their value
     * @param i
     * @param c 
     */
    public void add(int i , WarCard c  ){
        aPile[i] = c;
    }
    
    /**
     *
     * @param cards
     */
    public void add( ArrayList<WarCard> cards){
        for( WarCard c : cards){
            lPile.add(c);
        }
    }
    
    /**
     * 
     * @return  lpile size
     */
    public int size(){
        return lPile.size();
    }
    
    /**
     * Method to set the size
     * @param s 
     */
    @Override
    public void setSize(int s){
        this.size = s;
    }
    
    /**
     * Method to get the size of pile
     * @return size
     */
    @Override
    public int getSize(){
        return size;
    }
    
    
    /**
     * method to get the card value
     * @param i
     * @return 
     */
    @Override
    public WarCard getCard( int i){
        return lPile.get(i);
    }
    
    /**
     * method for comparison
     * @param i
     * @return 
     */
    public WarCard getCompareCard(int i){
        return  aPile[i];
    }
    
    public String string(){
        String s = " ";
        for( int i =0; i< lPile.size() ; i++ ){
            s += lPile.get(i) + " " ;
        }
         return s;
    }
   
    @Override
    public String toString(){
        String s = " ";
        if(aPile.length > 0){
        for (int i = 0; i < aPile.length ; i++){
        s += aPile[i] + " " ; 
        }
        }
        else
            s= "empty";
        
        return s;
        
    }
    
    /**
     * method for removing cards from lpile
     * @param i 
     */
    public void remove(int i){
        lPile.remove(i);
    }
    
    /**
     * method to clear the pile
     */
    public void clear() {
        lPile.clear();
    }

}
