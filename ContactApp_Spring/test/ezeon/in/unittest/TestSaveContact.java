/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.in.unittest;

import ezeon.capp.domain.Contact;
import ezeon.capp.service.ContactService;
import ezeon.capp.service.ContactServiceImpl;
import java.sql.SQLException;

/**
 *
 * @author Anurag
 */
public class TestSaveContact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ContactService cs=new ContactServiceImpl();
        Contact c=new Contact();
        c.setUserId(2);//Anurag Fk
        c.setName("Anurag");
        c.setPhone("9786767");
        c.setEmail("anu@");
        c.setAddress("Bpl");
        c.setRemark("Yes");
        cs.save(c);
        
    }
    
}
