package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.modal.Answer;
import com.modal.Question;

import jakarta.transaction.Transaction;

public class HqlExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		// List <Question> student = session.createQuery("from Question").setFirstResult(0).setMaxResults(2).getResultList();
		List <Question> student = session.createQuery("from Question").getResultList();
		
		for(Question s : student) {
			System.out.println(s.getQuestion());
			List<Answer> ans = s.getAnswer();
			for(Answer a: ans) {
				System.out.println(a.getAnswer());
				
			}
		}
		
		session.close();
		
		//select date
		Session session2 = factory.openSession();
		
		Query query = session2.createQuery("from Question where id=:qid");
		query.setParameter("qid", 1);
		
		Question que = (Question) query.uniqueResult();
		
		System.out.println(que.getQuestion());
		
		session2.close();
		
		//update date
		Session session3 = factory.openSession();
		
		Question question = session3.get(Question.class, 1);
		
		Query<Answer> query2 = session3.createQuery("UPDATE Question SET question = :updatedQuestion WHERE id = :qid");
		query2.setParameter("updatedQuestion", "updated question");
		query2.setParameter("qid", question.getQuestionId());

		org.hibernate.Transaction transaction = session3.beginTransaction();
		int executeUpdate = query2.executeUpdate();
		transaction.commit();
		
		session3.close();
		
		factory.close();
	}
}
	