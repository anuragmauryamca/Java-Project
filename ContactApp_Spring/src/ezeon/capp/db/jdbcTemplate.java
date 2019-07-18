
package ezeon.capp.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *This class takes data base job open connection exit
 * @author Anurag
 */
public class jdbcTemplate {

  private static Connection con;
  static {
    
      
    
            
          try {
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capp_ss2_db","root","anurag");
              
          }
          catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "faild load driver");
              ex.printStackTrace();
          }
          catch (Exception ex) {
     JOptionPane.showMessageDialog(null,"Faild open connection");
          ex.printStackTrace();
       
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
        
  public boolean testCon(){
      if(con==null){
          return false;
      }else{
          return true;
      }
  }
}
      
      

