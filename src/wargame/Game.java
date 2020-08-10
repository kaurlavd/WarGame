
package wargame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Creating a program for War GAme
 * @author lavdeep kaur,Inderdeep Singh, Simarjit Kaur,Gurjot Kaur 
 */
public class Game {
   
    private final String gameName = "War of Cards"; //the title of the game
    private ArrayList <WarPlayer> players = new ArrayList(); //Creating an arraylist
    private Pile gamePile = new Pile();  //Creating pile
    private Deck deck; //creating private deck
    WarPlayer p ;      //creating war player p
    WarPlayer comp;   //creating player computer
    int count = 0;   //creating an int count set to zero 
    int control ;    //creating int control 
    int w;           //creating an int w
    boolean play = true;       //setting boolean play to true
    Scanner in = new Scanner(System.in); // Creating a Scanner 
    
    /**
     *
     * @param args
     */
    public static void main( String[] args){
        
        Game g = new Game();        //Creating an instance of game class
        g.start();                  //game goes to start method 
        g.deck.shuffle();          // g goes to method for shuffling cards
        g.deal();                 // g goes to the method for dealing cards

         System.out.println("Press 1 to play manually.");
        System.out.println("Press 0 to play automatically.");
        if( g.in.nextInt() ==0 ){
            g.control = 0;
        }
        g.round();
        while( g.play ){    
        if( g.control == 0 || g.in.nextInt() == 1 ){
        g.round();
        }
        }
        
        System.out.println("Game Over"); 
        
        //if player has no cards in his primary pile he loses
        if(g.p.primaryPile.getSize() == 0){
            System.out.println(g.p.getName() + " lost the game.");
        }
        
        //if computer has no cards in his primary pile he loses
        else if(g.comp.primaryPile.getSize() == 0){
            System.out.println(g.p.getName() + " won the game.");
        }
        else{
            System.out.println("No result");
        }
    }
    
    /**
     * It is the method to start the game
     */
    public void start(){
        System.out.println( "Welcome to " + gameName );
        p = new WarPlayer();                             //player will be assigned as new warPlayer
        comp = new WarPlayer( "10010" , "Computer");
        in = new Scanner(System.in);
        
        System.out.println("Enter name ");   //allowing the player to enter his name
        p.setName( in.next() );
        
        System.out.println("Enter ID ");       //allowing the player to enetr his ID
        p.setID( in.next() );
        
        players.add(p);                        //adding the player to players arraylist
        players.add(comp);                     //adding computer to players arraylist
        
        deck = new Deck(52);                 //giving the cards in deck
        deck.fill();                         //going to fill method
      
    }
    
    /**
     * This is the method to deal the cards to players
     */
    public void deal(){
        
        //if deck is shuffled assign half of the cards to player and half to computer
        if( deck.isShuffled() ){
            for( int i =0; i/2  < p.primaryPile.getSize() ; i += 2 ){
                p.primaryPile.add( (i/2) , deck.getCard(i));
                comp.primaryPile.add( (i/2) , deck.getCard(i+1));
                //System.out.println(i/2);
            }
        }
        System.out.println(p.primaryPile.getSize() + "The cards have been dealt.");
        System.out.println("p p  "+p.primaryPile.toString());
        System.out.println("p s  "+p.secondaryPile.string());
        System.out.println("-------------------------------");
       System.out.println("c p  "+comp.primaryPile.toString());
        System.out.println("c s  "+comp.secondaryPile.string());
        System.out.println("-------------------------------");    
    }
    
    
    /**
     * It is the method to compare cards
     * @param count
     * @return 
     */
    public int compareCard(int count){
        
        //if either the player or comp has zero cards it method would return zero
        if (p.primaryPile.getSize() <= count || comp.primaryPile.getSize() <= count){
            return 0;
        }
        
        //if player has higher card value rank  ,those cards will be added to his secondary deck
        else if( p.primaryPile.getCompareCard(count).getRank() > comp.primaryPile.getCompareCard(count).getRank() ){
            this.count = 0;
            w = 2;
            return 2;  
        }
        
        //if both of them have same rank value war will take place
        else if(p.primaryPile.getCompareCard(count).getRank() == comp.primaryPile.getCompareCard(count).getRank()){
            this.count = 3;
            w=3;
            return 3;
        }
        else{
            this.count = 0;
            w=1;
            return 1;
        }
    }

    
    /**
     * Method for removing cards from pile if a player losesa round
     * @param i 
     */
    public void removeCard(int i){
        
            p.primaryPile = p.delete(i);
            comp.primaryPile = comp.delete(i);
            System.out.println("Cards removed");
            System.out.println(p.primaryPile.toString());
            System.out.println(comp.primaryPile.toString());
    }
    
