  /*Class:CardPanel
   * Extends - javax.swing.JPanel
   * Purpose - Creates a panel for the FightFrame, contains 6 buttons which plays a different animation and 1 which ends turn
   */

  import java.awt.*;

  public class CardPanel extends javax.swing.JPanel {

      /**
       * Creates new form CardPanel
       */
      Player player;
      Baz baz = new Baz();

      public CardPanel() {
          initComponents();

      }

      //This method is called from within the constructor to initialise the form.
      // this is a code comment

      private void initComponents() {

          StrikeButton1 = new javax.swing.JButton();
          StrikeButton1.addActionListener(this::strikeActionPerformed);
          DefendButton2 = new javax.swing.JButton();
          DefendButton2.addActionListener(this::defendActionPerformed);
          IronWaveButton3 = new javax.swing.JButton();
          IronWaveButton3.addActionListener(this::ironWaveActionPerformed);
          BashButton4 = new javax.swing.JButton();
          BashButton4.addActionListener(this::bashActionPerformed);
          BodySlamButton5 = new javax.swing.JButton();
          BodySlamButton5.addActionListener(this::bodySlam5ActionPerformed);
          Carnage6 = new javax.swing.JButton();
          Carnage6.addActionListener(this::endPhaseButton7ActionPerformed);
          jLabel1 = new javax.swing.JLabel();
          drawButton7 = new javax.swing.JButton();
          drawButton7.addActionListener(this::endPhaseButton7ActionPerformed);

          setBackground(new java.awt.Color(0, 0, 0));
          setMaximumSize(new java.awt.Dimension(1600, 300));
          setMinimumSize(new java.awt.Dimension(1600, 300));
          setPreferredSize(new java.awt.Dimension(1600, 300));

          StrikeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardImages/Strike.png")));

          DefendButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardImages/Defend.png")));

          IronWaveButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardImages/IronWave.png")));

          BashButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardImages/Bash.png")));

          BodySlamButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardImages/BodySlam.png")));

          Carnage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardImages/Carnage.png")));

          jLabel1.setText("Currently Fighting " + SuperEnemy.enemyName);
          jLabel1.setFont(new Font("SchoolHouse Printed A", Font.BOLD, 24));
          jLabel1.setForeground(Color.WHITE);

          drawButton7.setText("EndTurn");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addGroup(layout.createSequentialGroup()
                                  .addGap(22, 22, 22)
                                  .addComponent(StrikeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(DefendButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(IronWaveButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(BashButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(BodySlamButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(Carnage6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                  .addComponent(drawButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addContainerGap())
          );
          layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addGroup(layout.createSequentialGroup()
                                  .addGap(50, 50, 50)
                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(StrikeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(DefendButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(IronWaveButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(BashButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(BodySlamButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(Carnage6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(drawButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                  .addContainerGap(50, Short.MAX_VALUE))
          );
      }

      //These are all the functions for cards, each card has one of these functions.

      //Strike attack
      private void strikeActionPerformed(java.awt.event.ActionEvent evt) {
          Player.windUp();
          Player.BashAttack();
          Player.BashAttack();
          Player.BackToStart();
      }

      //Block card function
      private void defendActionPerformed(java.awt.event.ActionEvent evt) {

          Player.block();

      }
      //IronWave card function
      private void ironWaveActionPerformed(java.awt.event.ActionEvent evt) {
          Player.windUp();
          Player.IronWaveAttack();
          Player.BackToStart();
      }

      //IronWave card function
      private void bashActionPerformed(java.awt.event.ActionEvent evt) {
          Player.windUp();
          Player.BashAttack();
          Player.BackToStart();
      }

      private void bodySlam5ActionPerformed(java.awt.event.ActionEvent evt) {
          Player.windUp();
          Player.BodySlamAttack();
          Player.JumpingBackToStart();
      }

      private void endPhaseButton7ActionPerformed(java.awt.event.ActionEvent evt) {
          baz.attacking();

      }

      // Variables declaration
      private javax.swing.JButton StrikeButton1;
      private javax.swing.JButton DefendButton2;
      private javax.swing.JButton IronWaveButton3;
      private javax.swing.JButton BashButton4;
      private javax.swing.JButton BodySlamButton5;
      private javax.swing.JButton Carnage6;
      private javax.swing.JButton drawButton7;
      private javax.swing.JLabel jLabel1;

      // End of variables declaration
  }