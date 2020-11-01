
package domino2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Δημιουργείται μια λίστα από Tile είτε μέχρι το 6 είτε μέχρι το 9
 * 
 * @author demer
 */

public class Pack{
    private List <Tile> pack;
    private int size;
    
    public Pack(int size){
        if (size == 6){
           pack = new ArrayList<Tile>();
        
            for (int i=0; i<7; i++){
                for (int j=i; j<7; j++){
                    Tile newT = new Tile (i,j);
                    pack.add(newT);
                }
            }
        
            size = pack.size();
        }
        else if (size == 9){
            
            pack = new ArrayList<Tile>();
        
            for (int i=0; i<10; i++){
                for (int j=i; j<10; j++){
                    Tile newT = new Tile (i,j);
                    pack.add(newT);
                }
            }
        
            size = pack.size();
        }
    }
    
    /**
     * 
     * @return τη λίτσα με τα πλακίδια
     */
    
    public List <Tile> getDominos(){
        return pack;
    }
    
    /**
     * Την ανακατεύει
     */
    
    public void shuffle(){
        Collections.shuffle(pack);
    }
    
    public int getPackSize(){
        return size;
    }   
    
    public Tile getspecificDominos (int z){
        return pack.get(z);
    }
}