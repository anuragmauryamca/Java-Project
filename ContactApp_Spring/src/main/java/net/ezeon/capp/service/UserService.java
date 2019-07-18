package net.ezeon.capp.service;

import java.util.List;
import net.ezeon.capp.domain.User;
import net.ezeon.capp.rm.UserRowMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * The service handle user related operations.
 * @author Vikram
 */
@Service
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    public static final int LOGIN_STATUS_ACTIVE=1;
    public static final int LOGIN_STATUS_BLOCKED=2;
    
    public static final int ROLE_ADMIN=1;
    public static final int ROLE_USER=2;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void userRegistration(User u){
        String sql = "INSERT INTO "
                + "user(name, phone, email, address, loginName,"
                + " password, role, status) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, u.getName(), u.getPhone(), u.getEmail(),u.getAddress(), u.getLoginName(),u.getPassword(),u.getRole(),u.getStatus());        
    }
    
    /**
     * The method authenticates the user for given credentials.<br/> 
     * It returns User object when success and returns null when failed.<br/> 
     *  
     * @param loginName
     * @param password
     * @return 
     */
   public User authenticate(String loginName, String password) 
            throws UserBlockedException
    {
        String sql = "SELECT `userId`, `name`, `phone`, `email`, `address`, `loginName`, `role`, `status` FROM user WHERE loginName=? AND password=?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper() , loginName, password);        
        logger.info("login user : "+ users);
        if(!users.isEmpty()){           
            User successUser = users.get(0);
            if(successUser.getStatus()==UserService.LOGIN_STATUS_ACTIVE){
                return successUser;
            }else if(successUser.getStatus()==UserService.LOGIN_STATUS_BLOCKED){
                //throw an exception to represent the problem
                String err = "The user is blocked : "+ loginName;
                UserBlockedException ex = new UserBlockedException(err);
                throw ex;
            }
        }        
        return null;        
    }
   public List<User> findAll(){
        String sql = "SELECT `userId`, `name`, `phone`, `email`, `address`, `loginName`, `role`, `status` FROM user ORDER BY name asc";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper()); 
       return users;
   }
   public void changeStatus(Integer userId,Integer status){
      String sql="UPDATE user SET status=? WHERE userId=?";
      jdbcTemplate.update(sql, status,userId);
           
   }
    
}
