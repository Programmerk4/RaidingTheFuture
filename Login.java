/*Class: Login
 * Extends - javax.swing.JFrame
 * Purpose - First screen of Program, allows the user to login in, or gives option to register
 */

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null); // centre form in the screen
    }
    private void initComponents() {

        //instantiate swing components
        MainPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jUsernameLabel = new javax.swing.JLabel();
        jPasswordLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton_LOGIN = new javax.swing.JButton();
        jButton_CANCEL = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        MainPanel1.setBackground(Color.black);

        //setting the homeTheme for the x button
        jLabelClose.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked();
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login Form");

        jLabelMin.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(MainPanel1);
        MainPanel1.setLayout(jPanel1Layout);
        // Setting the horizontal group layout for buttons horizontal to panel 1
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelMin)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelClose)
                                .addGap(21, 21, 21))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel2)
                                        .addContainerGap(236, Short.MAX_VALUE)))
        );
        // Setting the Vertical group layout for buttons Vertical to panel 1
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMin, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(jLabelClose))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                        .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        //Username Label settings
        jUsernameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        jUsernameLabel.setForeground(new java.awt.Color(236, 240, 241));
        jUsernameLabel.setText("Username:");

        //PasswordLabel settings
        jPasswordLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        jPasswordLabel.setForeground(new java.awt.Color(236, 240, 241));
        jPasswordLabel.setText("Password:");

        //Username TextField settings
        jTextField1.setBackground(new java.awt.Color(108, 122, 137));
        jTextField1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        jTextField1.setForeground(new java.awt.Color(228, 241, 254));

        //PasswordField Settings
        jPasswordField1.setBackground(new java.awt.Color(108, 122, 137));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        jPasswordField1.setForeground(new java.awt.Color(228, 241, 254));

        //Login Button Settings
        jButton_LOGIN.setBackground(new java.awt.Color(34, 167, 240));
        jButton_LOGIN.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton_LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        jButton_LOGIN.setText("Login");
        jButton_LOGIN.addActionListener(this::jButton_LOGINActionPerformed);
        //Cancel Button Settings
        jButton_CANCEL.setBackground(new java.awt.Color(242, 38, 19));
        jButton_CANCEL.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton_CANCEL.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CANCEL.setText("Cancel");
        jButton_CANCEL.addActionListener(this::jButton_CANCELActionPerformed);

        //LabelRegister Settings
        jLabelRegister.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        jLabelRegister.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegister.setText("click here to create a new account");
        jLabelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked();
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        //setting horizontal group conditions for panel2
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPasswordField1))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jButton_CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(26, 26, 26)
                                                        .addComponent(jButton_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addComponent(jLabelRegister)))
                                .addContainerGap(59, Short.MAX_VALUE))
                //setting vertical group conditions for panel2
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jUsernameLabel)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPasswordLabel)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelRegister)
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        //group layout to add components horizontally
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //group layout to add components vertically
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(MainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void jLabelCloseMouseClicked() {
        //close program
        System.exit(0);

    }

    private void jLabelMinMouseClicked() {

        this.setState(JFrame.ICONIFIED);
        //minimise screen

    }

    private void jLabelRegisterMouseClicked() {
        //gives mouse input to label instead of using a button
        RegisterGUI rgf = new RegisterGUI();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void jButton_CANCELActionPerformed(java.awt.event.ActionEvent evt) {
        //close program
        System.exit(0);

    }

    private void jButton_LOGINActionPerformed(java.awt.event.ActionEvent evt) {
        //Checking if login information is found in database, if so, takes to main game
        PreparedStatement ps;
        ResultSet rs;
        String uname = jTextField1.getText();
        String pass = String.valueOf(jPasswordField1.getPassword());

        String query = "SELECT * FROM `Users` WHERE `username` =? AND `password` =?";

        try {
            //connection to database
            ps = DBconnection.connect().prepareStatement(query);

            //adding data into database
            ps.setString(1, uname);
            ps.setString(2, pass);

            rs = ps.executeQuery();

            if (rs.next()) {

                new StartFrame().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, ex);

            //Try and catch used to make sure that the if database is not there, a message is sent, instead of crashing
        }

    }
    public static void main(String[] args) {
        //to test the gui
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Login2().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton jButton_CANCEL;
    private javax.swing.JButton jButton_LOGIN;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jUsernameLabel;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPanel MainPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//

}
