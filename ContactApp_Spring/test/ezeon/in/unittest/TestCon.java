/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeon.in.unittest;

import ezeon.capp.db.jdbcTemplate;

/**
 *
 * @author Anurag
 */
public class TestCon {

  
    public static void main(String[] args) {
     
        jdbcTemplate obj=new jdbcTemplate();
        System.out.println("connection Successfully"+obj.testCon());
    }
    
}
