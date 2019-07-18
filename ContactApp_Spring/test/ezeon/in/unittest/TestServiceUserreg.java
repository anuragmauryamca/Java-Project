/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.in.unittest;

import ezeon.capp.domain.User;
import ezeon.capp.service.UserService;
import ezeon.capp.service.UserServiceImpl;
import java.sql.SQLException;

/**
 *
 * @author Anurag
 */
public class TestServiceUserreg {

   
    public static void main(String[] args)throws SQLException {
        UserService us=new UserServiceImpl();
        User u=new User();//todo user detail form form
        u.setName("anu");
        u.setPhone("799");
        u.setEmail("anu@");
        u.setAddress("Bpl");
        u.setLoginName("San");
        u.setPassword("a123");
        u.setRole(2);
        u.setStatus(1);
        us.register(u);
        
  
    }
//    
}
