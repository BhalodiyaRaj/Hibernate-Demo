package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Answer;
import com.modal.Question;

public class ManyToManyDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		// Question objects
		Question que = new Question(0, null, null);
        que.setQuestionId(1);
        que.setQuestion("que");
        
        Question que1 = new Question(0, null, null);
        que1.setQuestionId(2);
        que1.setQuestion("que1");
        
        //Answer objects
        Answer ans = new Answer();
        ans.setAnswerId(1);
        ans.setAnswer("ans");
        
        Answer ans1 = new Answer();
        ans1.setAnswerId(2);
        ans1.setAnswer("ans1");
        
        Answer ans2 = new Answer();
        ans2.setAnswerId(3);
        ans2.setAnswer("ans2");
        
        Answer ans3 = new Answer();
        ans3.setAnswerId(5);
        ans3.setAnswer("ans3");
        
        Answer ans4 = new Answer();
        ans4.setAnswerId(4);
        ans4.setAnswer("ans4");
        
        // make list for mapping
        List<Answer> ansList = new ArrayList<Answer>();
        ansList.add(ans);
        ansList.add(ans1);
        ansList.add(ans2);
        ansList.add(ans3);
        
        List<Answer> ansList2 = new ArrayList<Answer>();
        ansList2.add(ans4);
        ansList2.add(ans3);
        ansList2.add(ans2);
        
        List<Question> List1 = new ArrayList<Question>();
        List1.add(que1);
        List1.add(que);
        
        // set list
        que.setAnswer(ansList);
        que.setAnswer(ansList2);
        
        ans2.setQuestion(List1);
        ans3.setQuestion(List1);
        
        // create session
        Session session = factory.openSession();
        
        // create Transaction
        Transaction trans = session.beginTransaction();
        
        session.persist(que);
        session.persist(que1);
        
        // commit Transaction
        trans.commit();
        
        Question question = session.get(Question.class, 1);
        
        // print data which from database
        System.out.println(question.getQuestion());
        for (Answer answer : question.getAnswer()) {
			System.out.println(answer.getAnswer());
		}
        
        // close session
        session.close();
	}
	
}
