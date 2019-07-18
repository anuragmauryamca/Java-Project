/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.utilTest;

/**
 *
 * @author Anurag
 */
public class Random {

  
    public static void main(String[] args) {
        
       java.util.Random r=new java.util.Random();
       int b=r.nextInt(4645);
        System.out.println(""+b);
       //txtMircNo.setText(String.valueOf(b));
    }
    
    
}