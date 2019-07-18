/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.capp.service;

import ezeon.capp.db.jdbcTemplate;
import ezeon.capp.domain.Contact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anurag
 */
public class ContactServiceImpl extends jdbcTemplate implements ContactService{

    public void save(Contact c) throws SQLException {
        String sql="INSERT INTO contact ( `userId`, `name`, `phone`, `email`, `address`, `remark`)VALUES(?,?,?,?,?,?)";
        PreparedStatement pst=pst(sql);
        pst.setInt(1,c.getUserId());
        pst.setString(2,c.getName());
        pst.setString(3,c.getPhone());
        pst.setString(4,c.getEmail());
        pst.setString(5,c.getAddress());
        pst.setString(6,c.getRemark());
        super.update(pst);
        
    }

    @Override
    public void update(Contact u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Contact u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer contactId) throws SQLException {
        super.update("DELETE FROM contact WHERE contactId="+contactId);
    }

    @Override
    public Contact findById(Integer contactId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> findByUserId(Integer userId) throws SQLException{
       String sql="SELECT contactId,name,phone,email"
               + ",address,remark,userId FROM contact WHERE userId=?";
       PreparedStatement pst=pst(sql);
       pst.setInt(1,userId);
        ResultSet rs=super.query(pst);
        List<Contact> list=new ArrayList();
        while(rs.next()){
            Contact c=this.mapContact(rs);
            list.add(c);
        }
        
        return list;
    }
//the method map resultset record to domain object return domain object 
 public Contact mapContact(ResultSet rs)throws SQLException{
     Contact c=new Contact();
     c.setContactId(rs.getInt("contactid"));
     c.setName(rs.getString("name"));
     c.setPhone(rs.getString("phone"));
     
     c.setEmail(rs.getString("email"));
     c.setAddress(rs.getString("address"));
     c.setRemark(rs.getString("remark"));
     c.setUserId(rs.getInt("userId"));
     return c;
     
     
     
 }

    @Override
    public void update(String column, Object value, Integer contactId) throws SQLException {
        String sql="UPDATE contact SET"+column+"=? WHERE  contactId=?";
        PreparedStatement  pst=super.pst(sql);
        pst.setString(1,value.toString());
        pst.setInt(2,contactId);
        super.update(pst);
        
    }

    @Override
    public List<Contact> find(Integer userId, String text) throws SQLException {
         String sql="SELECT contactId,name,phone,email"
               + ",address,remark,userId FROM contact WHERE userId=? AND ( name LIKE('%"+text+"%')OR phone LIKE('%"+text+"%')OR email LIKE('%"+text+"%')OR address LIKE('%"+text+"%')OR remark LIKE('%"+text+"%') )";
         
       PreparedStatement pst=pst(sql);
       pst.setInt(1,userId);
        ResultSet rs=super.query(pst);
        List<Contact> list=new ArrayList();
        while(rs.next()){
            Contact c=this.mapContact(rs);
            list.add(c);
        }
        
        return list;
   
    }
    
}
