/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curd.pojo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Amit Upadhyay
 */

public class DaoUser {
    public static Connection getConnection()
    { Connection con=null;
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mycurd","root","root");
            System.out.println("Success");
    }catch(Exception e)
    {
        e.printStackTrace();
    }
        return con;
    }
    public void saveUser(Auth u)
    {
        try{
        Connection con=getConnection();
        String sql="insert into auth(id,name,email,password)values(?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1,u.getId());
        pst.setString(2,u.getName());
        pst.setString(3,u.getEmail());
        pst.setString(4,u.getPassword());
        
        pst.executeUpdate();
        con.close();
        pst.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
//        public static void main(String arg[])
//        {
//            DaoUser daoUser=new DaoUser();
//            daoUser.saveUser();
//        }
//        
    
  
}
