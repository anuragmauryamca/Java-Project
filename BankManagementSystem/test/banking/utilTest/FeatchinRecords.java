/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.utilTest;

import banking.jdb.JdbcTemplete;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anurag
 */
public class FeatchinRecords {

   
    public static void main(String[] args) throws SQLException {
        
        
        JdbcTemplete jt=new JdbcTemplete();
        String sql="SELECT  name FROM an";
        PreparedStatement pst=(PreparedStatement) jt.pst(sql);
        ResultSet rs=jt.query(pst);
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        
    }
    
    
}
