
package domino2;

public class Cardinal {
    private PlayersInfo info;
    private Player player1;
    private Player player2; 
    private Player player3;
    private Player player4;
    private Score score;
    private Table table;
    private boolean shouldFlip;
    
    public Cardinal(){
    }
    /*
    * Ανάλογα με το πόσες παίκτες δέχεται ως παραμέτρους δημιουργεί αντίστοιχα τοσα hand και τα κάνει shuffle
    */
    public Cardinal(Player player, Player bot, Table table){
        player1 = player;
        player2 = bot;
        this.table = table;
        
        player1.createHand(7);
        player2.createHand(7);
        player1.shuffleHand();
        player2.shuffleHand();
    }
    
    public Cardinal(Player player, Player bot1, Player bot2, Table table){
        player1 = player;
        player2 = bot1;
        player3 = bot2;
        this.table = table;
        
        player1.createHand(5);
        player2.createHand(5);
        player3.createHand(5);
        player1.shuffleHand();
        player2.shuffleHand();
        player3.shuffleHand();
    }
    
    public Cardinal(Player player, Player bot1, Player bot2, Player bot3, Table table){
        
        player1 = player;
        player2 = bot1;
        player3 = bot2;
        player4 = bot3;
        this.table = table;
        
        player1.createHand(5);
        player2.createHand(5);
        player3.createHand(5);
        player4.createHand(5);
        player1.shuffleHand();
        player2.shuffleHand();
        player3.shuffleHand();
        player4.shuffleHand();
        
    }
    
    public void displayScores(){
        
    }
   
    /**
     * Ελέγχει ποιός παίζει πρώτος
     * @return player η bot
     */

    public Player firstTurn(int num){
        
        if (num == 4){
            if (player1.theBiggestDouble() > -1 || player2.theBiggestDouble() > -1 || player3.theBiggestDouble() > -1 || player4.theBiggestDouble() > -1){    //Αν ένας έχει διπλό πλακίδιο μεγαλύερο του -1
                if ((player1.theBiggestDouble() > player2.theBiggestDouble()) && (player1.theBiggestDouble() > player3.theBiggestDouble()) && (player1.theBiggestDouble() > player4.theBiggestDouble())){   //Αν ο player έχει μεγαλύερο διπλό πλακίδιο από το bot
                    return player1 ;
                }
                else if((player2.theBiggestDouble() > player3.theBiggestDouble()) && (player2.theBiggestDouble() > player4.theBiggestDouble())){
                   return player2;
                }
                else if(player3.theBiggestDouble() > player4.theBiggestDouble()){
                    return player3;
                }
                else{
                    return player4;
                }
            }
            else{
                if ((player1.playersHighestSumTile()> player2.playersHighestSumTile()) && (player1.playersHighestSumTile() > player3.playersHighestSumTile()) && (player1.playersHighestSumTile() > player4.playersHighestSumTile())){     //Αν το bot έχει μεγαλύτερο διπλό πλακίδιο από τον player
                    return player1;
                }
                else if ((player2.playersHighestSumTile() > player3.playersHighestSumTile()) && (player2.playersHighestSumTile() > player4.playersHighestSumTile())){
                    return player2;
                }
                else if(player3.playersHighestSumTile() > player4.playersHighestSumTile()){
                    return player3;
                }
                else{
                    return player4;
                }
            }
        }
        else if (num == 3){
            if (player1.theBiggestDouble() > -1 || player2.theBiggestDouble() > -1 || player3.theBiggestDouble() > -1){    //Αν ένας έχει διπλό πλακίδιο μεγαλύερο του -1
                if ((player1.theBiggestDouble() > player2.theBiggestDouble()) && (player1.theBiggestDouble() > player3.theBiggestDouble())){   //Αν ο player έχει μεγαλύερο διπλό πλακίδιο από το bot
                    return player1 ;
                }
                else if((player2.theBiggestDouble() > player3.theBiggestDouble())){
                   return player2;
                }
                else{
                    return player3;
                }
            }
            else{
                if ((player1.playersHighestSumTile()> player2.playersHighestSumTile()) && (player1.playersHighestSumTile() > player3.playersHighestSumTile())){     //Αν το bot έχει μεγαλύτερο διπλό πλακίδιο από τον player
                    return player1;
                }
                else if ((player2.playersHighestSumTile() > player3.playersHighestSumTile())){
                    return player2;
                }
                else{
                    return player3;
                }
            }
        }
        else{
            if (player1.theBiggestDouble() > -1 || player2.theBiggestDouble() > -1 ){    //Αν ένας έχει διπλό πλακίδιο μεγαλύερο του -1
                if (player1.theBiggestDouble() > player2.theBiggestDouble()){   //Αν ο player έχει μεγαλύερο διπλό πλακίδιο από το bot
                    return player1 ;
                }
                else{
                    return player2;
                }
            }
            else{
                if (player1.playersHighestSumTile()> player2.playersHighestSumTile()){     //Αν το bot έχει μεγαλύτερο διπλό πλακίδιο από τον player
                    return player1;
                }
                else{
                    return player2;
                }
            }
        }
    }
    
