package com.hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Answer;
import com.modal.Certificate;
import com.modal.Question;
import com.modal.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started ..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // create modal object
        // start session using sessionFactory
        // create transaction object 
        // session save commite and close
        
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("raj");
        s1.setCity("Jamnagar");
        
        Certificate cer = new Certificate();
        cer.setCourse("Liferay");
        cer.setDuration("4 week");
        s1.setC(cer);
        
        Session s = factory.openSession();
        
        Transaction tx = s.beginTransaction();
        
        s.save(s1);
        
        tx.commit();
        
        s.close();
        
    }
}
