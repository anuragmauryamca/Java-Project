/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.capp.service;

import ezeon.capp.domain.User;
import java.sql.SQLException;

/**
 *t
 * @author Anurag
 */
public interface UserService {
    public static final int ROLE_ADMIN=1;
    public static final int ROLE_USER=2;
    public static final int STATUS_ACTIVE=1;
    public static final int STATUS_BLOCKED=2;
    
    
    public void register(User u)throws SQLException;
    public User authenticate(String loginName,String password)throws UserBlockException,SQLException;
        public User findById(Integer userId)throws SQLException;
    
    
}
