/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.capp.main;

import ezeon.capp.gui.LoginDialog;


public class StartApp {

    /**project /Application execution entry point
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginDialog d=new LoginDialog(null, true);
       
        d.setLocationRelativeTo(null);//center of desktop
         d.setVisible(true);
    }
    
}