    /*
    * Ελέγχει ποιος παίζει δεύτερος
    */
    
    public Player secondTurn(int num){
        Player p = firstTurn(num);
        
        if (num == 4){
        if (player1.theBiggestDouble() > -1 || player2.theBiggestDouble() > -1 || player3.theBiggestDouble() > -1 || player4.theBiggestDouble() > -1){    //Αν ένας έχει διπλό πλακίδιο μεγαλύερο του -1
                if ((player1.theBiggestDouble() > player2.theBiggestDouble()) && (player1.theBiggestDouble() > player3.theBiggestDouble()) && (player1.theBiggestDouble() > player4.theBiggestDouble()) && (player1 != p)){   //Αν ο player έχει μεγαλύερο διπλό πλακίδιο από το bot
                    return player1 ;
                }
                else if((player2.theBiggestDouble() > player3.theBiggestDouble()) && (player2.theBiggestDouble() > player4.theBiggestDouble()) && (player2 != p)){
                   return player2;
                }
                else if((player3.theBiggestDouble() > player4.theBiggestDouble()) && (player3 != p)){
                    return player3;
                }
                else{
                    return player4;
                }
            }
            
            else{
                if ((player1.playersHighestSumTile()> player2.playersHighestSumTile()) && (player1.playersHighestSumTile() > player3.playersHighestSumTile()) && (player1.playersHighestSumTile() > player4.playersHighestSumTile()) && (player1 != p)){     //Αν το bot έχει μεγαλύτερο διπλό πλακίδιο από τον player
                    return player1;
                }
                else if ((player2.playersHighestSumTile() > player3.playersHighestSumTile()) && (player2.playersHighestSumTile() > player4.playersHighestSumTile()) && (player2 != p)){
                    return player2;
                }
                else if((player3.playersHighestSumTile() > player4.playersHighestSumTile()) && (player3 != p)){
                    return player3;
                }
                else{
                    return player4;
                }
            }
        }
        else if (num == 3){
        if (player1.theBiggestDouble() > -1 || player2.theBiggestDouble() > -1 || player3.theBiggestDouble() > -1){    //Αν ένας έχει διπλό πλακίδιο μεγαλύερο του -1
                if ((player1.theBiggestDouble() > player2.theBiggestDouble()) && (player1.theBiggestDouble() > player3.theBiggestDouble()) && (player1 != p)){   //Αν ο player έχει μεγαλύερο διπλό πλακίδιο από το bot
                    return player1 ;
                }
                else if((player2.theBiggestDouble() > player3.theBiggestDouble()) && (player2 != p)){
                   return player2;
                }
                else{
                    return player3;
                }
            }
            
            else{
                if ((player1.playersHighestSumTile()> player2.playersHighestSumTile()) && (player1.playersHighestSumTile() > player3.playersHighestSumTile()) && (player1 != p)){     //Αν το bot έχει μεγαλύτερο διπλό πλακίδιο από τον player
                    return player1;
                }
                else if ((player2.playersHighestSumTile() > player3.playersHighestSumTile()) && (player2 != p)){
                    return player2;
                }
                else{
                    return player3;
                }
            }
        }
        else{
            if (p == player1){
                return player2;
            }
            else{
                return player1;
            }
        }
    }
    
    /*
    * Ελέγχει ποιος παίζει τρίτος
    */
    
