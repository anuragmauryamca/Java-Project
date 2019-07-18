/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.e.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DateUtil {
    public static Date toStringDate(String formate){
        SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sf.parse(formate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
        public static String dateToString(Date date){
        SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
       
            return sf.format(date);
       
           
        }
       
        public static String getYearsAndMonth(Date date){
        SimpleDateFormat sf=new SimpleDateFormat("yyyy,MMM");
       
            return sf.format(date);
       
           
        }
       
    
    
}
