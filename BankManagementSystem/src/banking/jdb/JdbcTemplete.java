/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.jdb;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class JdbcTemplete {
    
    private static Connection con;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mybanking","root","anurag");
           
            
    
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            
            JOptionPane.showMessageDialog(null,"Loas Main Driver");
            
        } catch (SQLException ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "connection failed");
        } catch (InstantiationException ex) {
            
        } catch (IllegalAccessException ex) {
              
    }
} 
          public PreparedStatement pst(String sql)throws SQLException{
             // PreparedStatement p=con.prepareStatement(sql);
             // return pst(sql);
             return con.prepareStatement(sql);
              
          }
          public void update(PreparedStatement pst)throws SQLException{
      try {
          pst.executeUpdate();
      } finally{
          pst.close();
      }
              
          }
          
          public void update(String sql) throws SQLException{
             // PreparedStatement pst=this.pst(sql);
              //this.update(pst);
              this.update(this.pst(sql));
          }
          
          public ResultSet query(PreparedStatement pst)throws SQLException{
           ResultSet rs=pst.executeQuery();
           return  rs;//Do not close pst here 
          }
          public ResultSet query(String sql)throws SQLException{
          //PreparedStatement pst=this.pst(sql);
          //ResultSet rs=this.query(pst);
          //return rs;
          return query(pst(sql));
          }
        
}
