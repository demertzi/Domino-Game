
package domino2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player{
    private final String name;
    public  List<Tile> hand,shand;
    private Table table;
    private Pack pack;

    /**
     * Δημιουργεί έναν παίκτη με ένα hand
     * 
     * @param n το όνομα του παίκτη 
     */
    
    public Player (String n){
        name=n;
        hand = new ArrayList <Tile>();
        shand = new ArrayList <Tile>();
        pack = new Pack(6);
    }
    
    /**
     * Γεμίζει το hand με τυχαία πλακίδια
     * @param number πόσα πλακίδια θα έχει το hand
     */
    
    public void createHand(int number){
        pack.shuffle();
        int sum = 0;
       for (Tile tile : pack.getDominos()){
           if (sum < number){
               hand.add(tile);
               shand.add(tile);
               sum++;
           }
       }
    }
    
    public String getName(){
        return name;
    }
        
    public List<Tile> getHand(){
        return hand;
    }
    
    public List<Tile> getsHand(){
        return shand;
    }    
    public void shuffleHand(){
        Collections.shuffle(hand);
    }
    
    public int numberOfTilesInHand(){
        return shand.size();
    }
    
    public boolean emptyHand(){
        return shand.isEmpty();
    }
    
    /**
     * @param t
     * @return το index του πλακιδίου
     */
    
    public int getIndex(Tile t)
    {
        for (Tile tile : shand){
            if (tile.sameTile(t)){
                return shand.indexOf(tile);
            }
        }
        return -1;
    }
    
    /**
     * Αφαιρεί ένα πλακίδιο από το hand
     * @param t 
     */
    
    public void removeTile(Tile t){
        if (getIndex(t) != -1)
        shand.remove(getIndex(t));        
    }
    
    public boolean hasTile(Tile t){
        return shand.contains(t);
    }
    
    /**
     * 
     * @param s
     * @return true αν ο παίκτης έχει πλακίδιο με συγκεκριμένο αριθμό, αντίθετα false
     */
    
    public boolean canPlay(int s){
        
        for(Tile tileInHand : shand){
            if (s == tileInHand.getSide1() || s == tileInHand.getSide2() ){
                return true;
            }
        }
        return false;
    }
    
    public boolean canPlayCardinal(int s){
        
        for(Tile tileInHand : shand){
            if ((s+ tileInHand.getSide1()) == 7 || (s+tileInHand.getSide2() == 7) ){
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * 
     * @return true αν ο παίκτης μπορεί έχει πλακίδιο με το οποίο μπορεί να παίξει 
     */
    
 
    public boolean canPlayOnTable(Table table){
        
        if  (table.isEmpty()){
           return true;
       }else{
           if (canPlay(table.getLeftSide()) || canPlay(table.getRightSide())){
               return true;
           }
        else 
            return false;
       }
    }
    
    /**
     * 
     * @return το άθροισμα από όλους τους αριθμούς των πλακιδίων που είναι στο hand
     */
    
    public int valueHand (){
        
        int total=0;
        
        for (Tile t : shand){
            total = total + t.getTotalValue();
        }
        
        return total;
    }
    
    /**
     * 
     * @param number
     * @return ένα πλακίδιο που μία από τις δυο πλευρές του έχει τον αριθμό @param
     */
    
    public Tile tileFromHand(int number){
        Tile tile = null;
        for (Tile t : shand){
            if (t.getSide1() == number || t.getSide2() == number){
                tile = t;
            }
        }
        return tile;
    }
    
    public Tile tileFromHandCardinal(int number){
        Tile tile = null;
        for (Tile t : shand){
            if (t.getSide1()+ number == 7 || t.getSide2()+ number == 7){
                tile = t;
            }
        }
        return tile;
    }
    
    /**
     * 
     * @return Τον μεγαλύτερο διπλό αριθμό πλακιδίου στο hand
     */
    
    public int theBiggestDouble(){
        
        int max = -1;
        for (Tile t : shand){
            if (t.DoubleSide() && max < t.getSide1()){
                max = t.getSide1();
            }
        }
        return max;
    }
    
    /**
     * 
     * @return Το μεγαλύτερο άθροισμα από τους αιρθμούς των πλακιδίων
     */
    
    public int playersHighestSumTile(){
        
        int max =-1;
        for (Tile t : shand){
            if (!t.DoubleSide() && max < t.getTotalValue()){
                max = t.getTotalValue();
            }
        }
        return max;
    }
    
}
