/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.capp.service;

import ezeon.capp.domain.Contact;
import java.sql.SQLException;
import java.util.List;

/**
 *this interface contains method to manage contact(,save edit search delete)
 * @author Anurag
 */
public interface ContactService {
    
    public void save(Contact c)throws SQLException;
    public void update(Contact c)throws SQLException;
    
    /**
     * this method update a single value for given record id(contactID)
     * @param column field 
     * @param value new value for above column /field
     * @param contactId primary key
     * @throws SQLException 
     */
    public void update(String column,Object value,Integer contactId)throws SQLException;
    public void delete(Contact c)throws SQLException;
    public void delete(Integer contactId)throws SQLException;
    public Contact findById(Integer userId)throws SQLException;
    public List<Contact> findAll()throws SQLException;
   
  
    public List<Contact> findByUserId(Integer userId)throws SQLException;
 /**
  * free text search for loged in user-contacts
  * @param userId
  * @param text seatch based on text input 
  * @return
  * @throws SQLException 
  */
    public List<Contact> find(Integer userId,String text)throws SQLException;
    
   
}
