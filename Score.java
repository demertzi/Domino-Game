
package domino2;

public class Score {
    
    private int round;
    private int score1;
    private int score2;
    private int score3;
    private int score4;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private int num = 0;
    
    public Score(){
        round = 1;
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
    }
    
     /**
     * Δημιουργεί τα score των παικτών
     * 
     * @param player1
     * @param player2 
     *
     * Ενημερώνει τα score και τους γύρους
     *
     */
    
    public Score(Player player1, Player player2){
       p1 = player1;
       p2 = player2;
       num = 2;
 
    }
    
    public Score(Player player1, Player player2, Player player3){
       p1 = player1;
       p2 = player2;
       p3 = player3;
       num = 3;
    }
    
    public Score(Player player1, Player player2, Player player3, Player player4){
       p1 = player1;
       p2 = player2;
       p3 = player3;
       p4 = player4;
       num = 4;
    }
    
    
    public void updateScore(){
        if (num == 2){
            round++;
            if (checkWinner()){
           if (p1.valueHand() < p2.valueHand()){
            
            score1 = score1 + p1.valueHand() + p2.valueHand();
        
            }
            else {
            
                score2 = score2 + + p1.valueHand() + p2.valueHand();
            }
        }
        else if (num == 3){
            round++;
            if(checkWinner()){
                if ((p1.valueHand() < p2.valueHand()) && (p1.valueHand() < p3.valueHand()))
                {
                    score1 = score1 + p1.valueHand() + p2.valueHand() + p3.valueHand();
                }
                else if (p2.valueHand() < p3.valueHand()){
                    score2 = score2 + p1.valueHand() + p2.valueHand() + p3.valueHand();
                }
                else {
                    score3 = score3 + p1.valueHand() + p2.valueHand() + p3.valueHand();
                }
            }
        }
        else{
            round++;
            if (checkWinner()){
            if ((p1.valueHand() < p2.valueHand()) && (p1.valueHand() < p3.valueHand()) && (p1.valueHand() < p4.valueHand()))
            {
                score1 = score1 + p1.valueHand() + p2.valueHand() + p3.valueHand() + p4.valueHand();
            }
            else if ((p2.valueHand() < p3.valueHand()) && (p2.valueHand() < p4.valueHand())){
                score2 = score2 + p1.valueHand() + p2.valueHand() + p3.valueHand() + p4.valueHand();
            }
            else if (p3.valueHand() < p4.valueHand()) {
                score3 = score3 + p1.valueHand() + p2.valueHand() + p3.valueHand() + p4.valueHand();
            }
            else{
                score4 = score4 + p1.valueHand() + p2.valueHand() + p3.valueHand() + p4.valueHand();
            }
            }
        }
        }
    }
    public int getScore1(){
        return score1;
    }
    
    public int getScore2(){
        return score2;
    }
    
    public int getScore3(){
        return score3;
    }
    
    public int getScore4(){
        return score4;
    }
    
    public int getRound(){
        return round;
    }
    
    /**
     * 
     * @return true αν υπάρχει κάποιος νικητής, αντίθετα false 
     */
    
    public boolean checkWinner(){
        
        if (score1 >= 100){
            return true;
        }
        else if (score2 >= 100){
            return true;
        }
        else if (score3 >= 100){
            return true;
        }
        else if (score4 >= 100){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * 
     * @return τον νικητή του γύρου
     */
    
    public Player getWinner(){
        
        Player winner = null;
        
        if ((score1 >= 100) && (score1 > score2) && (score1 > score3) && (score1 > score4)){
            winner = p1;
        }
        else if ((score2 >= 100) && (score2 > score1) && (score2 > score3) && (score2 > score4)){
            winner = p2;
        }
        else if ((score3 >= 100) && (score3 > score2) && (score3 > score1) && (score3 > score4)){
            winner = p3;
        }
        else if((score4 >= 100) && (score4 > score2) && (score4 > score3) && (score4 > score1)){
            winner = p4;
        }
        else if (score1 < 100 && score2 < 100){
            winner = null;
        }
        return winner;
    }
}
