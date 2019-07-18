
package banking.service;

import banking.domain.Balance;
import banking.domain.NewAccount;
import java.sql.SQLException;


public interface NewAccountUserService {
    public void balance(Balance bl);
    public void registrations(NewAccount na);
   
    public NewAccount authentication(Integer account_number,Integer pin)throws SQLException;
     public NewAccount findById(Integer account_number)throws SQLException;
}


