package com.orm.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestForSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        CreditCard c=new CreditCard();

        c.setPaymentId(11);
        c.setAmount(2500);
        c.setCreditCardType("Visa");

        Cheque c1=new Cheque();

        c1.setPaymentId(10);
        c1.setAmount(2600);
        c1.setChequeType("ICICI");

        Transaction tx = session.beginTransaction();
        session.save(c);
        session.save(c1);
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
    

	}

}
