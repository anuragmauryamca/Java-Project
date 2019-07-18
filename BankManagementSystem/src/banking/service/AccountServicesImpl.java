/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.service;

import banking.domain.Balance;
import banking.domain.NewAccount;
import banking.jdb.JdbcTemplete;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


public class AccountServicesImpl extends JdbcTemplete implements AccountServices{

    @Override
    public NewAccount byName(Integer account_number) throws SQLException {
       String sql="SELECT *FROM newaccount WHERE account_number=?";
       PreparedStatement pst=super.pst(sql);
       pst.setInt(1,account_number);
     
        ResultSet rs= super.query(pst);
        NewAccount c=new NewAccount();
        
      while(rs.next()){
//          System.out.println(rs.getInt("account_number"));
//          System.out.println("find account");
//          JOptionPane.showMessageDialog(null,"success");
//          System.out.println(rs.getString("name"));
    
     c.setAccount_number(rs.getInt("account_number"));
     c.setName(rs.getString("name"));
     c.setDob(rs.getString("dob"));
     
     c.setAccounttype(rs.getString("accounttype"));
     c.setNationality(rs.getString("nationality"));
     c.setCategory(rs.getString("Category"));
     c.setMobile(rs.getInt("mobile"));
     c.setAddress(rs.getString("address"));
     c.setSecurityq(rs.getString("securityq"));
   
          
      }
      return c;
    }

     
          


//    public List<NewAccount> byName(String name) throws SQLException {
//            String sql="SELECT *FROM newaccount WHERE name=?";
//       PreparedStatement pst=super.pst(sql);
//       pst.setString(1,name);
//     
//        ResultSet rs= super.query(pst);
//       List<NewAccount> list=new ArrayList();
//      while(rs.next()){
//          NewAccount na=this.mapAccount(rs);
//          list.add(na);
//      }
//       
//      return list; 
//    }
//     public NewAccount mapAccount(ResultSet rs)throws SQLException{
//     NewAccount c=new NewAccount();
//     c.setAccount_number(rs.getInt("account_number"));
//     c.setName(rs.getString("name"));
//     c.setDob(rs.getString("dob"));
//     
//     c.setAccounttype(rs.getString("accounttype"));
//     c.setNationality(rs.getString("nationality"));
//     c.setCategory(rs.getString("Category"));
//     c.setMobile(rs.getInt("mobile"));
//     c.setAddress(rs.getString("address"));
//     c.setSecurityq(rs.getString("securityq"));
//     return c;
//     
//     
//     
// }

    @Override
    public void upDateByAcc(NewAccount na) throws SQLException {
       String sql="UPDATE newaccount SET nationality=?,category=?,mobile=?,address=?  WHERE account_number=?";
       PreparedStatement pst=super.pst(sql);
       pst.setString(1,na.getNationality() );
       pst.setString(2,na.getCategory());
       pst.setInt(3, na.getMobile());
       pst.setString(4,na.getAddress());
       pst.setInt(5, na.getAccount_number());
       super.update(pst);
       JOptionPane.showMessageDialog(null,"UpdateSuccessfully");
    }

    @Override
    public Balance  searchByname(String name) throws SQLException {
        //System.out.println("name---->"+name);
        String sql="SELECT *FROM balance WHERE name=?";
        PreparedStatement pst=super.pst(sql);
        pst.setString(1,name);
        ResultSet rs=super.query(pst);
       Balance bl=new Balance();
        if(rs.next()){
            
           bl.setAccount_number(rs.getInt("account_number"));
           bl.setName(rs.getString("name"));
           bl.setBalance(rs.getFloat("balance"));
           
        }
        else{
            JOptionPane.showMessageDialog(null,"Name is Not Match ");
        }
       return  bl;
    }

    @Override
    public void depositAmount(Integer account_number,float balance) throws SQLException {
       /**------Account number and Total Amount are get  here..?
        *  System.out.println("account number=="+account_number); 
        System.out.println("total balance=="+balance);
        */
       try{
        String sql="UPDATE balance SET balance=? WHERE account_number=?";
       PreparedStatement pst=super.pst(sql);
       pst.setFloat(1, balance);
       pst.setInt(2,account_number);
       
       super.update(pst);
       JOptionPane.showMessageDialog(null,"Deposit Successfully ");
       }catch(NullPointerException ex){
           JOptionPane.showMessageDialog(null,"Empty Amount");
       }
       
    }

