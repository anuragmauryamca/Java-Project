/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.capp.gui;

import ezeon.capp.domain.User;
import ezeon.capp.service.UserBlockException;
import ezeon.capp.service.UserService;
import ezeon.capp.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LoginDialog extends javax.swing.JDialog {
//when user is successfully login this variable hold its details to track logged in user this feture to sesseion tracking in web-application
    UserService userService=new UserServiceImpl();
    
    
    public static User   loggedinUser;
    
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfLoginName = new javax.swing.JTextField();
        btnLog = new javax.swing.JButton();
        btnReg = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ezeon/capp/gui/icon/login.png"))); // NOI18N
        jLabel1.setText("Login User");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Login Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        tfLoginName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginNameActionPerformed(evt);
            }
        });
        tfLoginName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfLoginNameKeyReleased(evt);
            }
        });

        btnLog.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnLog.setText("Login");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });

        btnReg.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnReg.setText("User Registration");
        btnReg.setActionCommand("");
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Copy Right by Mcu Bhopal[2018-2019] www.mcu.ac.in");

        tfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLoginName)
                            .addComponent(tfPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReg, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLog)
                .addGap(18, 18, 18)
                .addComponent(btnReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfLoginNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginNameActionPerformed

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
       
         try {
              String ln=tfLoginName.getText();
        char[] arr=tfPassword.getPassword();
        String pw=new String(arr);
            loggedinUser=userService.authenticate(ln, pw);
            if(loggedinUser==null){
                JOptionPane.showMessageDialog(this,"Login Faild to open check credentials");
            }else{
                //success
                if(loggedinUser.getRole().equals(1)){
                    //admin
                    //Todo
                }else if(loggedinUser.getRole().equals(2)){
                    //user role
                    this.dispose();
                    UserFrame f=new UserFrame();
                     f.setLocationRelativeTo(null);
                    f.setVisible(true);
                   
                }
            }
        } catch (UserBlockException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,ex.getMessage());
        } catch (SQLException ex) {
          ex.printStackTrace();
           JOptionPane.showMessageDialog(this,"Data Base prroblems occured");
        }
    }//GEN-LAST:event_btnLogActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
       //open regis
       RegFormDialog d=new RegFormDialog(null,true);
       d.setLocationRelativeTo(this);
       d.setVisible(true);
       
       
    }//GEN-LAST:event_btnRegActionPerformed

    private void tfLoginNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLoginNameKeyReleased
       doLoginOnEnter(evt);
    }//GEN-LAST:event_tfLoginNameKeyReleased

    private void tfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswordKeyReleased
        doLoginOnEnter(evt);
        
    }
        public void doLoginOnEnter(java.awt.event.KeyEvent evt){
            
        if(evt.getKeyCode()==10){
            btnLog.doClick();//click a Button programatically 
        }
    }//GEN-LAST:event_tfPasswordKeyReleased

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfLoginName;
    private javax.swing.JPasswordField tfPassword;
    // End of variables declaration//GEN-END:variables
}
