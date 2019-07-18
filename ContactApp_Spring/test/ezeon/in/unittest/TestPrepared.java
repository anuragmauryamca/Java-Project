/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.in.unittest;

import java.sql.*;
import ezeon.capp.db.jdbcTemplate;

/**
 *
 * @author Anurag
 */
public class TestPrepared {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        jdbcTemplate jt=new jdbcTemplate();
        String sql="INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`, `role`, `status`)VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst=jt.pst(sql);
        pst.setString(1,"Anurag");
        pst.setString(2,"787897879");
        pst.setString(3,"anura@");
        pst.setString(4,"bpl");
        pst.setString(5,"Anurag");
        pst.setString(6,"aa123");
        pst.setInt(7, 2);//user role
        pst.setInt(8, 1);//active status
        jt.update(pst);
    }
    
}
