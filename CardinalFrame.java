/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author demer
 */
public class CardinalFrame extends javax.swing.JFrame {

    private Player player,bot1,bot2,bot3,p1,p2,p3,p4;
    private Cardinal game;
    private Table table;
    private Score score;
    
    public CardinalFrame() {
        initComponents();
    }
    /**
     * 
     * @param players
     * @param name 
     */
    public CardinalFrame(int players, String name) {
        initComponents();
        
        jLabel1.setText("Hello " + name + "! Welcome to the Cardinal Domino Game!");
        
        if (players == 2){
            
            table = new Table();
            player =  new Player(name);
            bot1 = new Player("Bot");
            game = new Cardinal (player,bot1,table);
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
            
                play(2);
        }
        else if (players == 3){
            
            table = new Table();
            player =  new Player(name);
            bot1 = new Player("Bot 1");
            bot2 = new Player("Bot 2");
            game = new Cardinal (player,bot1,bot2,table);
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
            jRadioButton6.setVisible(false);
            jRadioButton7.setVisible(false);
            
                play(3);
        }
        else{
            
            table = new Table();
            player =  new Player(name);
            bot1 = new Player("Bot 1");
            bot2 = new Player("Bot 2");
            bot3 = new Player("Bot 3");
            game = new Cardinal (player,bot1,bot2,bot3,table);
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
            jRadioButton6.setVisible(false);
            jRadioButton7.setVisible(false);
            
                play(4);
        }
        
        printTiles();
        printTable(); 
    }
    
    /**
     * To num δείχνει πόσοι παίκτες υπάρχουν
     * Οργανώνει την σειρά των παικτών και επιτρέπει να παίξουν
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
                    jLabelTurn.setText("Turn : You");;
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
                    playPlayer(p3);
                    jLabelTurn.setText("Turn : " +p4.getName());
                    playBot(p4);
                }
                else{
                    jLabelTurn.setText("Turn : " +p2.getName());
                    playBot(p2);
                    if (p3 == player){
                        jLabelTurn.setText("Turn : You");
                        playPlayer(p4);
                    }
                    else{
                        jLabelTurn.setText("Turn : " +p3.getName());
                        playBot(p3);
                        jLabelTurn.setText("Turn : You");
                        playPlayer(p1);
                        
                    }
                }
            }
        }
        score.updateScore();
        jLabelScoreB1.setText("Score : " +score.getScore2());
        jLabelScoreB2.setText("Score : " +score.getScore3());
        jLabelScoreB3.setText("Score : " +score.getScore4());
        
    }
    
    /**
     * Δέχεται ένα bot και εκτελεί τις κινήσεις του
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
     * Θέτει ορατό το Tile t
     * @param t 
     */
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
            default:
                break;
        }
    }
    
    /**
     * Θέτει unenable το Tile t
     * @param t 
     */
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
            default:
                break;
        }
    }
    
    /**
     * Θέτει enable το Tile t
     * @param t 
     */
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
            default:
                break;
        }
    }
    
    /**
     * Επιστρέφει το Tile κατά σειρά number
     * @param number
     * @return 
     */
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
    
    /**
     * Εκτελεί τις κινήσεις του παίκτη p
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
        if (player.canPlayOnTable(table)){
            int a=0;
            for (Tile tile : player.getHand()){
                a++;
                if (getTile(a).getSide1()+table.getLeftSide() == 7  || getTile(a).getSide1() + table.getRightSide() ==7 || getTile(a).getSide2() + table.getLeftSide() == 7 || getTile(a).getSide2() + table.getRightSide() ==7){
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
    
    /**
     * Τυπώνει το table
     */
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
    
    /**
     * Tυπώνει τα tiles του παίκτη
     */
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
                default:
                    break;
            }
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

        tilesGroup = new javax.swing.ButtonGroup();
        jLabelBot2 = new javax.swing.JLabel();
        jLabelBot3 = new javax.swing.JLabel();
        jLabelScoreP1 = new javax.swing.JLabel();
        jLabelScoreB1 = new javax.swing.JLabel();
        jLabelScoreB2 = new javax.swing.JLabel();
        jLabelScoreB3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelTurn = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelPlayer = new javax.swing.JLabel();
        jLabelBot1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        textArea1 = new java.awt.TextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelBot2.setText("Bot 2 : ");

        jLabelBot3.setText("Bot 3 : ");

        jLabelScoreP1.setText("Score : 0");

        jLabelScoreB1.setText("Score : 0");

        jLabelScoreB2.setText("Score : 0");

        jLabelScoreB3.setText(" Score : 0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Player");

        jLabel12.setText("Table of Dominos");

        jLabelTurn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTurn.setText("Turn : ");

        jLabel13.setText("Your tiles");

        jLabelPlayer.setText("Player : ");

        jLabelBot1.setText("Bot 1 : ");

        tilesGroup.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        tilesGroup.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        tilesGroup.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        tilesGroup.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        tilesGroup.add(jRadioButton5);
        jRadioButton5.setText("jRadioButton5");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        tilesGroup.add(jRadioButton6);
        jRadioButton6.setText("jRadioButton6");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        tilesGroup.add(jRadioButton7);
        jRadioButton7.setText("jRadioButton7");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jButton1.setText("Help");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textArea1.setBackground(new java.awt.Color(0, 204, 255));

        jButton2.setText("Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabelScoreP1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBot1)
                                    .addComponent(jLabelScoreB1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8)))
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelBot2)
                                .addGap(117, 117, 117))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelScoreB2)
                                .addGap(115, 115, 115)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBot3)
                            .addComponent(jLabelScoreB3))
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTurn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jRadioButton5)
                                .addGap(77, 77, 77)
                                .addComponent(jRadioButton6)
                                .addGap(79, 79, 79)
                                .addComponent(jRadioButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(60, 60, 60)
                                        .addComponent(jRadioButton2)
                                        .addGap(70, 70, 70)
                                        .addComponent(jRadioButton3)
                                        .addGap(72, 72, 72)
                                        .addComponent(jRadioButton4))
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelPlayer)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(0, 100, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTurn)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlayer)
                    .addComponent(jLabelBot1)
                    .addComponent(jLabelBot2)
                    .addComponent(jLabelBot3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelScoreP1)
                    .addComponent(jLabelScoreB1)
                    .addComponent(jLabelScoreB2)
                    .addComponent(jLabelScoreB3))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton7))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(23, 23, 23))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setVisible(false);
        game.putTileOnTable(getTile(1));
        printTable();
        player.removeTile(getTile(1));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Help help = new Help(3);
        help.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton2.setVisible(false);
        game.putTileOnTable(getTile(2));
        printTable();
        player.removeTile(getTile(2));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        jRadioButton3.setVisible(false);
        game.putTileOnTable(getTile(3));
        printTable();
        player.removeTile(getTile(3));
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        jRadioButton4.setVisible(false);
        game.putTileOnTable(getTile(4));
        printTable();
        player.removeTile(getTile(4));
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here
        jRadioButton5.setVisible(false);
        game.putTileOnTable(getTile(5));
        printTable();
        player.removeTile(getTile(5));
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        jRadioButton6.setVisible(false);
        game.putTileOnTable(getTile(6));
        printTable();
        player.removeTile(getTile(6));
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(CardinalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardinalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardinalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardinalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardinalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private java.awt.TextArea textArea1;
    private javax.swing.ButtonGroup tilesGroup;
    // End of variables declaration//GEN-END:variables
}
