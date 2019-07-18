/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package ezeon.capp.service;

import ezeon.capp.db.jdbcTemplate;
import ezeon.capp.domain.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anurag
 */
public class UserServiceImpl extends jdbcTemplate implements UserService{

    @Override
    public void register(User u)throws SQLException {
       
        String sql="INSERT INTO user(`name`, `phone`, `email`, `address`,"
                + " `loginName`, `password`, `role`, `status`)VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst=super.pst(sql);
        pst.setString(1,u.getName());
        pst.setString(2,u.getPhone());
        pst.setString(3,u.getEmail());
        pst.setString(4,u.getAddress());
        pst.setString(5,u.getLoginName());
        pst.setString(6,u.getPassword());//
        pst.setInt(7,u.getRole());//user role
        pst.setInt(8,u.getStatus());//active status
        super.update(pst); 
    }

    @Override
    public User authenticate(String loginName, String password) throws UserBlockException, SQLException {
        String sql="SELECT userId,status FROM user WHERE loginName=? AND password=?";
       PreparedStatement pst=super.pst(sql);
       pst.setString(1,loginName);
       pst.setString(2,password);
        ResultSet rs=super.query(pst);
        if(rs.next()){
            Integer userId=rs.getInt("userId");
             Integer status=rs.getInt("status");
            
            //success 1 Active 2 Block
            if(status.equals(1)){
                //active
                User u=findById(userId);
                return u;
            }else if(status.equals(2)){
                String errMsg="Yout account is Block Please contact Admin Service";
                UserBlockException ex=new UserBlockException(errMsg);
                throw ex;
            }else{
                return null;
            }
        }else{
            //faild
            return null;
        }
      
       }
    
    public User findById(Integer userId)throws SQLException{
        String sql="SELECT userId,name,phone,email,address,role,status FROM user WHERE userId=?";
        PreparedStatement pst=super.pst(sql);
        pst.setInt(1,userId);
        ResultSet rs=query(pst);
        if(rs.next()){
            User u=this.mapUser(rs);
            return u;
        }else{
            return null;
        }
    }
    public User mapUser(ResultSet rs)throws SQLException{
        User u=new User();
        u.setUserId(rs.getInt("userId"));
         u.setName(rs.getString("name"));
         u.setPhone(rs.getString("phone"));
         u.setEmail(rs.getString("email"));
         u.setAddress(rs.getString("address"));
         u.setRole(rs.getInt("role"));
         u.setStatus(rs.getInt("status"));
         return u;
    }

   
    
}

// class m{
//    
//             public void main(String arg[]) throws UserBlockException, SQLException{
//                  UserServiceImpl n=new UserServiceImpl();
//                  
//           User u= n.authenticate("Anu","a123");
//                 System.out.println("UserId="+u.getUserId());
//                 System.out.println("status="+u.getName());
//             }
//             }