/*Class: Register
* Extends - javax.swing.JFrame
* Purpose - Allows the user to register the user

 */
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisterGUI extends javax.swing.JFrame {

   /**
    * Creates new form RegisterForm
    */
public RegisterGUI() {
        initComponents();
        }

// This method is called from within the constructor to initialise the form.

@SuppressWarnings("unchecked")

private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabel_Register = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_Username = new javax.swing.JLabel();
        jLabel_Password = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        RegisterButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();
        jLabel_RetryPassword = new javax.swing.JLabel();
        PasswordField_ReEnter = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(Color.black);

        jLabelClose.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelCloseMouseClicked();
        }
        });

        jLabel_Register.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        jLabel_Register.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Register.setText("Register");

        jLabelMin.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMinMouseClicked();
        }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        // Setting the Horizontal group layout for buttons Vertical to panel 1
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(365, Short.MAX_VALUE)
        .addComponent(jLabelMin)
        .addGap(18, 18, 18)
        .addComponent(jLabelClose)
        .addGap(21, 21, 21))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addComponent(jLabel_Register)
        .addContainerGap(302, Short.MAX_VALUE)))
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
        .addComponent(jLabel_Register, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        jLabel_Username.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        jLabel_Username.setForeground(new java.awt.Color(236, 240, 241));
        jLabel_Username.setText("Username:");

        jLabel_Password.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        jLabel_Password.setForeground(new java.awt.Color(236, 240, 241));
        jLabel_Password.setText("Password:");

        UsernameField.setBackground(new java.awt.Color(108, 122, 137));
        UsernameField.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        UsernameField.setForeground(new java.awt.Color(228, 241, 254));

        PasswordField.setBackground(new java.awt.Color(108, 122, 137));
        PasswordField.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        PasswordField.setForeground(new java.awt.Color(228, 241, 254));

        RegisterButton.setBackground(new java.awt.Color(34, 167, 240));
        RegisterButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(this::jButton_Register_ActionPerformed);

        CancelButton.setBackground(new java.awt.Color(242, 38, 19));
        CancelButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(evt -> jButton_CANCELActionPerformed());

        jLabelRegister.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        jLabelRegister.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegister.setText("click here to login");
        jLabelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelRegisterMouseClicked();
        }
        });

        jLabel_RetryPassword.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        jLabel_RetryPassword.setForeground(new java.awt.Color(236, 240, 241));
        jLabel_RetryPassword.setText("Retype Pass:");

        PasswordField_ReEnter.setBackground(new java.awt.Color(108, 122, 137));
        PasswordField_ReEnter.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        PasswordField_ReEnter.setForeground(new java.awt.Color(228, 241, 254));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        // Setting the Horizontal group layout for buttons Vertical to panel 2
        jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(89, 89, 89)
        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(26, 26, 26)
        .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(43, 43, 43)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(8, 8, 8)
        .addComponent(jLabel_Username)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addComponent(jLabel_Password)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(34, 34, 34)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
        .addComponent(jLabel_RetryPassword))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
        .addComponent(PasswordField_ReEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(146, 146, 146)
        .addComponent(jLabelRegister)))
        .addContainerGap(24, Short.MAX_VALUE))
        );
        // Setting the Vertical group layout for buttons Vertical to panel 2
        jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(51, 51, 51)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel_Username)
        .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel_Password))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel_RetryPassword)
        .addComponent(PasswordField_ReEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabelRegister)
        .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        }

private void jLabelCloseMouseClicked() {
        //Close program when label is pressed
        System.exit(0);

        }

private void jLabelMinMouseClicked() {
        //Minimises window when button is pressed
        this.setState(JFrame.ICONIFIED);

        }

private void jLabelRegisterMouseClicked() {
        Login2 lgf = new Login2();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        }

private void jButton_Register_ActionPerformed(java.awt.event.ActionEvent evt) {

        String username = UsernameField.getText();
        String password = String.valueOf(PasswordField.getPassword());
        String re_password = String.valueOf(PasswordField_ReEnter.getPassword());

        //This is input validation to ensure that the user's login details is correct

        //No empty parameters for username
        if (username.equals("")) {
        JOptionPane.showMessageDialog(null, "Add A Username");
        }
        //Username cannot be longer that 20 characters
        else if (username.length() > 20) {
        JOptionPane.showMessageDialog(null, "Username is too long");
        }
        //Username cannot be shorter than 4 Characters
        else if (username.length() < 4) {
        JOptionPane.showMessageDialog(null, "Username is too short");
        }
        //no empty parameters for password
        else if (password.equals("")) {
        JOptionPane.showMessageDialog(null, "Add A Password");
        }
        //Password cannot be shorter than 6 characters
        else if (password.length() < 6) {
        JOptionPane.showMessageDialog(null, "Password is too short");
        }
        //Password must contain both numbers and letters
        else if (!isAlphanumeric(password)) {
        JOptionPane.showMessageDialog(null, "please include both numbers and letters in your password");
        }
        //Retype password must be the same as regular password
        else if (!password.equals(re_password)) {
        JOptionPane.showMessageDialog(null, "Retype The Password Again");
        }

        //checks if the username can already be found within the database
        else if (checkUsername(username)) {
        JOptionPane.showMessageDialog(null, "This Username Already Exist");
        } else {

        //This is using SQL insert statement to put data into the database
        PreparedStatement ps;
        String query = "INSERT INTO `Users`(`username`, `password`) VALUES (?,?)";

        try {
        ps = DBconnection.connect().prepareStatement(query);

        ps.setString(1, username);
        ps.setString(2, password);

        if (ps.executeUpdate() > 0) {
        JOptionPane.showMessageDialog(null, "New User Add");
        }

        } catch (SQLException ex) {
        Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        }

// function to check if the username can already be found in the database
public boolean checkUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `Users` WHERE `username` =?";

        try {
        ps = DBconnection.connect().prepareStatement(query);
        ps.setString(1, username);

        rs = ps.executeQuery();

        if (rs.next()) {
        checkUser = true;
        }
        } catch (SQLException ex) {
        Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkUser;
        }

// This Function is used to check that the password contains both Numbers and Letters
public boolean isAlphanumeric(String str) {
        char[] charArray = str.toCharArray();
        for (char c: charArray) {
        if (!Character.isLetterOrDigit(c))
        return false;
        }
        return true;
        }

private void jButton_CANCELActionPerformed() {
        System.exit(0);
        //Closes window
        }

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
        javax.swing.UIManager.setLookAndFeel(info.getClassName());
        break;
        }
        }
        } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
        new RegisterGUI().setVisible(true);
        }
        });
        }

//Variables declaration
private javax.swing.JButton CancelButton;
private javax.swing.JButton RegisterButton;
private javax.swing.JLabel jLabel_Register;
private javax.swing.JLabel jLabel_Username;
private javax.swing.JLabel jLabel_Password;
private javax.swing.JLabel jLabel_RetryPassword;
private javax.swing.JLabel jLabelClose;
private javax.swing.JLabel jLabelMin;
private javax.swing.JLabel jLabelRegister;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JPasswordField PasswordField;
private javax.swing.JPasswordField PasswordField_ReEnter;
private javax.swing.JTextField UsernameField;
// End of variables declaration
        }