package in.ezeon.hibernate;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoServices {
	
	public static void main(String arg[])
	{
		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
				SessionFactory sf=cfg.buildSessionFactory();
			 Session ses=sf.openSession();
			 
			 Transaction tx=ses.beginTransaction();
			 
			 Student stu=new Student();
			 stu.setId(11);
			 stu.setName("Rohan");
			 stu.setAddress("Varanasi");
			 
			 ses.save(stu);
			 System.out.println("Data Saved Successfully");
			 tx.commit();
			 ses.close();
			 sf.close();
			 
	}

}
