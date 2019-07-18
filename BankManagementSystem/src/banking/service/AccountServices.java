/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.service;

import banking.domain.Balance;
import banking.domain.NewAccount;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.TableModel;

public interface AccountServices {
    //public List<NewAccount> byName(String name)throws SQLException;
    public NewAccount byName(Integer account_number)throws SQLException;
    public void  upDateByAcc(NewAccount name)throws SQLException;
    public Balance searchByname(String name)throws SQLException;
    public Balance searchByNameToWithDrawl(String name)throws SQLException;
    public void depositAmount(Integer account_number,float balance)throws SQLException;
    public void withdrawlAmount(Integer account_number,float balance)throws SQLException;
    public Balance allAccount()throws SQLException;//show in combobox
    public Balance getBalanceExitAccount(Integer account_number)throws SQLException;
    public void transferDepositBalance(Integer account_number,Float amount)throws SQLException;
    public void oftertransferCreditBalance(Integer account_number,Float amount)throws SQLException;
   public TableModel customerList()throws SQLException;
   public TableModel transctionList()throws SQLException;
   public Balance viewBalance(String name)throws SQLException;
   public NewAccount chnagedPin(Integer oldpin,Integer newpin)throws SQLException;
}

