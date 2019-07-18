/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ProgressBar;

/**
 *
 * @author Anurag
 */
public class ProcessBar extends javax.swing.JDialog implements Runnable{
    
Thread th;
int s=0;
    /**
     * Creates new form ProcessBar
     */
    public ProcessBar() {
    th=new Thread((Runnable)this);
      initComponents();
        
    }
    
    public void setUploading(){
      
        th.start();
    }
    public void run(){
        try{
          for(int i=1;i<=200;i++){
                s=s+1;
            int m=jProgressBar1.getMaximum();
            int n=jProgressBar1.getValue();
            if(n<m){
                jProgressBar1.setValue(jProgressBar1.getValue()+1);
                
            }else{
                i=201;
                setVisible(false);
                  Home home=new Home();
                  home.setVisible(true);
            }
            Thread.sleep(50);
            
          }
            
            
            
        }catch(Exception ex){
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/download.png"))); // NOI18N

        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setStringPainted(true);

        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Redirecting");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/responsive-house.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(188, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(738, 591));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables


}



