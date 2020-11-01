/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino2;



/**
 *
 * @author demer
 */
public class PlayersInfo extends javax.swing.JFrame {

    /**
     * Creates new form PlayersInfo
     */
    private int num = 0;
    private String name;
    private Menu menu;
    private int game = 0;
    
    
    public PlayersInfo() {
        
        initComponents();                
    }
    
    public PlayersInfo(int game){
        initComponents();
        
        this.game = game;
        if (game == 1){
            jLabel2.setVisible(false);
            jRadioButton2Players.setVisible(false);
            jRadioButton3Players.setVisible(false);
            jRadioButton4Players.setVisible(false);
        }
        else{
            jLabel2.setVisible(true);
            jRadioButton2Players.setVisible(true);
            jRadioButton3Players.setVisible(true);
            jRadioButton4Players.setVisible(true);
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

        NumberOfPlayers = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        textField1 = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton2Players = new javax.swing.JRadioButton();
        jRadioButton3Players = new javax.swing.JRadioButton();
        jRadioButton4Players = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Type your name : ");

        textField1.setBackground(new java.awt.Color(153, 153, 153));
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        NumberOfPlayers.add(jRadioButton2Players);
        jRadioButton2Players.setText("2");
        jRadioButton2Players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2PlayersActionPerformed(evt);
            }
        });

        NumberOfPlayers.add(jRadioButton3Players);
        jRadioButton3Players.setText("3");
        jRadioButton3Players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3PlayersActionPerformed(evt);
            }
        });

        NumberOfPlayers.add(jRadioButton4Players);
        jRadioButton4Players.setText("4");
        jRadioButton4Players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4PlayersActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Number of players : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(jRadioButton2Players)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3Players)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4Players))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton2Players)
                        .addComponent(jRadioButton3Players)
                        .addComponent(jRadioButton4Players)))
                .addGap(23, 23, 23)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:     
        
    }//GEN-LAST:event_textField1ActionPerformed

    private void jRadioButton2PlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2PlayersActionPerformed
        num = 2;       
    }//GEN-LAST:event_jRadioButton2PlayersActionPerformed

    private void jRadioButton3PlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3PlayersActionPerformed
        num = 3;

    }//GEN-LAST:event_jRadioButton3PlayersActionPerformed

    private void jRadioButton4PlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4PlayersActionPerformed
        num = 4;
    }//GEN-LAST:event_jRadioButton4PlayersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        name = textField1.getText();
        this.dispose();
        if (game == 1){
            Solo1Frame solo1 = new Solo1Frame(name);
            solo1.setVisible(true);
        }
        else if (game == 2){
           // HungarianFrame hungarian = new HungarianFrame(num,name);
           // hungarian.setVisible(true);
           HungarianFrame nh = new HungarianFrame(num,name);
           nh.setVisible(true);
        }
        else if (game == 3){
            CardinalFrame cardinal = new CardinalFrame(num,name);
            cardinal.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PlayersInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayersInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayersInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayersInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new PlayersInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup NumberOfPlayers;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton2Players;
    private javax.swing.JRadioButton jRadioButton3Players;
    private javax.swing.JRadioButton jRadioButton4Players;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}