package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student student1=new Student();
        student1.setId(1015);
        student1.setName("Pandurang Hande");
        student1.setCity("Pandharpur");
        
        Certificate certificate=new Certificate();
        certificate.setCourse("Springboot");
        certificate.setDuration("6 Months");
        student1.setCerti(certificate);
        
        
        Student student2=new Student();
        student2.setId(1011);
        student2.setName("Rohini Hande");
        student2.setCity("Shirur");
        
        Certificate certificate1=new Certificate();
        certificate1.setCourse("FullStack");
        certificate1.setDuration("10 Months");
        student2.setCerti(certificate1);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        //object save:
        s.save(student1);
        s.save(student2);
        
        tx.commit();
        s.close();
        factory.close();
	}

}