    public Player thirdTurn(int num){
        Player p = firstTurn(num);
        Player pp = secondTurn(num);
        
        if (num == 4){
        if (player1.theBiggestDouble() > -1 || player2.theBiggestDouble() > -1 || player3.theBiggestDouble() > -1 || player4.theBiggestDouble() > -1){    //Αν ένας έχει διπλό πλακίδιο μεγαλύερο του -1
                if ((player1.theBiggestDouble() > player2.theBiggestDouble()) && (player1.theBiggestDouble() > player3.theBiggestDouble()) && (player1.theBiggestDouble() > player4.theBiggestDouble()) && (player1 != p) && (player1 != pp)){   //Αν ο player έχει μεγαλύερο διπλό πλακίδιο από το bot
                    return player1 ;
                }
                else if((player2.theBiggestDouble() > player3.theBiggestDouble()) && (player2.theBiggestDouble() > player4.theBiggestDouble()) && (player2 != p) && ((player2 != pp))){
                   return player2;
                }
                else if((player3.theBiggestDouble() > player4.theBiggestDouble()) && (player3 != p) && (player3 != pp)){
                    return player3;
                }
                else{
                    return player4;
                }
            }
            else{
                if ((player1.playersHighestSumTile()> player2.playersHighestSumTile()) && (player1.playersHighestSumTile() > player3.playersHighestSumTile()) && (player1.playersHighestSumTile() > player4.playersHighestSumTile()) && (player1 != p) && (player1 != pp)){     //Αν το bot έχει μεγαλύτερο διπλό πλακίδιο από τον player
                    return player1;
                }
                else if ((player2.playersHighestSumTile() > player3.playersHighestSumTile()) && (player2.playersHighestSumTile() > player4.playersHighestSumTile()) && (player2 != p) && (player2 != pp)){
                    return player2;
                }
                else if((player3.playersHighestSumTile() > player4.playersHighestSumTile()) && (player3 != p) && (player3 != pp)){
                    return player3;
                }
                else{
                    return player4;
                }
            }
        }
        else{
            if (player1.theBiggestDouble() > -1 || player2.theBiggestDouble() > -1 || player3.theBiggestDouble() > -1){    //Αν ένας έχει διπλό πλακίδιο μεγαλύερο του -1
                if ((player1.theBiggestDouble() > player2.theBiggestDouble()) && (player1.theBiggestDouble() > player3.theBiggestDouble()) && (player1 != p) && (player1 != pp)){   //Αν ο player έχει μεγαλύερο διπλό πλακίδιο από το bot
                    return player1 ;
                }
                else if((player2.theBiggestDouble() > player3.theBiggestDouble()) && (player2 != p) && ((player2 != pp))){
                   return player2;
                }
                else{
                    return player3;
                }
            }
                else {
                if ((player1.playersHighestSumTile()> player2.playersHighestSumTile()) && (player1.playersHighestSumTile() > player3.playersHighestSumTile()) && (player1 != p) && (player1 != pp)){     //Αν το bot έχει μεγαλύτερο διπλό πλακίδιο από τον player
                    return player1;
                }
                else if ((player2.playersHighestSumTile() > player3.playersHighestSumTile()) && (player2 != p) && (player2 != pp)){
                    return player2;
                }
                else{
                    return player3;
                }
            }
        }
}
    
    /*
    * Ελέγχει ποιος παίζει τελευταίος
    */
    public Player fourthTurn(int num){
        Player p1 = firstTurn(num);
        Player p2 = secondTurn(num);
        Player p3 = thirdTurn(num);
        if ((player1 != p1) && (player1 != p2) && (player1 != p3)){
            return player1;
        }
        else if ((player2 != p1) && (player2 != p2) && (player2 != p3)){
            return player2;
        }
        else if ((player3 != p1) && (player3 != p2) && (player3 != p3)){
            return player3;
        }
        else {
            return player4;
        }
    }
    
    /**
    * Επιστρέφει true αν είναι η σειρά του player και false αν δεν είναι
    * 
    * @return true η false
    */
    
    public boolean userTurn(int num){
        boolean first = false;
        
        if (firstTurn(num) == player1){
            first = true;
        }
        return first;
    }
    
    
    /**
     *
     * Ενημερώνει το shouldFlip αν πρέπει να γυρίσει το πλακίδιο
     * 
     * @param t το πλακίδιο που επιλέγει ο παίκτης από την selectTileUser
     * 
     * @return Επιστρέφει true αν το table είναι άδειο ή αν ο αριθμός στην αρχή του table είναι
     * είναι ίδια με μία από τις δύο πλευρές του πλακιδίου. Διαφορετικά, αν μία απο τις
     * δυο πλευρές του πλακιδίου ταιριάζει με τον αριθμό στο τέλος του table
     */
    
    public boolean putToSide(Tile t){
        boolean flag = false;
        if (table.isEmpty()){
            flag = true;
        }
        else{
            if ((t.getSide1() + table.getRightSide())==7){
                shouldFlip = false;
                flag = false;
            }   
            else if ((t.getSide2()+table.getRightSide() ==7)){
                shouldFlip = true;
                flag = false;
                }
            else if ((t.getSide1()+table.getLeftSide()==7)){
                    shouldFlip = true;
                    flag = true;
                    }
            else if ((t.getSide2()+ table.getLeftSide() == 7)){
                        shouldFlip = false;
                        flag = true;
                        }
                    }
        return flag;
    }
    
    public boolean getShouldFlip(){
        return shouldFlip;
    }
    
    /**
     * Τοποθετεί το πλακίδιο στην σωστή πλευρά του table και το αφαιρεί από το hand του player
     * 
     * @param t το πλακίδιο που έχει επιλέξει ο παίκτης από την selectTileUser
     */
    
    public void putTileOnTable(Tile t){
        if (putToSide(t)){
            table.addDominoLeft(t,getShouldFlip());
        }
        else{
            table.addDominoRight(t,getShouldFlip());
        }
    }

    public void bot(Player player, boolean first){
        Tile t;
        if (first){
            t = player.tileFromHand(0);
            putTileOnTable(t);
        }
        else{
          if (player.canPlayCardinal(table.getLeftSide())){
            t = player.tileFromHandCardinal(table.getLeftSide());
            putTileOnTable(t);
        }
        else{
            t = player.tileFromHandCardinal(table.getRightSide());
            putTileOnTable(t);
        }   
        }
        player.removeTile(t);
    }
    
}
