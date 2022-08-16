package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException
    {
        System.out.println( "Project Started.." );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
       //crating student
        Student st=new Student();
        st.setId(102);
        st.setName("Rohini");
        st.setCity("Banglore");
        System.out.println(st);
        
        //crating object of address class
        
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        // Reading image
        FileInputStream fis=new FileInputStream("src/main/java/Mypic.png");
        byte[] data=new byte[fis.available()];
        fis.read();
        ad.setImage(data);
        
        
        Session session = factory.openSession();
        
        Transaction   tx=session.beginTransaction();
        
        session.save(st);
        session.save(ad);
        
        tx.commit();
        
        session.close();
        
       System.out.println("Done..");
        
    }
}
