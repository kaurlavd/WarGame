
package wargame;

/**
 *Creating enum class VALUE
 * @author lavdeep kaur,Inderdeep Singh,Gurjot Kaur, Simarjit Kaur
 */
public enum VALUE{
        ACE(14) ,
        TWO(2) ,
        THREE(3) ,
        FOUR(4) ,
        FIVE(5) ,
        SIX(6) ,
        SEVEN(7) ,
        EIGHT(8) ,
        NINE(9) ,
        TEN(10) ,
        JACK(11) ,
        QUEEN(12) ,
        KING(13);
        
    private int value;            //declaring private int value
    private int valueSize = 13;    //declaring private int valueSize
     
    /**
     * constructor
     * @param value 
     */
    private VALUE(int value ){
        this.value = value;
    }
       
    
    /**
     * @return value
     */
    public int valueOf(){
        return this.value;
    }

    /**
     * @return the noOfValues
     */
    public int getValueSize() {
        return valueSize;
    }
        
    
}