    @Override
    public Balance allAccount() throws SQLException {
       String sql="SELECT *FROM balance";
       PreparedStatement pst=super.pst(sql);
       ResultSet rs=super.query(pst);
       Balance bl=new Balance();
        //List<Balance> ac=new ArrayList();
       while(rs.next()){
           bl.setAccount_number(rs.getInt("account_number"));
           //System.out.println(rs.getInt("account_number"));
          // ac.add(bl);
       }
        return bl;
        
    }
    /**
     * 
     * @param account_number
     * @return Balance To the Deposit Amount form exiting Account
     * Here first of all we are send a account_number then fatching the current balance
     * and then deposit the amount 
     * @throws SQLException 
     */
    @Override
    public Balance getBalanceExitAccount(Integer account_number) throws SQLException {
       // System.out.println("Data find in service layer"+account_number);
         String sql="SELECT balance FROM balance WHERE account_number=?";
        PreparedStatement pst=super.pst(sql);
        pst.setInt(1,account_number);
        ResultSet rs=super.query(pst);
        
        
       Balance blnc=new Balance();
       if(rs.next()){
//          bl.setBalance(rs.getFloat("balance"));
        //  System.out.println("------"+rs.getFloat("balance"));
        blnc.setBalance(rs.getFloat("balance"));
       }else{
           JOptionPane.showMessageDialog(null,"Zero Amount");
       }
       return blnc;
    }

    @Override
    public void transferDepositBalance(Integer account_number,Float amount) throws SQLException {
          try{
        String sql="UPDATE balance SET balance=? WHERE account_number=?";
       PreparedStatement pst=super.pst(sql);
      pst.setFloat(1, amount);
       pst.setInt(2,account_number);
        
       
       super.update(pst);
       
      JOptionPane.showMessageDialog(null,"Transfer Successfully ");
       }catch(NullPointerException ex){
           JOptionPane.showMessageDialog(null,"Empty Amount");
       }
    }

    @Override
    public void oftertransferCreditBalance(Integer account_number, Float amount) throws SQLException {
          try{
        String sql="UPDATE balance SET balance=? WHERE account_number=?";
       PreparedStatement pst=super.pst(sql);
      pst.setFloat(1, amount);
       pst.setInt(2,account_number);
        
       
       super.update(pst);
      
       }catch(NullPointerException ex){
           ex.printStackTrace();
       }
    }

    @Override
    public Balance searchByNameToWithDrawl(String name) throws SQLException {
         Balance bl=new Balance();
        try{
        String sql="SELECT *FROM balance WHERE name=?";
        PreparedStatement pst=super.pst(sql);
        pst.setString(1,name);
        ResultSet rs=super.query(pst);
      
        if(rs.next()){
            
           bl.setAccount_number(rs.getInt("account_number"));
           bl.setName(rs.getString("name"));
           bl.setBalance(rs.getFloat("balance"));
           
        }
        
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Name is Not Match ");
        }
        
        
          return bl;
    }

    @Override
    public void withdrawlAmount(Integer account_number, float balance) throws SQLException {
        try{
        String sql="UPDATE balance SET balance=? WHERE account_number=?";
       PreparedStatement pst=super.pst(sql);
       pst.setFloat(1, balance);
       pst.setInt(2,account_number);
       
       super.update(pst);
       JOptionPane.showMessageDialog(null,"Withdrawl Successfully ");
       }catch(NullPointerException ex){
           JOptionPane.showMessageDialog(null,"Empty Amount");
       }
    }

    @Override
    public TableModel customerList() throws SQLException {
        String sql="select name,account_number,pin,accounttype,mobile,address from newaccount";
        PreparedStatement pst=super.pst(sql);
        ResultSet rs=super.query(pst);
        
        TableModel tm= (DbUtils.resultSetToTableModel(rs));
        return tm;
    }

    @Override
    public TableModel transctionList() throws SQLException {
         String sql="select `micr_no`, `balance`, `name`, `account_number` from balance";
        PreparedStatement pst=super.pst(sql);
        ResultSet rs=super.query(pst);
        
        TableModel tm2= (DbUtils.resultSetToTableModel(rs));
        return tm2;
    }

    @Override
    public Balance viewBalance(String name) throws SQLException {
         String sql="SELECT *FROM balance WHERE name=?";
        PreparedStatement pst=super.pst(sql);
        pst.setString(1,name);
        ResultSet rs=super.query(pst);
       Balance bl=new Balance();
        if(rs.next()){
            
           bl.setAccount_number(rs.getInt("account_number"));
           bl.setName(rs.getString("name"));
           bl.setBalance(rs.getFloat("balance"));
           bl.setMicr_no(rs.getInt("micr_no"));
           
        }
        else{
            JOptionPane.showMessageDialog(null,"Name is Not Match ");
        }
       return  bl;
    }

    @Override
    public NewAccount chnagedPin(Integer oldpin,Integer newpin) throws SQLException {
        System.out.println("old--------"+oldpin);
        System.out.println("new--------"+newpin);
        try{
           String sql="UPDATE newaccount SET pin=? WHERE pin=?";
           PreparedStatement pst=super.pst(sql);
            pst.setInt(1, newpin);
           pst.setInt(2, oldpin);
          
           super.update(pst);
            JOptionPane.showMessageDialog(null,"successfully pin changed");
        }catch(Exception e){
            
        }
        return null;
    }

    
}//close class

