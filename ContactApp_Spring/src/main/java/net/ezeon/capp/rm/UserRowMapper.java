package net.ezeon.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.ezeon.capp.domain.User;
import org.springframework.jdbc.core.RowMapper;

/**
 * Map one ResultSet record with one domain object "User".
 * @author Vikram
 */
public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setEmail(rs.getString("email"));
        u.setAddress(rs.getString("address"));
        u.setLoginName(rs.getString("loginName"));
        //u.setPassword("amit123");
        u.setRole(rs.getInt("role"));
        u.setStatus(rs.getInt("status")); 
        return u;
    }
}
