/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.e.manager;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


public class ReportService {
   Repository repo= Repository.getRepository();
   public Map<String,Float> calculateMonthlyTotal(){
       Map<String,Float> m=new TreeMap<>();
       for (Expense exp : repo.expList) {
          Date expDate= exp.getDate();
          String yearsMonth=DateUtil.getYearsAndMonth(expDate);
          if(m.containsKey(yearsMonth)){
             Float total= m.get(yearsMonth);
             total=total+exp.getAmount();
             m.put(yearsMonth, total);
          }else{
           //m.put(yearsMonth,exp.getAmount());
          }
           
       }
    return m;   
   }
}