    /**
     * Method for going through different rounds
     */
    public void round(){
        count = 0;
        w = 0;
        //following switch statements will be executed depending on the count value 
        switch ( compareCard(count) ) {
            case 3:{
                while( count == 3 ){
                System.out.println(" count " + this.count);
                System.out.println("Draw");
                System.out.println("Enter 1 to continue");
                if(in.nextInt() == 1){
                    
                    //if they have less primary cards to play go to addCardsto primary method
                    if( p.primaryPile.getSize() <= count || comp.primaryPile.getSize() <= count ){
                        addCardstoPrimary();
                        System.out.println("---------------------------------------");
                    }
                    
                    gamePile.add(p.primaryPile.getCompareCard(0));
                    gamePile.add(comp.primaryPile.getCompareCard(0));
                    }
                    System.out.println(gamePile.string());
                    
                    removeCard(0);
                    
                    compareCard(0);
                } 
                transferCards(w);
                }
            
                   
                    break;
            case 2:{
                    System.out.println("Player won" );
                    
                    gamePile.add(p.primaryPile.getCompareCard(0));
                    gamePile.add(comp.primaryPile.getCompareCard(0));
                    
                    transferCards(2);                

                }
                    break;
            case 1:{
                System.out.println("Player lost" ); 
                
                gamePile.add(p.primaryPile.getCompareCard(0));
                gamePile.add(comp.primaryPile.getCompareCard(0));
                
                transferCards(1);
            }
            break;
            case 0:{
                play = false;
                gameOver(!play);
            }
            default:{
            System.out.println("Round cancelled.");}
                break;
        }
        System.out.println("p primary" + p.primaryPile.toString());
        System.out.println( "p sec " + p.secondaryPile.string());
        System.out.println("-------------------------------");
        System.out.println("c p" + comp.primaryPile.toString());
        System.out.println("c s" + comp.secondaryPile.string());
        System.out.println("-------------------------------");
        System.out.println(" gp " + gamePile.string());
        System.out.println(p.primaryPile.getSize());
        System.out.println(comp.primaryPile.getSize());
 
        System.out.println("Round is over");
        addCardstoPrimary();
        System.out.println("Press 1 to continue");
    }
    
    /**
     * The method to add cards to the primary pile from secondary pile if player has less cards in his primary pile
     */
    public void addCardstoPrimary(){
    if( p.primaryPile.getSize() <= 0 || comp.primaryPile.getSize() <=0){
            if( (p.secondaryPile.size() == 0 && p.primaryPile.getSize() == 0) || (comp.primaryPile.getSize() == 0 && comp.secondaryPile.size()==0) ){
                play = false;
            }
            else if(p.secondaryPile.size() != 0 || comp.secondaryPile.size() != 0){
                if( p.primaryPile.getSize() <= 0){
                    int newSize = (p.secondaryPile.size() > 5) ? 5: p.secondaryPile.size() ;
                    Pile ptemp = new Pile(newSize);

                    for(int i = 0; i < ptemp.getSize(); i++){
                        ptemp.add( i , p.secondaryPile.getCard(i) );
                    }
                    p.primaryPile = ptemp;
                    System.out.println( " p p" + p.primaryPile.toString());

                    for(int j = 0; j < newSize; j++){
                        p.secondaryPile.remove(0);
                    }
                }
                if(comp.primaryPile.getSize() <= 0){
                    int newSize = (comp.secondaryPile.size() > 5) ? 5 : comp.secondaryPile.size() ;
                    Pile ctemp = new Pile(newSize);

                    for(int i = 0; i < ctemp.getSize(); i++){
                        ctemp.add( i , comp.secondaryPile.getCard(i) );
                    }
                    comp.primaryPile = ctemp;  


                    System.out.println( " c p" + comp.primaryPile.toString());

                    for(int i = 0; i < newSize; i++){
                        comp.secondaryPile.remove(0);
                    }
                }
                System.out.println( " p s" + p.secondaryPile.string());
                System.out.println( " c s" + comp.secondaryPile.string());
                
    }
}
    }
    
    /**
     * if one of the players loses a round cards of that round will be added to the secondary pile 
     * of the player who wins that round
     * @param i 
     */
    public void transferCards(int i){
        if(i == 1 ){
            
            removeCard(count);
            
            comp.secondaryPile.add( gamePile.lPile );
            
            System.out.println("Cards transfered to " + comp.getName() );
            System.out.println( gamePile.string() );
            
            gamePile.clear();    
        }
        
        if(i == 2 ){
         
            removeCard(count);
            
            p.secondaryPile.add( gamePile.lPile );
            
            System.out.println("Cards transfered to " + p.getName() );
            System.out.println( gamePile.string() );
            
            gamePile.clear();    
        }
    }
    
    
    /**
     * If one of the players has no cards game will be ended
     * @param b 
     */
    public void gameOver(boolean b){
        if(b){
            System.out.println(p.getName() + " lost the game.");
        }
        else{
            System.out.println(p.getName() + " won the game.");
        }
        
    }
  
}

    
