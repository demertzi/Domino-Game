package domino2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingWorker;

/**
 *
 * @author demer
 */
public class HungarianFrame extends javax.swing.JFrame {

    private Player player,bot1,bot2,bot3,p1,p2,p3,p4;
    private Hungarian game;
    private Table table;
    private Score score;
    /**
     * Creates new form nj
     */
    public HungarianFrame() {
        initComponents();
    }
    
    public HungarianFrame(int players, String name){
        initComponents();   
        
        jLabel1.setText("Hello " +name + "! Welcome to the Hungarian Domino Game!");
        
        if (players == 2){

            table = new Table();
            player =  new Player(name);
            bot1 = new Player("Bot");
            game = new Hungarian (player,bot1,table);
            score = new Score(player,bot1);
            jLabelPlayer.setVisible(true);
            jLabelBot1.setVisible(true);
            jLabelBot1.setText("Bot");
            jLabelBot2.setVisible(false);
            jLabelBot3.setVisible(false);
            jLabelScoreP1.setVisible(true);
            jLabelScoreB1.setVisible(true);
            jLabelScoreB2.setVisible(false);
            jLabelScoreB3.setVisible(false);
            
            jRadioButton1.setVisible(true);
            jRadioButton2.setVisible(true);
            jRadioButton3.setVisible(true);
            jRadioButton4.setVisible(true);
            jRadioButton5.setVisible(true);
            jRadioButton6.setVisible(true);
            jRadioButton7.setVisible(true);
            jRadioButton8.setVisible(true);
            jRadioButton9.setVisible(true);
            jRadioButton10.setVisible(true);
            jRadioButton11.setVisible(true);
            jRadioButton12.setVisible(true); 
            
            play(2);
            win(2);
            
        }
        else if (players == 3){
            
            table = new Table();
            player =  new Player(name);
            bot1 = new Player("Bot 1");
            bot2 = new Player("Bot 2");
            game = new Hungarian (player,bot1,bot2,table);
            score = new Score(player,bot1,bot2);
            jLabelPlayer.setVisible(true);
            jLabelBot1.setVisible(true);
            jLabelBot2.setVisible(true);
            jLabelBot3.setVisible(false);
            jLabelScoreP1.setVisible(true);
            jLabelScoreB1.setVisible(true);
            jLabelScoreB2.setVisible(true);
            jLabelScoreB3.setVisible(false);
            
            jRadioButton1.setVisible(true);
            jRadioButton2.setVisible(true);
            jRadioButton3.setVisible(true);
            jRadioButton4.setVisible(true);
            jRadioButton5.setVisible(true);
            jRadioButton6.setVisible(true);
            jRadioButton7.setVisible(true);
            jRadioButton8.setVisible(true);
            jRadioButton9.setVisible(false);
            jRadioButton10.setVisible(false);
            jRadioButton11.setVisible(false);
            jRadioButton12.setVisible(false);
            
            play(3);
            win(3);
        }
        else{

            table = new Table();
            player =  new Player(name);
            bot1 = new Player("Bot 1");
            bot2 = new Player("Bot 2");
            bot3 = new Player("Bot 3");
            game = new Hungarian (player,bot1,bot2,bot3,table);
            score = new Score(player,bot1,bot2,bot3);
            jLabelPlayer.setVisible(true);
            jLabelBot1.setVisible(true);
            jLabelBot2.setVisible(true);
            jLabelBot3.setVisible(true);
            jLabelScoreP1.setVisible(true);
            jLabelScoreB1.setVisible(true);
            jLabelScoreB2.setVisible(true);
            jLabelScoreB3.setVisible(true);
            
            jRadioButton1.setVisible(true);
            jRadioButton2.setVisible(true);
            jRadioButton3.setVisible(true);
            jRadioButton4.setVisible(true);
            jRadioButton5.setVisible(true);
            jRadioButton6.setVisible(true);
            jRadioButton7.setVisible(false);
            jRadioButton8.setVisible(false);
            jRadioButton9.setVisible(false);
            jRadioButton10.setVisible(false);
            jRadioButton11.setVisible(false);
            jRadioButton12.setVisible(false);
            
            play(4);
            win(4);
            
        }
        
         printTiles();
         printTable();    
}
    public void win(int a){
        if (!score.checkWinner()){
            play(a);
        }
        else if (score.checkWinner()){
            endOfGame end = new endOfGame(1);
            end.setVisible(true); 
            end.getWin(score.getWinner());
        }
        else if (a == 2){
            if (!player.canPlayOnTable(table) && !bot1.canPlayOnTable(table)){
                endOfGame end = new endOfGame(2);
                end.setVisible(true);
            }
            
        }
        else if (a ==3){
            if (!player.canPlayOnTable(table) && !bot1.canPlayOnTable(table) && !bot2.canPlayOnTable(table)){
                endOfGame end = new endOfGame(3);
                end.setVisible(true);
            }
        }
        else if (a ==4){
            if (!player.canPlayOnTable(table) && !bot1.canPlayOnTable(table) && !bot2.canPlayOnTable(table) && !bot3.canPlayOnTable(table)){
                endOfGame end = new endOfGame(4);
                end.setVisible(true);
            }
        }
    }
    /**
     * Κινήσεις του bot
     * @param bot 
     */
    public void playBot (Player bot){
        while(bot.canPlayOnTable(table)){
            if (table.isEmpty()){
                game.bot(bot,true);
                printTable();
            }
            else{
                game.bot(bot,false);
                printTable();
            }
        }
    }
    /**
     * Οργανώνει τη σειρά των παικτών
     * @param num 
     */
    public void play(int num){
        if (num ==2){
            Player p1 = game.firstTurn(num);
            Player p2 = game.secondTurn(num);
            if (p1 == player){
                jLabelTurn.setText("Turn : You");
                System.out.println("First p");
                
                playPlayer(p2);
            }
            else{
                jLabelTurn.setText("Turn : Bot");
                playBot(p1);
                jLabel2.setVisible(true);
                jLabelTurn.setText("Turn : You");
                jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playPlayer(p1);
                }
                });
        }
        score.updateScore();
        jLabelScoreP1.setText("Score : " +score.getScore1());
        jLabelScoreB1.setText("Score : " +score.getScore2());
        }
        else if ( num == 3){
            Player p1 = game.firstTurn(num);
            Player p2 = game.secondTurn(num);
            Player p3 = game.thirdTurn(num);
            
            if (p1 == player){
                jLabelTurn.setText("Turn : You");
                System.out.println("First p");
                playPlayer(p2);
                playBot(p3);
            }
            else{
                jLabelTurn.setText("Turn : " + p1.getName());
                playBot(p1);
                if (p2 == player){
                    jLabelTurn.setText("Turn : You");
                    jLabel2.setVisible(true);
                    playPlayer(p3);
                }
                else{
                    jLabelTurn.setText("Turn : " +p2.getName());
                    playBot(p2);
                    jLabelTurn.setText("Turn : " + p3.getName());
                    playBot(p3);
                }
            }
            
        score.updateScore();
        jLabelScoreP1.setText("Score : " +score.getScore1());
        jLabelScoreB1.setText("Score : " +score.getScore2());
        jLabelScoreB2.setText("Score : " +score.getScore3());
        }
        else{
            Player p1 = game.firstTurn(num);
            Player p2 = game.secondTurn(num);
            Player p3 = game.thirdTurn(num);
            Player p4 = game.fourthTurn(num);
            
            if (p1 == player){
                jLabelTurn.setText("Turn : You");
                System.out.println("First p");
                playPlayer(p2);
                playBot(p3);
                playBot(p4);
            }
            else{
                jLabelTurn.setText("Turn : " +p1.getName());
                playBot(p1);
                if (p2 == player){
                    jLabelTurn.setText("Turn : You");
                    jLabel2.setVisible(true);
                    playPlayer(p3);
                    jLabelTurn.setText("Turn : " +p4.getName());
                    playBot(p4);
                }
                else{
                    jLabelTurn.setText("Turn : " +p2.getName());
                    playBot(p2);
                    if (p3 == player){
                        jLabelTurn.setText("Turn : You");
                        jLabel2.setVisible(true);
                        playPlayer(p4);
                    }
                    else{
                        jLabelTurn.setText("Turn : " +p3.getName());
                        playBot(p3);
                        jLabel2.setVisible(true);
                        jLabelTurn.setText("Turn : You");
                        playPlayer(p1);
                        
                    }
                }
            }
        }
        score.updateScore();
        jLabelScoreP1.setText("Score : " +score.getScore1());
        jLabelScoreB1.setText("Score : " +score.getScore2());
        jLabelScoreB2.setText("Score : " +score.getScore3());
        jLabelScoreB3.setText("Score : " +score.getScore4());
        
    }
    /**
     * Εκτελεί τις κινήσεις του player και καλεί το bot p να παίξει
     * @param p 
     */
    public void playPlayer(Player p){
        if(table.isEmpty()){
            for (int j =1; j<13; j++){
                enableTile(j);
            }    
        }
        jButton2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jLabel2.setVisible(false);
        if (player.canPlayOnTable(table)){
            int a=0;
            for (Tile tile : player.getHand()){
                a++;
                if (getTile(a).getSide1() == table.getLeftSide() || getTile(a).getSide1() == table.getRightSide() || getTile(a).getSide2() == table.getLeftSide() || getTile(a).getSide2() == table.getRightSide()){
                    if(player.hasTile(tile)){
                            enableTile(a);
                            System.out.println(tile.printHorizontal());
                    }
                    else{
                        unenableTile(a);
                    }
                }
            }
            System.out.println("" + table.getLeftSide() +"|" +table.getRightSide());
            }
           else{
               for (int i = 0;i<12;i++){
                   unenableTile(i);
                    playBot(p);
               }
           }
           }
            });
    }
    
    public Tile getTile(int number){
        
        int p = 0;
        Tile tile = null;
        for (Tile t : player.getHand()){
            p++;
            if (p == number){
                tile = t;
            }
        }
        return tile;
    }
    
    public void printTable(){
        String s ="";
        if (table.isEmpty()){
            textArea1.setText("The table is Empty!");
        }
        for (Tile tile : table.getDominos()){
            s = s + tile.printHorizontal();
            textArea1.setText(s);
        }
    }
    
    public void printTiles(){
        int t = 0;
        for (Tile tile : player.getHand()){
            t++;
            switch (t) {
                case 1:
                    jRadioButton1.setText(tile.printHorizontal());
                    break;
                case 2:
                    jRadioButton2.setText(tile.printHorizontal());
                    break;
                case 3:
                    jRadioButton3.setText(tile.printHorizontal());
                    break;
                case 4:
                    jRadioButton4.setText(tile.printHorizontal());
                    break;
                case 5:
                    jRadioButton5.setText(tile.printHorizontal());
                    break;
                case 6:
                    jRadioButton6.setText(tile.printHorizontal());
                    break;
                case 7:
                    jRadioButton7.setText(tile.printHorizontal());
                    break;
                case 8:
                    jRadioButton8.setText(tile.printHorizontal());
                    break;
                case 9:
                    jRadioButton9.setText(tile.printHorizontal());
                    break;
                case 10:
                    jRadioButton10.setText(tile.printHorizontal());
                    break;
                case 11:
                    jRadioButton11.setText(tile.printHorizontal());
                    break;
                case 12:
                    jRadioButton12.setText(tile.printHorizontal());
                    break;
                default:
                    break;
            }
        } 
    }
    
    public void visibleTile(int t){
        switch (t) {
            case 1:
                jRadioButton1.setVisible(false);
                break;
            case 2:
                jRadioButton2.setVisible(false);
                break;
            case 3:
                jRadioButton3.setVisible(false);
                break;
            case 4:
                jRadioButton4.setVisible(false);
                break;
            case 5:
                jRadioButton5.setVisible(false);
                break;
            case 6:
                jRadioButton6.setVisible(false);
                break;
            case 7:
                jRadioButton7.setVisible(false);
                break;
            case 8:
                jRadioButton8.setVisible(false);
                break;
            case 9:
                jRadioButton9.setVisible(false);
                break;
            case 10:
                jRadioButton10.setVisible(false);
                break;
            case 11:
                jRadioButton11.setVisible(false);
                break;
            case 12:
                jRadioButton12.setVisible(false);
                break;
            default:
                break;
        }
    }
    
    public void unenableTile(int t){
        
        switch (t) {
            case 1:
                jRadioButton1.setEnabled(false);
                break;
            case 2:
                jRadioButton2.setEnabled(false);
                break;
            case 3:
                jRadioButton3.setEnabled(false);
                break;
            case 4:
                jRadioButton4.setEnabled(false);
                break;
            case 5:
                jRadioButton5.setEnabled(false);
                break;
            case 6:
                jRadioButton6.setEnabled(false);
                break;
            case 7:
                jRadioButton7.setEnabled(false);
                break;
            case 8:
                jRadioButton8.setEnabled(false);
                break;
            case 9:
                jRadioButton9.setEnabled(false);
                break;
            case 10:
                jRadioButton10.setEnabled(false);
                break;
            case 11:
                jRadioButton11.setEnabled(false);
                break;
            case 12:
                jRadioButton12.setEnabled(false);
                break;
            default:
                break;
        }
    }
    
    public void enableTile(int t){
        
        switch (t) {
            case 1:
                jRadioButton1.setEnabled(true);
                break;
            case 2:
                jRadioButton2.setEnabled(true);
                break;
            case 3:
                jRadioButton3.setEnabled(true);
                break;
            case 4:
                jRadioButton4.setEnabled(true);
                break;
            case 5:
                jRadioButton5.setEnabled(true);
                break;
            case 6:
                jRadioButton6.setEnabled(true);
                break;
            case 7:
                jRadioButton7.setEnabled(true);
                break;
            case 8:
                jRadioButton8.setEnabled(true);
                break;
            case 9:
                jRadioButton9.setEnabled(true);
                break;
            case 10:
                jRadioButton10.setEnabled(true);
                break;
            case 11:
                jRadioButton11.setEnabled(true);
                break;
            case 12:
                jRadioButton12.setEnabled(true);
                break;
            default:
                break;
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        textArea1 = new java.awt.TextArea();
        jLabelScoreB1 = new javax.swing.JLabel();
        jLabelScoreB2 = new javax.swing.JLabel();
        jLabelScoreB3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelTurn = new javax.swing.JLabel();
        jLabelPlayer = new javax.swing.JLabel();
        jLabelBot1 = new javax.swing.JLabel();
        jLabelBot2 = new javax.swing.JLabel();
        jLabelBot3 = new javax.swing.JLabel();
        jLabelScoreP1 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRadioButton8.setText("jRadioButton8");
        jRadioButton8.setEnabled(false);
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jRadioButton9.setText("jRadioButton9");
        jRadioButton9.setEnabled(false);
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jRadioButton10.setText("jRadioButton10");
        jRadioButton10.setEnabled(false);
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        jRadioButton11.setText("jRadioButton11");
        jRadioButton11.setEnabled(false);
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });

        jRadioButton12.setText("jRadioButton12");
        jRadioButton12.setEnabled(false);
        jRadioButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton12ActionPerformed(evt);
            }
        });

        jButton1.setText("Help");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textArea1.setBackground(new java.awt.Color(102, 204, 255));
        textArea1.setForeground(new java.awt.Color(255, 255, 255));

        jLabelScoreB1.setText("Score : ");

        jLabelScoreB2.setText("Score : ");

        jLabelScoreB3.setText("Score :");

        jLabel12.setText("Table of Dominos");

        jLabel13.setText("Your tiles");

        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.setEnabled(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.setEnabled(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.setEnabled(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.setEnabled(false);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("jRadioButton5");
        jRadioButton5.setEnabled(false);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Player");

        jLabelTurn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTurn.setText("Turn : ");

        jLabelPlayer.setText("Your");

        jLabelBot1.setText("Bot 1 ");

        jLabelBot2.setText("Bot 2  ");

        jLabelBot3.setText("Bot 3  ");

        jLabelScoreP1.setText("Score : ");

        jRadioButton6.setText("jRadioButton6");
        jRadioButton6.setEnabled(false);
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jRadioButton7.setText("jRadioButton7");
        jRadioButton7.setEnabled(false);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jButton2.setText("Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Press to continue ->");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jRadioButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jRadioButton4))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton8)
                                    .addComponent(jRadioButton9))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton12, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel13)
                            .addComponent(jLabelTurn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPlayer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelScoreP1)
                                .addGap(83, 83, 83)
                                .addComponent(jLabelBot1)
                                .addGap(10, 10, 10)
                                .addComponent(jLabelScoreB1)
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(147, 147, 147)
                                        .addComponent(jLabelBot3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelBot2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelScoreB2)
                                        .addGap(104, 104, 104)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelScoreB3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabelTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlayer)
                    .addComponent(jLabelBot1)
                    .addComponent(jLabelBot2)
                    .addComponent(jLabelBot3)
                    .addComponent(jLabelScoreP1)
                    .addComponent(jLabelScoreB1)
                    .addComponent(jLabelScoreB2)
                    .addComponent(jLabelScoreB3))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        
        jRadioButton8.setVisible(false);
        game.putTileOnTable(getTile(8));
        printTable();
        player.removeTile(getTile(8));
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed

        jRadioButton9.setVisible(false);
        game.putTileOnTable(getTile(9));
        printTable();
        player.removeTile(getTile(9));
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        
        jRadioButton10.setVisible(false);
        game.putTileOnTable(getTile(10));
        printTable();
        player.removeTile(getTile(10));
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
       
        jRadioButton11.setVisible(false);
        game.putTileOnTable(getTile(11));
        printTable();
        player.removeTile(getTile(11));
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton12ActionPerformed
       
        jRadioButton12.setVisible(false);
        game.putTileOnTable(getTile(12));
        printTable();
        player.removeTile(getTile(12));
    }//GEN-LAST:event_jRadioButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Help help = new Help(2);
        help.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

        jRadioButton1.setVisible(false);
        game.putTileOnTable(getTile(1));
        printTable();
        player.removeTile(getTile(1));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

        jRadioButton2.setVisible(false);
        game.putTileOnTable(getTile(2));
        printTable();
        player.removeTile(getTile(2));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed

        jRadioButton3.setVisible(false);
        game.putTileOnTable(getTile(3));
        printTable();
        player.removeTile(getTile(3));
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed

        jRadioButton4.setVisible(false);
        game.putTileOnTable(getTile(4));
        printTable();
        player.removeTile(getTile(4));
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed

        jRadioButton5.setVisible(false);
        game.putTileOnTable(getTile(5));
        printTable();
        player.removeTile(getTile(5));
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed

        jRadioButton6.setVisible(false);
        game.putTileOnTable(getTile(6));
        printTable();
        player.removeTile(getTile(6));
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed

        jRadioButton7.setVisible(false);
        game.putTileOnTable(getTile(7));
        printTable();
        player.removeTile(getTile(7));
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HungarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HungarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HungarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HungarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HungarianFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBot1;
    private javax.swing.JLabel jLabelBot2;
    private javax.swing.JLabel jLabelBot3;
    private javax.swing.JLabel jLabelPlayer;
    private javax.swing.JLabel jLabelScoreB1;
    private javax.swing.JLabel jLabelScoreB2;
    private javax.swing.JLabel jLabelScoreB3;
    private javax.swing.JLabel jLabelScoreP1;
    private javax.swing.JLabel jLabelTurn;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
