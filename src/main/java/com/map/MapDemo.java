package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Lazy;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
//        //creating questions
//        Question q1=new Question();
//        q1.setQuestionId(1212);
//        q1.setQuestion("what is java ?");
//        
//        //creating answer
//        Answer answer=new Answer();
//        answer.setAnswerId(343);
//        answer.setAnswer("Java is programming language");
//        answer.setQuestion(q1);
//       
//        Answer answer1=new Answer();
//        answer1.setAnswerId(33);
//        answer1.setAnswer("with help of java we can create softwares");
//        answer1.setQuestion(q1);
//        
//        Answer answer2=new Answer();
//        answer2.setAnswerId(363);
//        answer2.setAnswer("Java has differents types of frameworks");
//        answer2.setQuestion(q1);
//        
//        List<Answer> list = new ArrayList<Answer>();
//        list.add(answer);
//        list.add(answer1);
//        list.add(answer2);
//        q1.setAnswers(list);
//        
      //creating questions
        
          
        //session
        
        Session s=factory.openSession();
        
        Transaction tx=s.beginTransaction();
        
        //save
       
//        s.save(q1);
//        s.save(answer);
//        s.save(answer1);
//        s.save(answer2);
        
         Question q=(Question)s.get(Question.class, 1212);
         
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
  
        System.out.println(q.getAnswers().size());
        
        // fetching........
 //       Question newQ = (Question) s.get(Question.class, 242);
 //       System.out.println(newQ.getQuestion());
 //       System.out.println(newQ.getAnswer().getAnswer());
 //       
        s.close();
        
        factory.close();
	}

}
