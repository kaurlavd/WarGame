
package wargame;

/**
 *Creating a WarPlayer that extends the player
 * @author lavdeep kaur
 */
public class WarPlayer extends Player{
    
     
    Pile primaryPile;
    Pile secondaryPile;
    
    //Creating a constructor taking arguments
    public WarPlayer(String id , String name){
        super(id, name);
        primaryPile = new Pile(5);
        secondaryPile = new Pile();
    }
    
    //Creating constructor that takes no argument
    public WarPlayer(){
        primaryPile = new Pile(5);
        secondaryPile = new Pile();
    }
    
    /**
     * A method to remove cards from array
     * @param index
     * @return 
     */
    public Pile delete( int index ){
        int k = 0;
        System.out.println(primaryPile.getSize());
        int s = primaryPile.getSize() - index - 1 ;
        primaryPile.setSize( s );
        System.out.println( "new pile size: " + s);
        Pile p = new Pile(s);
        for(int i = 0; i <= p.getSize() ; i++){
            if( i <= index){
                continue;
            }
            p.aPile[k++] = primaryPile.aPile[i];
            }
        
        return p;
    }
    public Pile remove( int index ){
        int k = 0;
        int l = primaryPile.getSize();
        System.out.println(primaryPile.getSize());
        int s = primaryPile.getSize() - index - 1 ;
        primaryPile.setSize( s );
        System.out.println( "new pile size: " + s);
        Pile p = new Pile(s);
        for(int i = 0; i <= l ; i++){
            if( i <= index){
                continue;
            }
            p.aPile[k++] = primaryPile.aPile[i];
            }
        
        return p;
    }
    
    
    
}
