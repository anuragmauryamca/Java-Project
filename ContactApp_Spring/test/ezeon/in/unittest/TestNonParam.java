/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.in.unittest;

import ezeon.capp.db.jdbcTemplate;
import java.sql.SQLException;

/**
 *
 * @author Anurag
 */
public class TestNonParam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       
        jdbcTemplate p=new jdbcTemplate();
        String sql="DELETE FROM user WHERE userId=1";
        p.update(sql);
        
    }
    
}
