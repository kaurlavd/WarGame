
package wargame;

/**
 *Creating a player class
 * @author lavdeep kaur,Inderdeep Singh, Gurjot KAur, Simarjit Kaur
 */
public class Player{
 private String ID;          //private variable string Id
    private String name;      //private variable string name
       
    /**
     *empty constructor
     */
    public Player(){
    }
    
    /**
     *constructor 
     * @param id
     * @param name
     */
    public Player(String id , String name ) {
        this.ID = id;
        this.name = name;
    }
   
    @Override
    public String toString() {
        return "PlayerName : " + getName() + " \nPlayer Id : " +  getID();
    }

    /**
     * @return the Player ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param id
     */
    public void setID(String id) {
        this.ID = id;
    }

    /**
     * @return the Player Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}