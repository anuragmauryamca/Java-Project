/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.in.unittest;

import ezeon.capp.domain.User;
import ezeon.capp.service.UserBlockException;
import ezeon.capp.service.UserService;
import ezeon.capp.service.UserServiceImpl;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Anurag
 */
public class TestLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UserBlockException, SQLException {
        // TODO code application logic here
        UserService us=new UserServiceImpl();
        User u=us.authenticate("Anu","a123");
        
        if(u==null){
            System.out.println("faild");
            JOptionPane.showMessageDialog(null,"Record Is Not Match");
        }else{
            JOptionPane.showMessageDialog(null,"Record Is Matched");
            System.out.print("success");
            System.out.println("UserId="+u.getUserId()+" "+"Name="+u.getName()+" "+"Phone="+u.getPhone());
        }
        
    }
    
}
