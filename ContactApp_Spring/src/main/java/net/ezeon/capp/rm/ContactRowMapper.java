package net.ezeon.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.ezeon.capp.domain.Contact;
import net.ezeon.capp.domain.User;
import org.springframework.jdbc.core.RowMapper;

/**
 * Map one ResultSet record with one domain object "User".
 * @author Vikram
 */
public class ContactRowMapper implements RowMapper<Contact>{
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact c = new Contact();
        c.setUserId(rs.getInt("userId")); //FK
        c.setName(rs.getString("name"));
        c.setPhone(rs.getString("phone"));
        c.setEmail(rs.getString("email"));
        c.setAddress(rs.getString("address"));
        c.setContactId(rs.getInt("contactId"));        
        c.setRemark(rs.getString("remark"));        
        return c;
    }
}
