package com.bean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ducat.pojo.Addmission;
import in.ducat.pojo.Student;

public class Controller {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Student student = new Student();
        Addmission addmission=new Addmission();
        
        addmission.setCourse("MCA");
        addmission.setFees(3500);
        
       
        student.setName("Rohan");
        student.setSalary(5000);
       
 
      Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(addmission);
        System.out.println("Object saved successfully.....!!");
       tx.commit();
        session.close();
        factory.close();

	}

}
