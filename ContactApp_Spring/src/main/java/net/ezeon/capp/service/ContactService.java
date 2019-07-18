
package net.ezeon.capp.service;

import java.util.List;
import net.ezeon.capp.domain.Contact;
import net.ezeon.capp.rm.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void save(Contact c) {
        String sql = "INSERT INTO contact(`userId`, `name`, `phone`, `email`, `address`, `remark`) VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, c.getUserId(), c.getName(), c.getPhone(), c.getEmail(), c.getAddress(), c.getRemark());
    }

    public void update(Contact contactId) {
        String sql="UPDATE contact SET name=?,phone=?,email=?,address=?,remark=? WHERE contactId=?";
        jdbcTemplate.update(sql,contactId.getName(),contactId.getPhone()
                ,contactId.getEmail(),contactId.getAddress(),contactId.getRemark(),contactId.getContactId());

    }

    public void delContactList(int contactId) {
        String sql="DELETE FROM contact WHERE contactId=?";
       jdbcTemplate.update(sql,contactId);

    }

    public void delete(int... contactIds) {

    }

    public Contact findById(int contactId) {
          String sql = "SELECT `contactId`, `userId`, `name`, `phone`, `email`, `address`, `remark` FROM contact WHERE `contactId`=?";
        return jdbcTemplate.queryForObject(sql, new ContactRowMapper(),contactId);

        
    }

    public List<Contact> findByUserId(int userId) {
        String sql = "SELECT `contactId`, `userId`, `name`, `phone`, `email`, `address`, `remark` FROM contact WHERE `userId`=?";
        return jdbcTemplate.query(sql, new ContactRowMapper(), userId);
    }
    
    public List<Contact>search(int userId, String criteria) {
        

       String sql = "SELECT `contactId`, `userId`, `name`, `phone`, `email`, `address`, `remark` FROM contact WHERE "
               + "(`userId`=?) AND (name LIKE '%"+criteria+"%' OR phone LIKE '%"+criteria+"%' OR email LIKE '%"+criteria+"%' OR address LIKE '%"+criteria+"%' OR remark LIKE '%"+criteria+"%')";
        return jdbcTemplate.query(sql, new ContactRowMapper(), userId);
    }

}
