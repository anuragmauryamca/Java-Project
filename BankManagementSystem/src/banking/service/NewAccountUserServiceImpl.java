
package banking.service;

import banking.domain.Balance;
import banking.domain.NewAccount;
import banking.jdb.JdbcTemplete;
import gui.Home;
import gui.LoginUser;
import gui.ProcessBar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sun.tools.jar.resources.jar;


public class NewAccountUserServiceImpl extends JdbcTemplete implements NewAccountUserService{

    @Override
    
    public void registrations(NewAccount na) {
        try {
            //JdbcTemplete jt=new JdbcTemplete();
            
            String sql="INSERT INTO newaccount(`account_number`, `name`, `micrno`,"
                    + " `dob`, `pin`,`nationality`,`accounttype`,`category`,"
                    + "`mobile`,`address`,`securityq`,`answer`,`amount` )VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=super.pst(sql);
            pst.setInt(1,na.getAccount_number());
            pst.setString(2,na.getName());
            pst.setInt(3,na.getMicrno());
            pst.setString(4,na.getDob());
            pst.setInt(5,na.getPin());
           pst.setString(6,na.getNationality());
            pst.setString(7,na.getAccounttype());
            pst.setString(8,na.getCategory());
           // pst.setString(9,na.getGender());
            pst.setInt(9,na.getMobile());
            pst.setString(10,na.getAddress());
            pst.setString(11,na.getSecurityq());
            pst.setString(12,na.getAnswer());
            pst.setInt(13,na.getAmount());
               super.update(pst);
            
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    } 

    @Override
    public void balance(Balance bl) {
        try {
            String sql="INSERT INTO balance(`account_number`, `name`,`balance`, `micr_no`,`pin`)VALUES(?,?,?,?,?)";
            PreparedStatement pst=super.pst(sql);
            pst.setInt(1,bl.getAccount_number());
            pst.setString(2,bl.getName());
            pst.setFloat(3,bl.getBalance());
            pst.setInt(4,bl.getMicr_no());
            pst.setInt(5,bl.getPin());
            super.update(pst);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public NewAccount authentication(Integer account_number, Integer pin) throws SQLException {
        
        String sql="SELECT *FROM newaccount WHERE account_number=? AND pin=?";
       PreparedStatement pst=super.pst(sql);
       pst.setInt(1,account_number);
       pst.setInt(2,pin);
        ResultSet rs= super.query(pst);
        NewAccount na=new NewAccount();
        if(rs.next()){
            Integer uc=rs.getInt("account_number");
            Integer up=rs.getInt("pin");
//            Home home=new Home();
//            home.setVisible(true);
           
//            
//            LoginUser loginUser=new LoginUser();
//            loginUser.setVisible(false);
//
//        ProcessBar processBar=new ProcessBar();//jProgressbar start
//        processBar.setUploading();
//        processBar.setVisible(true);//jProgressbar Close
           NewAccount u=findById(uc);
                return u;
      
        }else{
          JOptionPane.showMessageDialog(null,"Invalid Crenditional");
        }
        return null;
       
       
    }

    @Override
    public NewAccount findById(Integer account_number) throws SQLException {
        String sql="SELECT account_number,pin,mobile FROM newaccount WHERE account_number=?";
        PreparedStatement pst=super.pst(sql);
        pst.setInt(1,account_number);
        ResultSet rs=super.query(pst);
        if(rs.next()){
            NewAccount u=this.mapUser(rs);
            return u;
        }else{
            return null;
        }
    }
    
      public NewAccount mapUser(ResultSet rs)throws SQLException{
        NewAccount u=new NewAccount();
        u.setAccount_number(rs.getInt("account_number"));
        u.setPin(rs.getInt("pin"));
       
         return u;
    }

}
