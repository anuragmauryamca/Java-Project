
package ezeon.in.unittest;

import ezeon.capp.db.jdbcTemplate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestFatching {

   
    public static void main(String[] args) throws SQLException {
        
        jdbcTemplate jt=new jdbcTemplate();
        String sql="SELECT userId,name from user WHERE loginName=? AND password=?";
        PreparedStatement pst=jt.pst(sql);
        pst.setString(1,"aaa");
        pst.setString(2,"aa123");
         
        ResultSet rs=jt.query(pst);
        if(rs.next()){
            System.out.println("Login Success");
           System.out.print(rs.getInt("userId")+" "+rs.getString("name"));
        }else{
          System.out.print("Login faild");  
        }
    }
    
}
