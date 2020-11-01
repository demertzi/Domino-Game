
package domino2;

public class Tile{
    private int side1, side2;
    private boolean flipped, blank;
    
    public Tile(){
        side1 = 0;
        side2 = 0;
        flipped = false;
        blank = true;
    }
    
    /**
     * Δημιουργείται πλακίδιο Tile με πλευρές s1 και s2
     * @param s1
     * @param s2 
     */
    public Tile(int s1, int s2){
        side1 = s1;
        side2 = s2;

        flipped = false;
        blank = false;
    }
    
    public int getSide1(){
        return side1;
    }
    
     public int getSide2(){
        return side2;
    }
     
     public boolean isBlank(){
         return blank;
     }
     
     public void blankIt(){
         blank=!blank;
     }
     
     public boolean flip(){
         return flipped;
     }
     
     public void flipTile(){
         flipped=!flipped;
     }
     
     public int getTotalValue(){
         return side1+side2;
     }
     
     public boolean sameValue(Tile comp){
         return this.getTotalValue() == comp.getTotalValue();
     }
     
     /**
      * Συγκρίνει το πλακίδιο με το comp
      * @param comp
      * @return true αν είναι το ίδιο, αντίθετα false
      */
     public boolean sameTile(Tile comp){
         if (this.getSide1() == comp.getSide1() && this.getSide2() == comp.getSide2()){
             return true;
         }
         else {
             return false;
         }
     }
     
     public boolean DoubleSide(){
         return side1 == side2;
     }
     
     /**
      * Τυπώνει το πλακίδιο οριζόντια
      */
     
     public String printHorizontal(){
         if (!flipped){
             return "[" +side1 + "|" +side2 + "] ";
         }
         else{
             return "[" +side2 + "|" +side1 + "] ";
         }
     }
     
     
     /**
      * Τυπώνει το πλακίδιο κάθετα
      */
     
     public void printVertical(){
         if (!flipped){
             System.out.println("---");
             System.out.println("|" +side1 + "|");
             System.out.println("---");
             System.out.println("|" +side2 + "|");
             System.out.println("---");
         }
         else{
             System.out.println("---");
             System.out.println(" " +side2);
             System.out.println(" -");
             System.out.println(" " +side1);
             System.out.println("---");
         }
     }
}